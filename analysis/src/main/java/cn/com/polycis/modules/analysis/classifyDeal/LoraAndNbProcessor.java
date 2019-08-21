package cn.com.polycis.modules.analysis.classifyDeal;

import cn.com.polycis.modules.analysis.entity.InfoAndInstruct;
import cn.com.polycis.modules.analysis.entity.PushDataEntity;
import cn.com.polycis.modules.analysis.service.AnalysisService;
import cn.com.polycis.modules.analysis.util.ByteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;

import java.io.IOException;

@Component
public class LoraAndNbProcessor extends Processor {

    @Autowired
    private AnalysisService analysisService;

    public LoraAndNbProcessor() {
    }

    @Override
    public InfoAndInstruct getInstruct(PushDataEntity pushDataEntity) throws IOException {

        byte[] bytes1 = new BASE64Decoder().decodeBuffer(pushDataEntity.getPayload());
        //将payload数组转换为16位字符串
        String info = ByteUtil.toHexString(bytes1);
        String instruct = analysisService.getInstruct(info);
        return new InfoAndInstruct(info,instruct,pushDataEntity.getPayload());
    }

}
