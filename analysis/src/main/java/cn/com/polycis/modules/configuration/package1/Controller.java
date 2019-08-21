package cn.com.polycis.modules.configuration.package1;

import cn.com.polycis.modules.configuration.package2.TestConfiguration2;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/con")
public class Controller {

    @Autowired
    private TestConfiguration testConfiguration;

    @GetMapping("/test1")
    public String get(){
        return testConfiguration.toString();
    }

   /* @Resource(name="TEST2")
    private TestConfiguration2 testConfiguration2;

    @GetMapping("/test2")
    public String get2(){
        return testConfiguration2.toString();
    }



    @Resource(name="TEST4")
    private String TEST4str;
    @GetMapping("/test3")
    public String get3(){
       return TEST4str;
    }
*/


}
