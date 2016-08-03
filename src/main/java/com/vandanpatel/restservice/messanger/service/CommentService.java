package com.vandanpatel.restservice.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.vandanpatel.restservice.messanger.database.DatabaseClass;
import com.vandanpatel.restservice.messanger.model.Comment;
import com.vandanpatel.restservice.messanger.model.Message;

public class CommentService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	private Map<Long, Comment> comments = DatabaseClass.getComments();
	
	public CommentService(){
		Comment comment1 = new Comment(1L, "Nice Comment", "Vandan Patel");
		Comment comment2 = new Comment(1L, "Nice Comment_2", "Vandan Patel_2");
		comments = messages.get(1L).getComments();
		comments.put(1L, comment1);
		comments.put(2L, comment2);
	}
	
	public List<Comment> getAllComments(long messageId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId ,Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) return null;
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}
