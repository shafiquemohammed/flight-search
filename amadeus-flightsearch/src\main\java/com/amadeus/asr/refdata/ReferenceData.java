package com.amadeus.asr.refdata;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.amadeus.asr.supplier.FlightSupplier;
import com.google.inject.Inject;

/**
 * Contains methods to work with reference/referential data.
 * 
 */

public class ReferenceData {

	@Inject
	private FlightSupplier flightSupplier;

	public ReferenceData() {

	}

	////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////// AIRCRAFT HANDLERS
	//////////////////////////////////////////////////////////////////////////////////////////// /////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Returns owners of this fleet and sub fleet
	 * 
	 * @param fleetType
	 * @param fleetSubtype
	 * @return
	 */
	public Set<String> getOwners(String fleetType, String fleetSubtype) {
		return null;
	}

	/**
	 * Method to get All Active Aircraft owned by a set of operators
	 *
	 * @param carrierIataOrIcaoCodes
	 * @return
	 */
	public Collection<String> getAllAircraft(String... carrierIataOrIcaoCodes) {
		return null;
	}

	/**
	 * Returns Aircraft Fitted Configuration by using the tailNumber
	 * 
	 * @param tailNumber
	 * @return
	 */
	public Optional<String> getAircraftFittedConfiguration(String tailNumber) {
		return null;
	}

	/**
	 * Returns Aircraft Fitted Configuration by using the configId
	 * 
	 * @param configId
	 * @return
	 */
	public Optional<String> getAircraftFittedConfiguration(Number configId) {
		return null;
	}
	
	/**
	 * Returns Aircraft Fitted Configuration by using the configId
	 * 
	 * @param configId
	 * @return
	 */
	public Set<String> getAircraftFittedConfiguration(List<String> carriers, String carrierId) {
		return flightSupplier.getFlights(carriers, carrierId);
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////// AIRPORT HANDLERS
	//////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Returns all airports stored in refData program.
	 */
	public Collection<String> getAllAirports() {
		return null;
	}

	/**
	 * Returns the IATA code of the given ICAO code.
	 */
	public Optional<String> toIata(String icao) {
		return null;
	}

}