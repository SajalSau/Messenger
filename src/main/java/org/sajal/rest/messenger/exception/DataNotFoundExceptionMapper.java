package org.sajal.rest.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.sajal.rest.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage excMessage = new ErrorMessage ("404",exception.getMessage(),"Search Properly");
		return Response.status(Status.NOT_FOUND)
				.entity(excMessage)
				.build();
	}

}
