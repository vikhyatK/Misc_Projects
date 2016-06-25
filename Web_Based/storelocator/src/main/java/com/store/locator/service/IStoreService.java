package com.store.locator.service;

import java.util.List;

import com.store.locator.model.Store;

public interface IStoreService {

	public Store findById(long id);
	
	public boolean isStoreExist(Store store);

	public void saveStore(Store store);
	
	public void updateStore(Store store);
	
	public void deleteStore(long id);
	
	public List<Store> findStoresByVicinity(String zipcode, long radius);
	
}
