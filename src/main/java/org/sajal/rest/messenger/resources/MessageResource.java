package org.sajal.rest.messenger.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.sajal.rest.messenger.model.Message;
import org.sajal.rest.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class MessageResource {

	MessageService messageService = new MessageService ();
	
	@GET
	public List<Message> getMessages () {
		return messageService.getAllMessages();
	}

	
	@GET
	@Path("/{messageId}")
	public Message getMessagesXML (@PathParam ("messageId") long id) {
		return messageService.getMessage(id);
	}
	
	/*@POST
	public Response addMessage(Message message) {
		Message retMessage = messageService.addMessage(message);
		return Response.status(Status.CREATED).entity(retMessage).expires(new Date()).build();
	}*/
	
	@POST
	public Response addMessage(Message message , @Context UriInfo uriInfo, @HeaderParam ("content-type") String contentType){
		Message retMessage = messageService.addMessage(message);
		String url = uriInfo.getBaseUriBuilder().path(MessageResource.class).path(Long.toString(retMessage.getId())).build().toString();
		retMessage.addLink(url,"self");
		//System.out.println("String concat :"+new URI (uriInfo.getAbsolutePath().toString()+retMessage.getId()));
		System.out.println("Base URI :"+url+" Uri builder :"+uriInfo.getAbsolutePathBuilder().path(Long.toString(retMessage.getId())).build());
		return Response.created(uriInfo.getAbsolutePathBuilder().path(Long.toString(retMessage.getId())).build()).entity(retMessage).build();
	}
	
	@PUT
	@Path("/{messageID}")
	public Message updateMessage(@PathParam("messageID") String messageId,Message message) {
		//Optional<Message> msg = Optional.of(message);
		Message msg = messageService.updateMessage(message);
		return msg;
	}
	
}

