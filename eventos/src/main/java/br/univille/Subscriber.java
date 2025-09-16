package br.univille;

import java.security.Provider.Service;

import com.azure.core.amqp.AmqpTransportType;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusProcessorClient;
import com.azure.messaging.servicebus.models.ServiceBusReceiveMode;

public class Subscriber {
    public static void main(String[] args) {
        var servidor = "sbdas12025a.servicebus.windows.net";
        var topicname = "topic-das1-a";

        String chave = System.getenv("CHAVE");
        var subscriptionName = "subscription-vitorhugo";

        ServiceBusProcessorClient processorClient = new ServiceBusClientBuilder()
            .fullyQualifiedNamespace(servidor)
            .connectionString(chave)
            .transportType(AmqpTransportType.AMQP_WEB_SOCKETS)
            .processor()
            .topicName(topicname)
            .subscriptionName(subscriptionName)
            .receiveMode(ServiceBusReceiveMode.PEEK_LOCK)
            .processMessage(context -> {
                System.out.println("MSG:" + context.getMessage().getBody().toString());
                context.complete();
            })
            .processError(context -> {
                System.out.println("deu ruim");
            })
            .buildProcessorClient();

        processorClient.start();
        
    }

}
