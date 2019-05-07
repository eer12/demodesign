package cn.com.polycis.modules.analysis;

import cn.com.polycis.AnalysisApplication;
import cn.com.polycis.modules.analysis.entity.AnalysisRule;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AnalysisApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class AnalysisApplicationTests2 {


	@Test
	public void contextLoads() {

		AnalysisRule analysisRule1 = JSON.parseObject("", AnalysisRule.class);
		if(analysisRule1==null){
			System.out.println("null");
		}

		List<AnalysisRule> analysisRules = JSON.parseArray("", AnalysisRule.class);

	}



}
