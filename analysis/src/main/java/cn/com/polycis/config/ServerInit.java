package cn.com.polycis.config;

import cn.com.polycis.common.mqtts.RabbitMQUtil;
import cn.com.polycis.modules.analysis.entity.PushDataEntity;
import cn.com.polycis.modules.analysis.service.AnalysisService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

import static cn.com.polycis.modules.threadpool.newFixedThreadPool;


/**
 * @author Liangxiaolong
 *         DESCRIPTION 初始化设备数据到内存中
 * @create 2018/11/1-19:36
 */
@SuppressWarnings("ALL")
@Configuration
public class ServerInit {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServerInit.class);

    @Autowired
    private AnalysisService analysisService;

    @Value("${rabbitmq.listen.queue}")
    private String mq_queue;
    @Value("${rabbitmq.thread_count}")
    private Integer thread_count;


    /**
     *
     *
     * @param run
     */
    public void preHandle(ConfigurableApplicationContext run) {

        RabbitMQUtil.initFactory();
        //启动解析器监听处理
        analysisDataListen();

    }

    private void analysisDataListen(){
        LOGGER.info("================= 解析器监听处理启动成功 =================");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //通过线程池来控制该业务功能的线程数，具体线程数通过配置`文件指定
                    // ExecutorService executorService = Executors.newFixedThreadPool(4);
                   ExecutorService executorService = newFixedThreadPool(4);
                    while (true) {
                        executorService.execute(new Runnable() {
                            @Override
                            public void run() {
                                List<String> receiveMessages = RabbitMQUtil.receiveMessages(mq_queue,thread_count);
                               // if()
                                for (String  str:receiveMessages
                                     ) //noinspection AlibabaRemoveCommentedCode
                                {
                                    PushDataEntity pushDataEntity = JSON.parseObject(str, PushDataEntity.class);
                                 //   String json = analysisService.getJson(dataEntity);
                                    Date date = new Date();
                                    Integer i =analysisService.pushData(pushDataEntity);
                                    Date date1 = new Date();
                                    System.out.println("处理毫秒数:"+(date1.getTime()-date.getTime()));
                                }
                                }
                        });
                        Thread.sleep(300);
                    }
                } catch (Throwable e) {
                    LOGGER.error("解析器监听处理功能异常，将于10秒后重新启动", e);
                    try {
                        Thread.sleep(10000);
                    } catch (Exception e1) {

                    }finally {
                        analysisDataListen();
                    }
                }
            }
        }).start();
    }

}
