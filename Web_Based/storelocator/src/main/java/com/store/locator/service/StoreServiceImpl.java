package com.store.locator.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.store.locator.model.GeoLatLong;
import com.store.locator.model.Store;
import com.store.locator.util.FileUtil;

@Service("storeService")
@Transactional
public class StoreServiceImpl implements IStoreService {

	private static final AtomicLong counter = new AtomicLong();

	private static Map<Long, Store> stores = new HashMap<>();

	static {
		stores = populateDummyStores();
	}

	@Override
	public Store findById(long id) {
		return stores.get(id);
	}

	@Override
	public boolean isStoreExist(Store store) {
		return stores.containsValue(store);
	}

	@Override
	public Store saveStore(Store store) {
		store.setId(counter.incrementAndGet());
		stores.put(store.getId(), store);
		return store;
	}

	@Override
	public void updateStore(Store store) {
		stores.put(store.getId(), store);
	}

	@Override
	public void deleteStore(long id) {
		stores.remove(id);
	}

	@Override
	public List<Store> findStoresByVicinity(String zipcode, long radius) {
		List<Store> storesInVicinity = new ArrayList<>();
		GeoLatLong geoLatLong = getPostalCodesLatLong(zipcode);
		for (Entry<Long, Store> entry : stores.entrySet()) {
			Store store = entry.getValue();
			double distance = calculateDistance(geoLatLong.getLatitude(), geoLatLong.getLongitude(),
					store.getLatitude(), store.getLongitude());
			if (distance <= radius*1000) {
				storesInVicinity.add(store);
			}
		}
		return storesInVicinity;
	}

	private static Map<Long, Store> populateDummyStores() {
		return FileUtil.getDummyStores("files/storesData.txt");
	}

	private GeoLatLong getPostalCodesLatLong(String postalCode) {
		GeoLatLong geoLatLong = null;
		final Geocoder geocoder = new Geocoder();
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(postalCode).getGeocoderRequest();
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		GeocoderResult result = geocoderResponse.getResults().get(0);
		if (result != null) {
			geoLatLong = new GeoLatLong();
			geoLatLong.setLatitude(result.getGeometry().getLocation().getLat());
			geoLatLong.setLongitude(result.getGeometry().getLocation().getLng());
		}
		return geoLatLong;
	}

	private double calculateDistance(BigDecimal lat1, BigDecimal lng1, BigDecimal lat2, BigDecimal lng2) {
		double phi1 = Math.toRadians(lat1.doubleValue());
		double phi2 = Math.toRadians(lat2.doubleValue());
		double delta = Math.toRadians(lng2.doubleValue() - lng1.doubleValue());
		long R = 6371000;
		return Math.acos(Math.sin(phi1) * Math.sin(phi2) + Math.cos(phi1) * Math.cos(phi2) * Math.cos(delta)) * R;
	}
}
