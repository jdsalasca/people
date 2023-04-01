package com.jdsk.people.Integrations.discord.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

import com.jdsk.people.Integrations.discord.config.MessageListener;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MessageInterceptorImpl  implements ChannelInterceptor   {

	   @Autowired
	    private MessageListener messageListener;
	
	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
			log.info("there");
	       String messageContent = message.getPayload().toString();
	        System.out.println("Received message: " + messageContent);

	        // Perform any interpretation of the message content here
	        if (messageContent.contains("/task")) {
	            // Perform task 1
	            messageListener.createTask("mockTask", "sunday");
	        } else if (messageContent.contains("/song")) {
	            // Perform task 2
	            messageListener.recommendSong();
	        } else {
	            // Invalid message content
	            System.out.println("Invalid message content: " + messageContent);
	        }

	        return message;
	    
		//return ChannelInterceptor.super.preSend(message, channel);
	}



}
