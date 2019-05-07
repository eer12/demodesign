package cn.com.polycis.modules.analysis.service;

import cn.com.polycis.modules.analysis.entity.AnalysisParameter;
import cn.com.polycis.modules.analysis.entity.AnalysisRule;
import cn.com.polycis.modules.analysis.entity.PushDataEntity;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface AnalysisService {
    List<AnalysisParameter> selectAnalysisParameter(int appId, String instruct);

    JSONObject getJsonByAnalysis(String msg, List<AnalysisParameter> analysisparameterList, String instruct);

    String getInstruct(String msg) throws IOException;



    List<AnalysisParameter> selectAnalysisParameter(int analysisRuleId);

    AnalysisRule selectAnalysisRole(int appId, String instruct);

    String getJson(PushDataEntity pushDataEntity) ;


    Integer pushData(PushDataEntity pushDataEntity);
}
