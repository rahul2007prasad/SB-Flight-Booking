package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airport")
public class Airport {
	@Id
	private Long iataCode;
	
	private String airportName;
	
	private String countryIsoCode;

	public Long getIataCode() {
		return iataCode;
	}

	public void setIataCode(Long iataCode) {
		this.iataCode = iataCode;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getCountryIsoCode() {
		return countryIsoCode;
	}

	public void setCountryIsoCode(String countryIsoCode) {
		this.countryIsoCode = countryIsoCode;
	}

	@Override
	public String toString() {
		return "Airport [iataCode=" + iataCode + ", airportName=" + airportName + ", countryIsoCode=" + countryIsoCode
				+ "]";
	}

	public Airport(Long iataCode, String airportName, String countryIsoCode) {
		super();
		this.iataCode = iataCode;
		this.airportName = airportName;
		this.countryIsoCode = countryIsoCode;
	}

}
