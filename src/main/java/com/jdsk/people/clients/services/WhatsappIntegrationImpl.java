package com.jdsk.people.clients.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jdsk.people.clients.interfaces.IWhatsappIntegration;
@Service
public class WhatsappIntegrationImpl implements IWhatsappIntegration {
	@Autowired
	RestTemplate restTemplate;
	
	private HttpHeaders authHeadersBuilder () {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer EAAJRIu1gPSYBAIQOcGW3EkodzBT4J8voq5lrghfHQMwz5tDvbTuCF1otVTQhtcurBXWwpMi91Bw45ffcRSZC1KHw40yvngAGZAnOUS0SjZClbNnlpJuQMy9ACnZAVd0tttv74fPTCIYoFkwdxWOYs4C3ODedlaUaaZCERGqyfsp6eH4l6QaklzUqlrCpL4nMtIVLRnvABVAZDZD");
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;

	}

	

	

	@Override
	public void sendTextMessage(String phoneNumber, String message) {

		String url = "https://graph.facebook.com/v16.0/109964405358580/messages";

		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("messaging_product", "whatsapp");
		requestBody.put("to", "573108539630");
		requestBody.put("type", "text");

		Map<String, Object> messageBody = new HashMap<>();
		messageBody.put("preview_url", true);
		messageBody.put("body", message);
		Map<String, Object> language = new HashMap<>();
		language.put("code", "en_US");
		requestBody.put("text", messageBody);

		HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, authHeadersBuilder());

		restTemplate.postForEntity(url, request, String.class);
		
	}

	@Override
	public void sendImageMessage(String phoneNumber, String imageUrl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendAudioMessage(String phoneNumber, String audioUrl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendVideoMessage(String phoneNumber, String videoUrl) {
		// TODO Auto-generated method stub
		
	}

}
