package cn.com.polycis.modules.qualifier;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
@Configuration
public class Test {


    @Bean(name = "db1")
    public Integer db1 () {
        return  1;
    }
    @Bean(name = "db2")
    public Integer db2 () {
        return  2;
    }
    @Bean(name = "db3")
    public Integer db3 () {
        return  3;
    }
    /**
     * 动态数据源配置
     * @return
     */
    @Bean
    @Primary
    public int multipleDataSource (@Qualifier("db1") Integer db1,
                                          @Qualifier("db2") Integer db2,
                                          @Qualifier("db3") Integer db3) {
        System.out.println("db打印结果============"+db1+db2+db3);
        return db1+db2+db3;
    }



}
