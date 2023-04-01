package com.jdsk.people.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdsk.people.clients.interfaces.IWhatsappIntegration;
import com.jdsk.people.interfaces.IPersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/whatsApp")
@RequiredArgsConstructor
public class WhatsappController {
	
	private final IWhatsappIntegration iWhatsappIntegration;


    @GetMapping("/send")
    public void async() {
    	iWhatsappIntegration.sendTextMessage("3108539630", "Hola como estas ");
       
    }
    
	
	

}
