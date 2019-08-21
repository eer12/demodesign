package cn.com.polycis.common.mqtts;

import cn.com.polycis.modules.application.entity.MqInfo;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RabbitMQUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQUtil.class);
    private static final ConnectionFactory FACTORY = new ConnectionFactory();
    private static final List<Connection> CONNECTIONS = new ArrayList<Connection>();
    private static final int MAX_CONNECTION = 20;

    public static String mqhost;

    @Value("${rabbitmq.host}")
    public void setMqhost(String host) {
        RabbitMQUtil.mqhost = host;
    }

    public static Integer mqport;

    @Value("${rabbitmq.port}")
    public void setMqport(Integer port) {
        RabbitMQUtil.mqport = port;
    }

    public static String mqname;

    @Value("${rabbitmq.username}")
    public void setMqname(String username) {
        RabbitMQUtil.mqname = username;
    }

    public static String mqpassword;

    @Value("${rabbitmq.password}")
    public void setMqpassword(String password) {
        RabbitMQUtil.mqpassword = password;
    }

    static {
//        initFactory();
    }

    /**
     * 向指定的消息队列发送消息
     *
     * @param message 消息体
     * @param queue   队列名
     */
    public static void sendMessage(String message, String queue) {
        try {
            // 从队列中获取一个连接
            Connection connection = getConnection();
            // 创建一个MQ的管道
            Channel channel = connection.createChannel();
            // 将管道绑定到一个队列上
            channel.queueDeclare(queue, false, false, false, null);
            // 向指定的队列发送消息
            channel.basicPublish("", queue, null, message.getBytes("UTF-8"));
            // 关闭管道
            channel.close();
            // 将连接放回到队列中
            setConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("RabbitMQ connection fail, send message fail!", e);
        }
    }

    /**
     * 向指定的消息队列取出固定数量的数据
     *
     * @param queue 消息队列名
     * @param count 取出的消息数量
     * @return
     */
    public static List<String> receiveMessages(String queue, int count) {
        List<String> list = new ArrayList<String>();
        try {
            // 从队列中获取连接
            Connection connection = getConnection();
            // 创建一个管道
            Channel channel = connection.createChannel();
            // 将管道绑定到队列上
            channel.queueDeclare(queue, false, false, false, null);

            // 向指定的队列中获取数据，通过循环，每次循环获取一条数据，总共循环count次
            QueueingConsumer consumer = new QueueingConsumer(channel);
            channel.basicConsume(queue, false, consumer);
            for (int i = 0; i < count; i++) {
                QueueingConsumer.Delivery delivery = consumer.nextDelivery(300);
                if (delivery == null) {
                    break;
                }
                String message = new String(delivery.getBody());
                list.add(message);
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

            }
            // 关闭管道
            channel.close();
            // 将连接放回到队列中
            setConnection(connection);
        } catch (Exception e) {
            LOGGER.error("RabbitMQ connection fail, receive message fail!", e);
        } finally {
            return list;
        }
    }

    /**
     * 从队列中获取连接
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            return getAndSetConnection(true, null);
        } catch (Exception e) {
            throw new RuntimeException("connection MQ fail", e);
        }
    }

    /**
     * 将使用完毕的连接放回到队列中
     *
     * @param connection
     */
    private static void setConnection(Connection connection) {
        try {
            getAndSetConnection(false, connection);
        } catch (Exception e) {
            throw new RuntimeException("connection MQ fail", e);
        }
    }

    /**
     * 通过同步锁控制连接队列，根据参数isGet来区分本次调用是从队列中取连接还是存放连接
     *
     * @param isGet      取出或者放回的标记，true表示取连接，false表示放回连接
     * @param connection 取连接：null, 放回连接：具体连接对象
     * @return 取连接时，返回具体连接对象，放回连接时，返回null
     * @throws Exception
     */
    private static synchronized Connection getAndSetConnection(boolean isGet, Connection connection) throws Exception {
        if (isGet) {
            // 取连接，如果队列中不存在连接，则新建一个连接
            if (CONNECTIONS.isEmpty()) {
                return FACTORY.newConnection();
            }
            Connection newConnection = CONNECTIONS.get(0);

            CONNECTIONS.remove(0);
            if (newConnection.isOpen()) {
                return newConnection;
            } else {
                return FACTORY.newConnection();
            }
        } else {
            // 放回连接，如果队列中的连接数超过了MAX_CONNECTION指定数量的连接，则抛弃该连接
            if (CONNECTIONS.size() < MAX_CONNECTION) {
                CONNECTIONS.add(connection);
            }
            return null;
        }
    }

    public static void initFactory() {

        FACTORY.setHost(mqhost);
        FACTORY.setPort(mqport);
        FACTORY.setUsername(mqname);
        FACTORY.setPassword(mqpassword);

//        FACTORY.setHost("47.93.172.30");
//        FACTORY.setPort(5672);
//        FACTORY.setUsername("rabbitmq");
//        FACTORY.setPassword("12345qwert");
    }

    public static void initFactory(MqInfo mq) {
        /*FACTORY.setHost(PropertyConf.config.getProperty("mq.host"));
        FACTORY.setPort(Integer.valueOf(PropertyConf.config.getProperty("mq.port")));
        FACTORY.setUsername(PropertyConf.config.getProperty("mq.username"));
        FACTORY.setPassword(PropertyConf.config.getProperty("mq.password"));*/
        FACTORY.setHost(mq.getIp());
        FACTORY.setPort(mq.getPort());
        FACTORY.setUsername(mq.getUsername());
        FACTORY.setPassword(mq.getPassword());
    }


}
