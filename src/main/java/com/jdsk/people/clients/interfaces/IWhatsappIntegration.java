package com.jdsk.people.clients.interfaces;

public interface IWhatsappIntegration {
	
	   void sendTextMessage(String phoneNumber, String message);
	    void sendImageMessage(String phoneNumber, String imageUrl);
	    void sendAudioMessage(String phoneNumber, String audioUrl);
	    void sendVideoMessage(String phoneNumber, String videoUrl);

}
