package br.univille;

import com.azure.core.amqp.AmqpTransportType;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;

public class Publisher {

    public static void main(String[] args) {
        var servidor = "sbdas12025a.servicebus.windows.net";
        var topicname = "topic-das1-a";

        // DefaultAzureCredential credential = 
        //     new DefaultAzureCredentialBuilder().build();

        String chave = System.getenv("CHAVE");
        ServiceBusSenderClient senderClient = new ServiceBusClientBuilder()
            .fullyQualifiedNamespace(servidor)
            // .credential(credential)
            .connectionString(chave)
            .sender()
            .topicName(topicname)
            .buildClient();

        senderClient.sendMessage(new ServiceBusMessage(
            "VITORH: vai corinthians"));
    }

}
