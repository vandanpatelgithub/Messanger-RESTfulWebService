package com.vandanpatel.restservice.messanger.database;

import java.util.HashMap;
import java.util.Map;

import com.vandanpatel.restservice.messanger.model.Comment;
import com.vandanpatel.restservice.messanger.model.Message;
import com.vandanpatel.restservice.messanger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	
	private static Map<String, Profile> profiles = new HashMap<>();
	
	private static Map<Long, Comment> comments = new HashMap<>();

	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}

	public static Map<Long, Comment> getComments() {
		return comments;
	}
	
}
