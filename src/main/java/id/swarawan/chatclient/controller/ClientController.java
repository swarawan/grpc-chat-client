package id.swarawan.chatclient.controller;

import id.swarawan.Chat;
import id.swarawan.ChatServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hello")
public class ClientController {

	@Autowired
	private ChatServiceGrpc.ChatServiceBlockingStub server;

	@PostMapping(value = "{name}")
	public ResponseEntity<String> postMessage(@PathVariable("name") String name,
	                                          @RequestParam(value = "number", defaultValue = "0") int number) {

		Chat.ChatResponse response = server.chat(Chat.ChatMessage.newBuilder()
			.setName(name)
			.setNumber(number)
			.build());

		return new ResponseEntity<>(response.getResponseMessage(), HttpStatus.OK);
	}
}
