package com.jdsk.people.Integrations.discord.interfaces;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

public interface IMessageInterceptor {
	
	 Message preSend(Message message, MessageChannel channel);
}
