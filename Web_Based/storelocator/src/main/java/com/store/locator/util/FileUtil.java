package com.store.locator.util;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.store.locator.model.Store;

public class FileUtil {

	public static Map<Long, Store> getDummyStores(String fileName) {
		FileUtil fileUtil = new FileUtil();
		return fileUtil.getDummyStoresData(fileName);
	}

	private Map<Long, Store> getDummyStoresData(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		Map<Long, Store> stores = new HashMap<>();
		File file = new File(classLoader.getResource(fileName).getFile());
		try(Scanner scanner = new Scanner(file)) {
			while(scanner.hasNextLine()) {
				String[] line = scanner.nextLine().split("##!##");
				BigDecimal lat = BigDecimal.valueOf(Double.valueOf(line[2]));
				BigDecimal lng = BigDecimal.valueOf(Double.valueOf(line[1]));
				Store store = new Store(Long.valueOf(line[0]), line[3], line[4], lat, lng);
				stores.put(store.getId(), store);
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stores;
	}
}
