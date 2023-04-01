package com.jdsk.people.Integrations.discord.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.jdsk.people.utils.powershell.PowerShellConsole;

import discord4j.common.util.Snowflake;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import discord4j.core.spec.MessageCreateSpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Configuration
@Slf4j
@RequiredArgsConstructor
public class MessageListener {
	private final PowerShellConsole powerShellConsole;
	@Bean
	MessageListener messageListenerBean() {
		return new MessageListener(powerShellConsole);
	}
	
	
	
	
    public Mono<Void> onMessageCreateEvent(MessageCreateEvent event) {
        Message message = event.getMessage();
        User author = message.getAuthor().orElse(null);

        // Ignore bot messages and messages without authors
        if (author == null || author.isBot()) {
            return Mono.empty();
        }

        String content = message.getContent();
        Snowflake channelId = message.getChannelId();

        // Interpret message content and perform actions
        // ...

        log.info("Received message from user: " + author.getUsername() + " in channel: " + channelId.asString() + " with content: " + content);
        return message.getChannel()
                .flatMap(channel -> channel.createMessage(interpreter(content, author.getUsername())))
                .onErrorResume(throwable -> {
                	   log.info("Error sending message: " + throwable.getMessage());
                    return Mono.empty();
                })
                .then();
    }
	
    
    private String interpreter (String message, String userId) {
        // Match strategy based on keywords
        if (message.contains("/comm")) {
        	log.info("user @ @@@ {} is granted access to inject commands to wind or ubuntu server by powerShell ", userId);
        	String value =  powerShellConsole.executeCommand(message.replace("/comm", ""));
        	
        	return value;
        	
            // Handle communication command
            // ...
        	
        	
        } else if (message.contains("/song")) {
        	return "escucha ";// Handle song command
            // ...
        } else if (message.contains("/turn-off")) {
            // Handle turn off command
            // ...
        } else if (message.contains("/email")) {
            // Handle email command
            // ...
        } else if (message.contains("/scrap")) {
            // Handle web scraping command
            // ...
        } else {
        	return "Orden rechazada";

            // Handle unknown command
            // ...
        }
        return "Orden rechazada";

    }
	
	public Optional<String> sendEmail(String email, String message) {
		
		try {
			log.info("Google Gmail Api");
			return Optional.empty();
		} catch (Exception e) {
			return Optional.empty();
		}
		
		
	}

	public synchronized Optional<String> createTask(String task, String day) {
		
		try {
			log.info("Google Calendar Api");
			return Optional.empty();
		} catch (Exception e) {
			return Optional.empty();
		}
		
		
	}
	
	public synchronized  Optional<String> recommendSong() {
		
		try {
			log.info("Google Youtube Api");
			return Optional.empty();
		} catch (Exception e) {
			return Optional.empty();
		}
		
		
	}
		
	
    public void onMessage(String messageContent) {
        System.out.println("Received message: " + messageContent);
        // Perform any other actions with the message content here
    }

}