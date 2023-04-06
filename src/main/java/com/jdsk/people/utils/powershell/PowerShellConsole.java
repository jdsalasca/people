package com.jdsk.people.utils.powershell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class PowerShellConsole  {
    private Process process;
    private BufferedReader reader;

    @Bean
    PowerShellConsole powerShellConsoleBean() {
        log.info("Creating PowerShell session");
        return new PowerShellConsole();
    }

    public PowerShellConsole() {
        try {
            // Create PowerShell process
        	process = Runtime.getRuntime().exec("powershell.exe");
            process.getOutputStream().write("Get-ChildItem\n".getBytes());
            process.getOutputStream().flush();

            // Read output from PowerShell console
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Wait for the PowerShell console to start up
            Thread.sleep(2000);

            // Print initial PowerShell prompt
            log.info("Initial print {} ",reader.readLine());


            // Write commands to PowerShell console


            
        } catch (IOException | InterruptedException e) {
            log.error("Error creating PowerShell session", e);
        }
    }

    public  String executeCommand(String command)  {
        try {
            process.getOutputStream().write((command + "\n").getBytes());
            process.getOutputStream().flush();


            // Read output from PowerShell console
            StringBuilder outputBuilder = new StringBuilder();
            String line;
            int outputLength  =0;
            while (reader.ready() && (line = reader.readLine()) != null) {
                outputLength += line.length() + System.lineSeparator().length();
                if (outputLength >= 2000) {
                    // If the output length exceeds 2000 characters, break out of the loop
                    break;
                }
                outputBuilder.append(line).append(System.lineSeparator());
            }
            String output = outputBuilder.toString();
            log.info(output);
            return output;

        } catch (IOException 	 e) {
            log.warn("Error executing command: {}", e.getMessage());
            return "Command did not execute";
        }
    }

    @PreDestroy
    public void close() {
    	log.warn("closing powershellllllllllllllllllll");
        try {
            // Close PowerShell process and reader
            process.destroy();
            reader.close();
        } catch (IOException e) {
            log.error("Error closing PowerShell session", e);
        }
    }
}
