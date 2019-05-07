package cn.com.polycis.modules.analysis.classifyDeal;

import cn.com.polycis.modules.analysis.entity.InfoAndInstruct;
import cn.com.polycis.modules.analysis.entity.PushDataEntity;
import cn.com.polycis.modules.analysis.service.AnalysisService;
import cn.com.polycis.modules.analysis.util.ByteUtil;
import cn.com.polycis.modules.t2g.entity.DataEntity;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
//(value = "The2GProcessor")
@Component(value = "The2GProcessor")
public class The2GProcessor extends Processor {
    @Autowired
    private AnalysisService analysisService;

    public The2GProcessor() {
    }

    @Override
    public InfoAndInstruct getInstruct(PushDataEntity pushDataEntity) throws IOException {

        DataEntity dataEntity = JSON.parseObject(pushDataEntity.getPayload(), DataEntity.class);
        //base64加密的payload内容
        String data = dataEntity.getData();
        //解密后的16进制内容
        String info = ByteUtil.toHexString(dataEntity.getPayload());

        String instruct = analysisService.getInstruct(info);

        return new InfoAndInstruct(info,instruct,data);
    }

    public void test2(){
        System.out.println("调用了方法");
    }


}
