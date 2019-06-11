package org.sajal.rest.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidRequestExcMapper implements ExceptionMapper<InvalidRequestException> {

	@Override
	public Response toResponse(InvalidRequestException exception) {
		return Response.status(Status.BAD_REQUEST).entity(new InvalidRequestException("Exception Occurred and The request is Pretty BAD")).build();
	}

}
