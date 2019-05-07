package cn.com.polycis;

import cn.com.polycis.config.ServerInit;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("application.properties")
@MapperScan("cn.com.polycis.modules.*.dao")
public class AnalysisApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(AnalysisApplication.class, args);
		//初始数据处理
		ServerInit s = run.getBean(ServerInit.class);
		s.preHandle(run);
	}

}
