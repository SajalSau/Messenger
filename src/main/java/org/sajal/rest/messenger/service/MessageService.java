package org.sajal.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.sajal.rest.messenger.database.DataBase;
import org.sajal.rest.messenger.exception.DataNotFoundException;
import org.sajal.rest.messenger.model.ErrorMessage;
import org.sajal.rest.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DataBase.getMessages();
	private static Map<Long, Message> staticMessages = DataBase.getMessages();
	
	  public MessageService() { messages.put(1l, new Message(1l, "Hello World 1",
	  "Sajal")); messages.put(2l, new Message(2l, "Hello World 2", "Sajal")); }
	 
	
	/*
	 * static { staticMessages.put(1l, new Message(1l, "Static Hello World 1",
	 * "Sajal")); staticMessages.put(2l, new Message(2l, "Static Hello World 2",
	 * "Sajal")); }
	 */
	
	public List<Message> getAllMessages(){
		/*
		 * Message m1 = new Message(1l, "Hello World 1", "Sajal"); Message m2 = new
		 * Message(2l, "Hello World 2", "Sajal"); Message m3 = new Message(3l,
		 * "Hello World 3", "Sajal"); List<Message> list = new ArrayList<>();
		 * list.add(m1); list.add(m2); list.add(m3); return list;
		 */
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		
		Message message = messages.get(id);
		if(message == null) {
			/*ErrorMessage exMessage = new ErrorMessage ("404","Not found data","Learn.....");
			Response response = Response.status(Status.NOT_FOUND).entity(exMessage).build();
			throw new WebApplicationException(response); */
			//throw new NotFoundException("Data is not available for id:"+id);
			throw new DataNotFoundException("Data is not available for id:"+id);
		}
		return message;
	}
	public Message addMessage(Message message) {
		if(messages.size()<=0) {
			return null;
		}else {
			message.setId(messages.size()+1);
			messages.put(message.getId(), message);
			return message;
		}
	}
	public Message updateMessage(Message message) {
		if(message.getId()<=0) {
			return null;
		}else {
			messages.put(message.getId(), message);
			System.out.println("message obj"+message.getId());
			return message;
		}
	}
	public Message removeMessage(long id) {
		return messages.remove(id);
	
	}
}
