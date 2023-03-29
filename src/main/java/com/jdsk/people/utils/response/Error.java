package com.jdsk.people.utils.response;

import com.jdsk.people.utils.response.DefaultResponse.MESSAGETYPES;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {
    	
        private String message;
        private MESSAGETYPES messageType;

		public String getMessageType() {
			return messageType.value();
		}
}
