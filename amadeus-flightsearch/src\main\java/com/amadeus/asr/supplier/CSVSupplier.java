package com.amadeus.asr.supplier;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.amadeus.asr.exceptions.AmadeusFlightSearchExceptionHandler;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import au.com.bytecode.opencsv.CSVReader;

public class CSVSupplier implements FlightSupplier {

	Set<String> searchResponses = new TreeSet<String>();
	@Inject
	@Named("csvPath")
	private String csvPath;

	public Set<String> getFlights(List<String> carriers, String carrierId) {
		searchResponses = loadCSVFile(carriers, carrierId);
		return searchResponses;
	}

	private Set<String> loadCSVFile(List<String> carriers, String carrierId) {
		Set<String> response = null;
		Set<String> flightDataList = new TreeSet<String>();;
		CSVReader reader;
		try {
			reader = getCSVReader();

			String[] nextLine;

			while ((nextLine = reader.readNext()) != null) {
				StringBuffer flightsConfig = new StringBuffer();
				if (carriers.contains(nextLine[0]) && nextLine[2].startsWith(carrierId)) {
					flightsConfig.append(nextLine[0]).append("\t").append(nextLine[1]).append("\t").append(nextLine[2])
							.append("\t").append(nextLine[3]).append("\t").append(nextLine[4]);
					flightDataList.add(flightsConfig.toString());
				}

			}
			if (flightDataList.size() == 0) {
				throw new AmadeusFlightSearchExceptionHandler("No Flight Configuration Found ");
			}else {
				response = new TreeSet<String>();
				prepareHeader(response);
				response = flightDataList;
			}

		} catch (FileNotFoundException e) {
			throw new AmadeusFlightSearchExceptionHandler("Flight Data file Not Found");
		} catch (IOException e) {
			throw new AmadeusFlightSearchExceptionHandler("Unable to Server the Request Temporarily");
		}

		return response;
	}

	private void prepareHeader(Set<String> searchResponses) {
		StringBuffer resultHeader = new StringBuffer();
		resultHeader.append("Carriers").append("\t").append("Wings Type").append("\t").append("Carrier ID").append("\t")
				.append("Landing Gear Type").append("\t").append("Propulsion");
		searchResponses.add(resultHeader.toString());
	}

	private CSVReader getCSVReader() {
		InputStream is = CSVSupplier.class.getClassLoader().getResourceAsStream(csvPath + "/flightdata.csv");
		return new CSVReader(new InputStreamReader(is));
	}
}
