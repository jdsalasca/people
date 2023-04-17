package com.jdsk.people.Integrations.discord.config;

import java.util.Objects;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.User;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Priority;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.Disposable;


//@Configuration
@RequiredArgsConstructor
@Slf4j
public class DiscordBotConfig  implements DisposableBean {
	
	private  DiscordClient discordClient;
	
	/**
	 * Interesting Im using DisposableBea to avoid the creation of multiple objets of the same kind
	 */
	
	private static final String DISCORDBOTCODE = System.getenv("DISCORD_BOT_CODE");
	
	private Disposable server;
	//@Bean Non ready yet
   DiscordClient discordClient() {
    	DiscordClient discordClientIns = DiscordClient
    			.create(DISCORDBOTCODE);
    	this.discordClient = discordClientIns;
    	return discordClientIns;
    }

    @PreDestroy
    void beanDestruction () {
    	log.info("Disconnecting bean");
    	if (!Objects.isNull(discordClient)) {
    		this.discordClient = null;
    	}
    }

    @Bean
    GatewayDiscordClient gatewayDiscordClient(DiscordClient discordClient) {
        return discordClient.login().block();
    }

    @Bean
    ApplicationRunner applicationRunner(GatewayDiscordClient gatewayDiscordClient, MessageListener messageListener) {
        log.info("Requiring connection");
        
        return args -> {
            server = gatewayDiscordClient.on(MessageCreateEvent.class)
                    .flatMap(messageListener::onMessageCreateEvent)
                    .subscribe();
            
        };

        

		/*
		 * return args -> { // Cuando ya no se necesita la suscripción, deséchela para
		 * evitar fugas de memoria server.dispose(); };
		 */

    }
	@Override
	public void destroy() throws Exception {
		server.dispose();
		log.info("Disconnecting bean destroy");
		
	}
}
