package com.jdsk.people.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdsk.people.models.Message;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
//@RequestMapping("/chat")
public class ChatController {
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate; 
	
	@MessageMapping("/message") //app/message
	@SendTo("/chatroom/public")
	private Message receiverPublicmessage (@Payload Message message) {
		return message;
	}
	@MessageMapping("/private-message")
	private Message receivePrivateMessage(@Payload Message message) {
		simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message); //user/username/private
		return message;
	}
	
	@MessageMapping("/message2") //app/message
	@SendTo("/chat")
	private String receiverPublicmessage2 (@Payload String message) {
		log.info("message {}" , message);
		return message;
	}
	
}	
