package cn.com.polycis.modules.configuration.package2;

import cn.com.polycis.modules.configuration.package1.TestConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Confi {


    @Bean
    public TestConfiguration get(){
        TestConfiguration testConfiguration = new TestConfiguration();
        System.out.println(testConfiguration.toString());
        return testConfiguration;
    }


    @Bean
    public TestConfiguration get0(){
        TestConfiguration testConfiguration = new TestConfiguration();
        System.out.println(testConfiguration.toString());
        return testConfiguration;
    }



 /*   @Bean(name = "TEST4")
    public String test(@Qualifier("TEST3") TestConfiguration2 testConfiguration2){

        return testConfiguration2.toString();
    }*/


}
