package cn.com.polycis.modules.analysis.controller;

import cn.com.polycis.common.annotation.SysLog;
import cn.com.polycis.common.mqtts.RabbitMQUtil;
import cn.com.polycis.common.requesdata.RequestVO;
import cn.com.polycis.common.utils.R;
import cn.com.polycis.modules.analysis.classifyDeal.Entitys;
import cn.com.polycis.modules.analysis.classifyDeal.SpringContextUtils;
import cn.com.polycis.modules.jwt.JwtUtil;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

@RestController
//@RequestMapping(value = "/analysis")
@Api(value = "AnalysisController", description = "协议解析器模块:解析器管理")
public class AnalysisController {


    @ApiOperation(value = "解析测试接口", notes = "解析测试接口")
    @SysLog("解析测试接口")
    @RequestMapping(value = "/testAnalysis", method = RequestMethod.POST)
    public R testAnalysis(@RequestBody RequestVO requestVO) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("deviceId", "ffffff1000007a49");
        jsonObject.put("payload", "ARBQT1MR");
        jsonObject.put("type", "2");
        jsonObject.put("reportTime", new Date());

        RabbitMQUtil.sendMessage(jsonObject.toString(), "union_send_analysis");
        return R.ok();
    }


    @ApiOperation(value = "解析测试接口", notes = "解析测试接口")
    @SysLog("解析测试接口")
    @GetMapping(value = "/test")
    public Object test() {

        Object the2GProcessor = SpringContextUtils.getBean("The2GProcessor");

        Method method = ReflectionUtils.findMethod(the2GProcessor.getClass(), "test2");
        // 反射执行方法
        Object objRe = ReflectionUtils.invokeMethod(method, the2GProcessor);

        return R.ok(the2GProcessor.toString());
    }


    @ApiOperation(value = "测试反射接口", notes = "测试反射接口")
    @SysLog("测试反射接口")
    @PostMapping(value = "/test3")
    public Object test3(@RequestBody Entitys entitys) {


        System.out.println(entitys.toString());

        Object the2GProcessor = SpringContextUtils.getBean("The2GProcessor");

        Method method = ReflectionUtils.findMethod(the2GProcessor.getClass(), "test2");
        // 反射执行方法
        Object objRe = ReflectionUtils.invokeMethod(method, the2GProcessor);

        return R.ok(the2GProcessor.toString());
    }



}


