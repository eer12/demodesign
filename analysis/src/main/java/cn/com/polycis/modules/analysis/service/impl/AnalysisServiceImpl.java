package cn.com.polycis.modules.analysis.service.impl;

import cn.com.polycis.common.mqtts.RabbitMQUtilForApp;
import cn.com.polycis.common.utils.HttpClient;
import cn.com.polycis.modules.analysis.classifyDeal.ClassifyFactory;
import cn.com.polycis.modules.analysis.classifyDeal.Processor;
import cn.com.polycis.modules.analysis.dao.AnalysisMapper;
import cn.com.polycis.modules.analysis.entity.AnalysisParameter;
import cn.com.polycis.modules.analysis.entity.AnalysisRule;
import cn.com.polycis.modules.analysis.entity.InfoAndInstruct;
import cn.com.polycis.modules.analysis.entity.PushDataEntity;
import cn.com.polycis.modules.analysis.service.AnalysisService;
import cn.com.polycis.modules.analysis.util.ByteUtil;
import cn.com.polycis.modules.application.entity.HttpInfo;
import cn.com.polycis.modules.application.entity.MqInfo;
import cn.com.polycis.modules.application.service.IHttpInfoService;
import cn.com.polycis.modules.application.service.IMqInfoService;
import cn.com.polycis.modules.dev.entity.DeviceUplinkData;
import cn.com.polycis.modules.dev.entity.UnionDevice;
import cn.com.polycis.modules.dev.service.IDeviceUplinkDataService;
import cn.com.polycis.modules.dev.service.IUnionDeviceService;
import cn.com.polycis.modules.t2g.entity.DataEntity;
import cn.com.polycis.modules.user.service.IOrganizationService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.com.polycis.modules.analysis.util.ByteUtil.toHexString;
import static cn.com.polycis.modules.analysis.util.HexUtil.convertHexToString;
import static cn.com.polycis.modules.analysis.util.HexUtil.hexStringToString;

@Service
@Transactional
public class AnalysisServiceImpl implements AnalysisService {

    protected static Logger Log = LoggerFactory.getLogger(AnalysisServiceImpl.class);

    @Autowired
    private AnalysisMapper analysisMapper;
    @Autowired
    private AnalysisService analysisService;

    @Autowired
    private IOrganizationService organizationService;


    @Override
    public List<AnalysisParameter> selectAnalysisParameter(int appId, String instruct) {


        List<AnalysisParameter> list = analysisMapper.selectAnalysisParameter(appId, instruct);


        return list;
    }

    @Override
    public JSONObject getJsonByAnalysis(String msg, List<AnalysisParameter> analysisparameterList, String instruct) {


        //指令占一个字节
        int dataLen = 1;
        //将16进制串,按照2位截一次,转为byte数组
        byte[] bytes = ByteUtil.toByteArray(msg);

        //  System.out.println(bytes.length);
        JSONObject jsonObject = new JSONObject();
        for (int i = 1; i <= analysisparameterList.size(); i++) {
            //获取指定索引的协议规则对象
            AnalysisParameter param = getIndexparameter(i, analysisparameterList);
            if (param != null) {
                //byte数组从1开始截
                byte[] messigeByte = ByteUtil.subBytes(bytes, dataLen, param.getDataLength());
                //索引为i的字节数组转为16进制的String
                String hexString = toHexString(messigeByte);

                //根据类型将16进制数转换为某类型数据
                //在类型判断里,可以加上List类型
                //再建一张list类型表,把那个list参数的id做为外键,关联起来,list里有点类似递归调用
                Object analysisedValue = getAnalysisedValue(param.getType(), hexString);

                jsonObject.put(param.getParameterKey(), analysisedValue);
                //标尺往后移
                dataLen = dataLen + messigeByte.length;
            } else {
                return null;
            }
        }

        return jsonObject;
    }


    @Override
    public String getInstruct(String msg) throws IOException {
        int dataLen = 0;
        byte[] bytes = ByteUtil.toByteArray(msg);
        //System.out.println(bytes.length);
        //消息头
        byte[] messigeByte = ByteUtil.subBytes(bytes, 0, 1);
        String string = toHexString(messigeByte);
        return string;
    }


