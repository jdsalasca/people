package com.jdsk.people.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	private String senderName;
	private String receiverName;
	private String content;
	private String date;
	private Status status;
}
