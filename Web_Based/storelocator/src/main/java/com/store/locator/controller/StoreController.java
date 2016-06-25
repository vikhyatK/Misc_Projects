package com.store.locator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.store.locator.model.Store;
import com.store.locator.service.IStoreService;

@RestController
public class StoreController {

	@Autowired
	IStoreService storeService;

	/**
	 * This method gets all stores in the vicinity of the given zip code and
	 * radius
	 * 
	 * @return
	 */
	@RequestMapping(value = "/store/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Store> getStore(@PathVariable("id") long id) {
		System.out.println("Finding store by id");
		Store store = storeService.findById(id);
		if (store == null) {
			System.out.println("Store with id " + id + " not found");
			return new ResponseEntity<Store>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Store>(store, HttpStatus.OK);
	}

	/**
	 * Creates a new store
	 * 
	 * @param store
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/store/", method = RequestMethod.POST)
	public ResponseEntity<Void> createStore(@RequestBody Store store, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Store " + store.getName());
		if (storeService.isStoreExist(store)) {
			System.out.println("A Store with name " + store.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		storeService.saveStore(store);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	/**
	 * Updates an existing store
	 * 
	 * @param id
	 * @param store
	 * @return
	 */
	@RequestMapping(value = "/store/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Store> updateStore(@PathVariable("id") long id, @RequestBody Store store) {
		System.out.println("Updating Store " + id);
		Store currentStore = storeService.findById(id);
		if (currentStore == null) {
			System.out.println("Store with id " + id + " not found");
			return new ResponseEntity<Store>(HttpStatus.NOT_FOUND);
		}
		currentStore.setName(store.getName());
		currentStore.setAddress(store.getAddress());
		currentStore.setLatitude(store.getLatitude());
		currentStore.setLongitude(store.getLongitude());
		storeService.updateStore(currentStore);
		return new ResponseEntity<Store>(currentStore, HttpStatus.OK);
	}

	/**
	 * Deletes an existing store
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/store/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Store> deleteStore(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting Store with id " + id);
		Store store = storeService.findById(id);
		if (store == null) {
			System.out.println("Unable to delete. Store with id " + id + " not found");
			return new ResponseEntity<Store>(HttpStatus.NOT_FOUND);
		}
		storeService.deleteStore(id);
		return new ResponseEntity<Store>(HttpStatus.NO_CONTENT);
	}

	/**
	 * This method gets all stores in the vicinity of the given zip code and
	 * radius
	 * 
	 * @return
	 */
	@RequestMapping(value = "/store", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Store>> getStores(@RequestParam("zipcode") String zipcode,
			@RequestParam("radius") long radius) {
		System.out.println("Finding All Stores in vicinity");
		List<Store> storesList = storeService.findStoresByVicinity(zipcode, radius);
		return new ResponseEntity<List<Store>>(storesList, HttpStatus.NO_CONTENT);
	}

}