package com.store.locator.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.store.locator.model.Store;
import com.store.locator.util.FileUtil;

public class StoreServiceImpl implements IStoreService{

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
	public void saveStore(Store store) {
		store.setId(counter.incrementAndGet());
		stores.put(store.getId(), store);
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
		return null;
	}


	private static Map<Long, Store> populateDummyStores() {
		return FileUtil.getDummyStores("file/storesData.txt");
	}

}
