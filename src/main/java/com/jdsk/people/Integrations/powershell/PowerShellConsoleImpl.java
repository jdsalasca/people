package com.jdsk.people.Integrations.powershell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Configuration @Service
public class PowerShellConsoleImpl  implements IPowerShellConsole{


	    @Bean
	    Flux<String> powerShellOutput() throws IOException {
	        Process process = new ProcessBuilder("powershell.exe").start();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	        
	        return Flux.create(emitter -> {
	            String line;
	            try {
	                while ((line = reader.readLine()) != null) {
	                    emitter.next(line);
	                }
	            } catch (IOException e) {
	                emitter.error(e);
	            }
	        });

	}

}
