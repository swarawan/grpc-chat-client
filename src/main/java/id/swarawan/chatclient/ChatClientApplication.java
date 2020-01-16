package id.swarawan.chatclient;

import id.swarawan.Chat;
import id.swarawan.ChatServiceGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChatClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatClientApplication.class, args);



	}

	@Bean
	public ManagedChannel managedChannel() {
		return ManagedChannelBuilder
			.forAddress("localhost", 8080)
			.usePlaintext()
			.build();
	}

	@Bean
	public ChatServiceGrpc.ChatServiceBlockingStub blockingStub() {
		return ChatServiceGrpc.newBlockingStub(managedChannel());
	}
}