    @Override
    public List<AnalysisParameter> selectAnalysisParameter(int analysisRuleId) {

        List<AnalysisParameter> list = analysisMapper.selectAnalysisParameterByRuleId(analysisRuleId);
        return list;

    }

    @Override
    public AnalysisRule selectAnalysisRole(int appId, String instruct) {
        return analysisMapper.selectAnalysisRole(appId, instruct);
    }

    @Autowired
    private IUnionDeviceService unionDeviceService;
    @Autowired
    private IMqInfoService mqInfoService;
    @Autowired
    private IHttpInfoService httpInfoService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IDeviceUplinkDataService deviceUplinkDataService;

    @Autowired
    private ClassifyFactory classifyFactory;

    @Override
    public String getJson(PushDataEntity pushDataEntity) {

        try {
            //将payload转换为byte数组
            byte[] bytes1 = new BASE64Decoder().decodeBuffer(pushDataEntity.getPayload());
            //将payload数组转换为16位字符串
            String msg = ByteUtil.toHexString(bytes1);
            UnionDevice unionDevice1 = new UnionDevice();
            unionDevice1.setDeviceUuid(pushDataEntity.getDeviceId());
            List<UnionDevice> unionDevices = unionDeviceService.selectList(new EntityWrapper<>(unionDevice1));
            String instruct = analysisService.getInstruct(msg);
            AnalysisRule analysisRule = analysisService.selectAnalysisRole(unionDevices.get(0).getAppId(), instruct);
            //type 0:透传  1:解析
            if (analysisRule.getType() == 1) {
                List<AnalysisParameter> analysisparameterList = analysisService.selectAnalysisParameter(unionDevices.get(0).getAppId(), instruct);
                if (!analysisparameterList.isEmpty()) {
                    JSONObject json = analysisService.getJsonByAnalysis(msg, analysisparameterList, instruct);
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("DeviceId", pushDataEntity.getDeviceId());
                    jsonObject.put("Data", json);
                    if (json != null) {
                        return jsonObject.toString();
                    }
                }
            } else {
                return msg;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Integer pushData(PushDataEntity pushDataEntity) {
        UnionDevice unionDevice1 = new UnionDevice();
        unionDevice1.setDeviceUuid(pushDataEntity.getDeviceId());
        List<UnionDevice> unionDevices = unionDeviceService.selectList(new EntityWrapper<>(unionDevice1));
        Integer orgId = organizationService.selectOrgByAppId(unionDevices.get(0).getAppId());
        String msg = null;
        String instruct = null;
        String data = null;

        Processor processor = classifyFactory.createProcessor(pushDataEntity);
        //说明数据有对应的处理器
        if (processor != null) {
            try {
                InfoAndInstruct infoAndInstruct = processor.getInstruct(pushDataEntity);
                instruct = infoAndInstruct.getInstruct();
                msg = infoAndInstruct.getInfo();
                data = infoAndInstruct.getData();
            } catch (IOException e) {
                e.printStackTrace();
                Log.info("设备id:" + pushDataEntity.getDeviceId() + " payload:" + pushDataEntity.getPayload() + " payload内容base64转换异常");
                //-1:io错误
                return -1;
            }


            //"appId:instrut"作为key存储解析规则
            String analysisRuleStr = (String) redisTemplate.opsForValue().get(unionDevices.get(0).getAppId() + "rule:" + instruct);
            AnalysisRule analysisRule = JSON.parseObject(analysisRuleStr, AnalysisRule.class);

            if (analysisRule == null) {
                analysisRule = analysisService.selectAnalysisRole(unionDevices.get(0).getAppId(), instruct);
                redisTemplate.opsForValue().set(unionDevices.get(0).getAppId() + "rule:" + instruct, JSON.toJSONString(analysisRule));
            }

            String string = null;
            if (analysisRule != null) {
                //type 0:透传  1:解析
                if (analysisRule.getType() == 1) {
                    String paramStr = (String) redisTemplate.opsForValue().get(unionDevices.get(0).getAppId() + "param:" + instruct);
                    List<AnalysisParameter> analysisparameterList = JSON.parseArray(paramStr, AnalysisParameter.class);
                    if (analysisparameterList == null) {
                        analysisparameterList = analysisService.selectAnalysisParameter(unionDevices.get(0).getAppId(), instruct);
                        redisTemplate.opsForValue().set(unionDevices.get(0).getAppId() + "param:" + instruct, JSON.toJSONString(analysisparameterList));
                    }
                    if (!analysisparameterList.isEmpty()) {
                        JSONObject json = analysisService.getJsonByAnalysis(msg, analysisparameterList, instruct);
                        if (json != null) {
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("deviceId", pushDataEntity.getDeviceId());
                            jsonObject.put("data", json);
                            string = jsonObject.toString();
                        } else {
                            //-3:协议解析规则配置错误,json失败
                            Log.info("设备id:" + pushDataEntity.getDeviceId() + " payload:" + pushDataEntity.getPayload() + " 通过解析参数解析失败,请检查是否是解析参数配置问题");
                            //    insertDeviceUplinkData(dataEntity, null, unionDevices.get(0), -3);
                            return -3;
                        }
                    } else {
                        // -6:没有配置解析参数
                        Log.info("设备id:" + pushDataEntity.getDeviceId() + " payload:" + pushDataEntity.getPayload() + " 没有配置解析参数");
                        //   insertDeviceUplinkData(dataEntity, null, unionDevices.get(0), -3);
                        return -6;

                    }
                } else {//数据类型为透传,直接封装
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("deviceId", pushDataEntity.getDeviceId());
                    jsonObject.put("data", msg);
                    string = jsonObject.toString();
                }
            } else {
                Log.info("设备id:" + pushDataEntity.getDeviceId() + " payload: " + pushDataEntity.getPayload() + " 没有配置该设备指令的解析规则");
                //   insertDeviceUplinkData(dataEntity, null, unionDevices.get(0), -3);
                // -7:没有配置解析规则
                return -7;
            }

            if (analysisRule.getPushWay() == 0) {
                //统一平台http/mq更新时,要设置更新redis缓存
                String strs = (String) redisTemplate.opsForValue().get("mqId:" + analysisRule.getPushId());
                MqInfo mqInfo = JSON.parseObject(strs, MqInfo.class);

                if (mqInfo == null) {
                    mqInfo = mqInfoService.selectById(analysisRule.getPushId());
                    redisTemplate.opsForValue().set("mqId:" + analysisRule.getPushId(), JSON.toJSONString(mqInfo));

                }
                if (mqInfo != null) {
                    pushDataToMq(analysisRule.getAppId(), string, mqInfo.getTopic(), mqInfo);
                    insertDeviceUplinkData(pushDataEntity, data,msg, string, orgId, unionDevices.get(0), 1);

                    //1:成功
                    return 1;
                } else {
                    insertDeviceUplinkData(pushDataEntity, data,msg, string, orgId, unionDevices.get(0), 0);
                    //-4:无mq推送地址
                    return -4;
                }
            } else {
                String str2 = (String) redisTemplate.opsForValue().get("httpId:" + analysisRule.getPushId());
                HttpInfo httpInfo = JSON.parseObject(str2, HttpInfo.class);
                if (httpInfo == null) {
                    httpInfo = httpInfoService.selectById(analysisRule.getPushId());
                    redisTemplate.opsForValue().set("httpId:" + analysisRule.getPushId(),  JSON.toJSONString(httpInfo));
                }
                if (httpInfo != null) {
                    try {
                        sendDataToHttp(string, httpInfo);
                        insertDeviceUplinkData(pushDataEntity,data, msg, string, orgId, unionDevices.get(0), 2);

                        return 1;
                    } catch (Exception e) {
                        e.printStackTrace();
                        insertDeviceUplinkData(pushDataEntity, data,msg, string, orgId, unionDevices.get(0), -2);
                        Log.info("设备id:" + pushDataEntity.getDeviceId() + " payload:" + pushDataEntity.getPayload() + " 解析后http推送失败");
                        //-2:http发送失败
                        return -2;
                    }
                } else {
                    insertDeviceUplinkData(pushDataEntity, data,msg, string, orgId, unionDevices.get(0), 0);
                    //-5:无http推送地址
                    return -5;
                }

            }

        } else {
            return -8;
        }
    }

/*
        try {
            //将payload转换为byte数组
            byte[] bytes1 = new BASE64Decoder().decodeBuffer(pushDataEntity.getPayload());
            //将payload数组转换为16位字符串
            msg = ByteUtil.toHexString(bytes1);
            instruct = analysisService.getInstruct(msg);
        } catch (IOException e) {
            e.printStackTrace();
            Log.info("设备id:"+ pushDataEntity.getDeviceId()+" payload:"+ pushDataEntity.getPayload()+" payload内容base64转换异常" );
            //-1:io错误
         //   insertDeviceUplinkData(dataEntity, null, null, -3);
            return -1;
        }*/


    public void insertDeviceUplinkData(PushDataEntity pushDataEntity, String data, String msg, String json, Integer orgId, UnionDevice unionDevice, Integer kind) {
        DeviceUplinkData gs = new DeviceUplinkData();
        gs.setDeviceId(unionDevice.getId());
        gs.setAppId(unionDevice.getAppId());
        gs.setJson(json);
        gs.setOrgId(orgId);
        gs.setInfo(msg);
        gs.setReportTime(pushDataEntity.getReportTime());
        gs.setDeviceUuid(pushDataEntity.getDeviceId());
        gs.setType(pushDataEntity.getType());
        gs.setCreateTime(new Date());
        gs.setData(data);
        gs.setKind(kind);
        deviceUplinkDataService.insert(gs);

    }


    private void sendDataToHttp(String json, HttpInfo http) throws Exception {
        String url = http.getUrl();
        if (url != null) {
            Map<String, String> headers = new HashMap<>();
            headers.put("Accept", "application/json");
            headers.put("Content-Type", "application/json");
            headers.put("Connection", "keep-alive");
            headers.put("User-Agent", "Apache-HttpClient/4.5.2 (Java/1.8.0_144)");
            String result = HttpClient.sendHttp(url, json, headers, "post", null);
        } else {
            Log.info("发送数据，请求url为空");
        }
    }


    private void pushDataToMq(Integer appId, String json, String queue, MqInfo mq) {

        if (!RabbitMQUtilForApp.FactoryIsopen(String.valueOf(appId))) {
            RabbitMQUtilForApp.initFactory(String.valueOf(appId), mq);
        }
        RabbitMQUtilForApp.sendMessage(String.valueOf(appId), json, queue);

    }


    public AnalysisParameter getIndexparameter(int i, List<AnalysisParameter> analysisparameterList) {
        for (AnalysisParameter a : analysisparameterList
                ) {
            if (a.getParameterIndex() == i) {
                return a;
            }
        }
        return null;
    }

    public Object getAnalysisedValue(Integer type, String hexString) {

        if (type == 1) {
            String string = convertHexToString(hexString);
            return string;
        }

        if (type == 2) {
            int i = Integer.parseInt(hexString, 16);
            return i;
        }

        if (type == 3) {
            long l = Long.parseLong(hexString, 16);
            return l;
        }

        if (type == 4) {
            Float value = Float.parseFloat(Integer.valueOf(hexString.trim(), 16).toString());

            return value;
        }

        if (type == 5) {
            double v = Double.parseDouble(Integer.valueOf(hexString.trim(), 16).toString());
            return v;
        }

        return null;
    }


    public Object getAnalysisedValue2(String type, String hexString) {

        if (type.toLowerCase().equals("string")) {
            String string = convertHexToString(hexString);
            return string;
        }

        if (type.toLowerCase().equals("int")) {
            int i = Integer.parseInt(hexString, 16);
            return i;
        }

        if (type.toLowerCase().equals("long")) {
            long l = Long.parseLong(hexString, 16);
            return l;
        }

        if (type.toLowerCase().equals("float")) {
            Float value = Float.intBitsToFloat(Integer.valueOf(hexString.trim(), 16));

            return value;
        }

        if (type.toLowerCase().equals("double")) {
            double v = Double.longBitsToDouble(Integer.valueOf(hexString.trim(), 16));
            return v;
        }

        return null;
    }

}
