package cn.com.polycis.modules.analysis.classifyDeal;

import cn.com.polycis.modules.analysis.entity.InfoAndInstruct;
import cn.com.polycis.modules.analysis.entity.PushDataEntity;
import cn.com.polycis.modules.dev.entity.UnionDevice;
import org.springframework.stereotype.Component;

import java.io.IOException;


public class Processor {

    public Processor() {
    }

    public InfoAndInstruct getInstruct(PushDataEntity pushDataEntity) throws IOException {

        return new InfoAndInstruct();
    }

}
