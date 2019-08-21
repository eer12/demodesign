package cn.com.polycis.modules.analysis;

import cn.com.polycis.AnalysisApplication;
import cn.com.polycis.modules.configuration.package1.TestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AnalysisApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AnalysisApplicationTests {

	@Autowired
	TestConfiguration testConfiguration;

	@Test
	public void testPersonProperties(){
		System.out.println(testConfiguration.toString());
	}

}
