package com.github.mikeldpl.inflector.jaxrs.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.mikeldpl.inflector.exceptions.DemoException;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Component
public class DemoExceptionMapper implements ExceptionMapper<DemoException> {
    @Override
    public Response toResponse(DemoException exception) {
        return Response.status(422).entity("Json Exception").build();
    }
}
