package main.java.jms;

import com.rabbitmq.client.*;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Kevin.
 */

public class JMSDispatcher {
    private static JMSDispatcher instance;
    private static ConnectionFactory connectionFactory;
    private static Connection connection;
    private static Channel channel;

    private JMSDispatcher() {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        try {
            connection = connectionFactory.newConnection();
            channel = connection.createChannel();
        } catch (TimeoutException | IOException e) {
            e.printStackTrace();
        }
    }

    public static JMSDispatcher getInstance() {
        if (instance == null) {
            instance = new JMSDispatcher();
        }
        return instance;
    }

    private static void declareQueue(String queueName) throws IOException {
        channel.queueDeclare(queueName, false, false, false, null);
    }

    public static void publishMessage(String queueName, String message) throws IOException {
        declareQueue(queueName);
        channel.basicPublish("", queueName, null, message.getBytes());
    }

    public static void closeDispatcher() throws IOException, TimeoutException {
        channel.close();
        connection.close();
    }
}
