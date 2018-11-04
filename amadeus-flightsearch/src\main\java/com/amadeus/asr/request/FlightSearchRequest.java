package com.amadeus.asr.request;

import java.util.List;

public class FlightSearchRequest {

	private List<String> carriers;
	
	private String carrierId;

	public List<String> getCarriers() {
		return carriers;
	}

	public void setCarriers(List<String> carriers) {
		this.carriers = carriers;
	}

	public String getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	
	
	
}
