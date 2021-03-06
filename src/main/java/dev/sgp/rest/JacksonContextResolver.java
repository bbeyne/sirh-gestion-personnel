package dev.sgp.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {

	private static final ObjectMapper OM = init();

	@Override
	public ObjectMapper getContext(Class<?> objectType) {
		return OM;
	}

	private static ObjectMapper init() {
		ObjectMapper om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
		// Date au format ISO
		om.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		return om;
	}
}
