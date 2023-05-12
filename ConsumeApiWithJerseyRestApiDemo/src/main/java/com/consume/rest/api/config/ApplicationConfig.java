package com.consume.rest.api.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.consume.rest.api.controller.BookController;
import com.consume.rest.api.filter.ContextListener;

@ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {
		register(BookController.class);
		register(ContextListener.class);
		register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO,
				LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
	}

}