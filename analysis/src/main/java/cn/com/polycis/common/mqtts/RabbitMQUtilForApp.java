package cn.com.polycis.common.mqtts;

import cn.com.polycis.modules.application.entity.MqInfo;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@Component
public class RabbitMQUtilForApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQUtilForApp.class);
    private static final Map<String, ConnectionFactory> MAPFACTORY = new HashMap<String, ConnectionFactory>();
    private static final Map<String, List<Connection>> CONNECTIONMAP = new HashMap<String, List<Connection>>();
    private static final int MAX_CONNECTIONS = 10;


//    static {
//        initFactory();
//    }


    /**
     * 向指定的的应用队列中发送消息
     *
     * @param message 消息体
     * @param queue   队列名
     */
    public static void sendMessage(String appid, String message, String queue) {
        try {
            // 从队列中获取一个连接
            Connection connection = getConnection(appid);
            // 创建一个MQ的管道
            Channel channel = connection.createChannel();
            // 将管道绑定到一个队列上
            channel.queueDeclare(queue, false, false, false, null);
            // 向指定的队列发送消息
            channel.basicPublish("", queue, null, message.getBytes("UTF-8"));
            // 关闭管道
            channel.close();
            // 将连接放回到队列中
            setConnection(appid, connection);
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
    public static List<String> receiveMessages(String appid, String queue, int count) {
        List<String> list = new ArrayList<String>();
        try {
            // 从队列中获取连接
            Connection connection = getConnection(appid);
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
            setConnection(appid, connection);
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
    public static Connection getConnection(String appId) {
        try {
            return getAndSetConnection(appId, true, null);
        } catch (Exception e) {
            throw new RuntimeException("connection MQ fail", e);
        }
    }

    /**
     * 将使用完毕的应用链接连接放回到队列中
     *
     * @param connection
     */
    private static void setConnection(String appid, Connection connection) {
        try {
            getAndSetConnection(appid, false, connection);
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

    private static synchronized Connection getAndSetConnection(String appId, Boolean isGet, Connection connection) throws Exception {

        if (isGet) {
            // 取连接，如果队列中不存在连接，则新建一个连接
            ConnectionFactory connectionFactory = MAPFACTORY.get(appId);
            if (CONNECTIONMAP.isEmpty()) {
                return getConnectiontu(appId, connectionFactory);
            }
            return getConnectiontu(appId, connectionFactory);

        } else {
            // 放回连接，如果队列中的连接数超过了MAX_CONNECTIONS指定数量的连接，则抛弃该连接
            if (!CONNECTIONMAP.isEmpty()) {
                List<Connection> connections = CONNECTIONMAP.get(appId);
                if (connections.size() < MAX_CONNECTIONS) {
                    connections.add(connection);
                    CONNECTIONMAP.put(String.valueOf(appId), connections);
                }
                return null;
            }
            return null;
        }
    }

    private static Connection getConnectiontu(String appId, ConnectionFactory connectionFactory) throws IOException, TimeoutException {
        List<Connection> connections = CONNECTIONMAP.get(appId);
        if (connections == null) {
            connections=new ArrayList<Connection>();
            Connection connection1 = connectionFactory.newConnection();
            connections.add(connection1);
            CONNECTIONMAP.put(appId, connections);
            return connection1;
        }
        if (connections.isEmpty()){
            connections=new ArrayList<Connection>();
            Connection connection1 = connectionFactory.newConnection();
            connections.add(connection1);
            CONNECTIONMAP.put(appId, connections);
            return connection1;
        }
        return getMapConnection(appId, connectionFactory, connections);
    }

    private static Connection getMapConnection(String appId, ConnectionFactory connectionFactory, List<Connection> connections) throws IOException, TimeoutException {
        Connection newConnection = connections.get(0);
        connections.remove(0);
        if (newConnection.isOpen()) {
            return newConnection;
        } else {
            Connection connection1 = connectionFactory.newConnection();
            connections.add(connection1);
            CONNECTIONMAP.put(appId, connections);
            return connection1;
        }
    }

    public static void initFactory(String appid, MqInfo mq) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(mq.getIp());
        connectionFactory.setPort(mq.getPort());
        connectionFactory.setUsername(mq.getUsername());
        connectionFactory.setPassword(mq.getPassword());
        MAPFACTORY.put(appid, connectionFactory);
        List<Connection> connections = CONNECTIONMAP.get(appid);
        if (connections!=null){
            connections.clear();
        }
    }

    public static boolean FactoryIsopen(String appid) {
        if (MAPFACTORY.isEmpty()) {
            return false;
        }
        if (MAPFACTORY.get(appid) != null) {
            return true;
        }
        return false;
    }

}
