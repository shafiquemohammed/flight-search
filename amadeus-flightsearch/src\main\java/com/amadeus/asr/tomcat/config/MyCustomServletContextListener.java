package com.amadeus.asr.tomcat.config;

import java.util.Collections;
import java.util.List;

import com.amadeus.asr.refdata.ReferenceData;
import com.amadeus.asr.supplier.CSVSupplier;
import com.amadeus.asr.supplier.FlightSupplier;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.google.inject.servlet.ServletModule;
import com.squarespace.jersey2.guice.JerseyGuiceServletContextListener;


public class MyCustomServletContextListener extends JerseyGuiceServletContextListener{

	 @Override
	    protected List<? extends Module> modules() {
	        return Collections.singletonList(new ServletModule() {
	            @Override
	            protected void configureServlets() {
	            	bind(String.class).annotatedWith(Names.named("csvPath")).toInstance("./flightCSV");
	            	bind(ReferenceData.class);
	            	bind(FlightSupplier.class).to(CSVSupplier.class);
	            	bind(JacksonJsonProvider.class);
	            }
	        });
	    }

}
