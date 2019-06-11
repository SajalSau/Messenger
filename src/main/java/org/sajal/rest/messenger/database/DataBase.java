package org.sajal.rest.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.sajal.rest.messenger.model.Message;

public class DataBase {

	private static Map<Long,Message> messages = new HashMap<>();
	private static Map<Long,Message> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<Long, Message> getProfiles() {
		return profiles;
	}
	
	
	
}
