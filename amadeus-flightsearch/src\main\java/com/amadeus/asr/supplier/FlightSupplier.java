package com.amadeus.asr.supplier;

import java.util.List;
import java.util.Set;

public interface FlightSupplier {

	public Set<String> getFlights(List<String> carriers, String carrier);
	
}
