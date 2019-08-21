package cn.com.polycis.modules.analysis.dao;

import cn.com.polycis.modules.analysis.entity.AnalysisParameter;
import cn.com.polycis.modules.analysis.entity.AnalysisRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnalysisMapper  {
    List<AnalysisParameter> selectAnalysisParameter(int appId, String instruct);

    Integer selectAnalysisRoleCount(int appId);

    List<AnalysisRule> selectAnalysisRoleList(int appId);


    List<AnalysisParameter> selectAnalysisParameterByRuleId(int analysisRuleId);

    AnalysisRule selectAnalysisRole(int appId, String instruct);
}
