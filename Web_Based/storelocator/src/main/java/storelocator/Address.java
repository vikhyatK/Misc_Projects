package storelocator;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Address {

	private Long addressId;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String city;
	private String postalCode;
	private String state;
	private String province;
	private String county;
	private String country;
	private String latitude;
	private String longitude;
	private Store store;
	
	public Address() {
	}

	public Address(Long addressId, String addressLine1, String addressLine2, String addressLine3, String city,
			String postalCode, String state, String province, String county, String country, String latitude,
			String longitude) {
		super();
		this.addressId = addressId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.city = city;
		this.postalCode = postalCode;
		this.state = state;
		this.province = province;
		this.county = county;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Id
	@Column(name = "Address_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE)
	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	@Column(name = "Address_Line1")
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@Column(name = "Address_Line2")
	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@Column(name = "Address_Line3")
	public String getAddressLine3() {
		return this.addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	@Column(name = "City", length = 100)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "Postal_Code", length = 100)
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "State", length = 100)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "Province", length = 100)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "County", length = 100)
	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Column(name = "Country", length = 100)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "Latitude", length = 30)
	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "Longitude", length = 30)
	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "Address")
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}
