package com.store.locator.model;

import java.math.BigDecimal;

public class GeoLatLong {

	private BigDecimal latitude;
	private BigDecimal longitude;
	/**
	 * 
	 */
	public GeoLatLong() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param lattitude
	 * @param longitude
	 */
	public GeoLatLong(BigDecimal latitude, BigDecimal longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	
}
