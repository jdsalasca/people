package com.jdsk.people.events;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentPlacedEvent {
	private long userId;
	
}
