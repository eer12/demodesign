package cn.com.polycis.modules.analysis.classifyDeal;

import cn.com.polycis.modules.analysis.entity.PushDataEntity;
import cn.com.polycis.modules.t2g.entity.DataEntity;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ClassifyFactory {
    @Autowired
    private The2GProcessor the2GProcessor;
    @Autowired
    private LoraAndNbProcessor loraAndNbProcessor;


    public Processor createProcessor(PushDataEntity pushDataEntity) {

        if (pushDataEntity.getType() == 3) {
            DataEntity dataEntity = JSON.parseObject(pushDataEntity.getPayload(), DataEntity.class);
            //1为业务数据,可以解析
            if (dataEntity.getType() == 1) {
                return the2GProcessor;
            }
            return null;
        }else{
            return loraAndNbProcessor;
        }
    }


}
