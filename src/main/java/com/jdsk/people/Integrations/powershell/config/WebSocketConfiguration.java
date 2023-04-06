package com.jdsk.people.Integrations.powershell.config;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistration;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@RequiredArgsConstructor
public class WebSocketConfiguration implements WebSocketHandlerRegistry {

    private final PowerShellWebSocketHandler powerShellWebSocketHandler;



	@Override
	public WebSocketHandlerRegistration addHandler(WebSocketHandler webSocketHandler, String... paths) {
		
		 addHandler(powerShellWebSocketHandler, "/powershell");
		return null;
	}
}
	

