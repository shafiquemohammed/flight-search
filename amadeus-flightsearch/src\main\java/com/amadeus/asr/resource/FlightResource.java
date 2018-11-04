package com.amadeus.asr.resource;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.amadeus.asr.exceptions.AmadeusFlightSearchExceptionHandler;
import com.amadeus.asr.refdata.ReferenceData;
import com.amadeus.asr.request.FlightSearchRequest;
import com.google.inject.Inject;

@Path("flights")
public class FlightResource {

	@Inject
	private ReferenceData referenceData;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getFlights(FlightSearchRequest request) {
		if (request.getCarriers() != null && request.getCarrierId() != null) {
			try {
			Set<String> flightsConfiguration = referenceData.getAircraftFittedConfiguration(request.getCarriers(),
					request.getCarrierId());
			return Response.ok(flightsConfiguration).build();
			}catch (AmadeusFlightSearchExceptionHandler e) {
				System.out.println(e.getMessage());
				return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();
			}
		}
		return null;
	}
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	public Response getMessage() {
		return Response.ok("Hi Shafique").build();
	}
}
