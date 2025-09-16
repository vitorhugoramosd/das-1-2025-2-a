package br.univille;

import com.azure.identity.DefaultAzureCredential;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusSenderClient;

public class Publisher {

    public static void main(String[] args) {
        var servidor = "sbdas12025a.servicebus.windows.net";
        var topicname = "topic-das1-a";

        DefaultAzureCredential credential = new DefaultAzureCredential().build();

        ServiceBusSenderClient senderClient = new ServiceBusClientBuilder()
            .fullyQualifiedNamespace(servidor)
            .credential(credential)
            .sender()
            .topicName(topicname)
            .buildClient();
    }

}
