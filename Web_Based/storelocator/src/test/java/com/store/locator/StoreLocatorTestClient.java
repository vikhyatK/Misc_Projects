package com.store.locator;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.store.locator.model.Store;

 
public class StoreLocatorTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8080/storelocator";
	private static final String ZIPCODE = "98009";
	private static final long RADIUS = 100;
	private static String NEW_USER_ID = "0";

    /* POST */
    private static void createStore() {
        System.out.println("Testing create Store API----------");
        RestTemplate restTemplate = new RestTemplate();
        Store store = new Store();
        store.setId(0);
        store.setName("McDonalds Aundh Pune");
        store.setAddress("Opposite Wetend Mall, Aundh");
        store.setLatitude(18.5617902);
        store.setLongitude(73.8072249);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/store/", store, Store.class);
        NEW_USER_ID = uri.toString().split("/")[5];
        System.out.println("Location : "+uri.toASCIIString());
    }
 
    /* PUT */
    private static void updateStore() {
        System.out.println("Testing update Store API----------");
        RestTemplate restTemplate = new RestTemplate();
        Store store  = new Store();
        store.setId(1);
        store.setName("McDonalds Aundh Pune Updated");
        store.setAddress("Opposite Wetend Mall, Aundh");
        store.setLatitude(18.5617902);
        store.setLongitude(73.8072249);
        restTemplate.put(REST_SERVICE_URI+"/store/1", store);
        System.out.println(store);
    }
 
    /* DELETE */
    private static void deleteStore() {
        System.out.println("Testing delete Store API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/store/" + NEW_USER_ID);
    }
 
    /* GET */
    @SuppressWarnings("unchecked")
    private static void listStoresInVicinity(){
        System.out.println("Testing listStoresInVicinity API-----------");
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> storesList = restTemplate.getForObject(REST_SERVICE_URI+"/store?zipcode=" + ZIPCODE + "&" + "radius=" + RADIUS, List.class);
        if(storesList!=null){
            for(LinkedHashMap<String, Object> store : storesList){
            	System.out.println("User : id="+store.get("id")+", Name="+store.get("name")+", Address="+store.get("address"));
            }
        }else{
            System.out.println("No store exist----------");
        }
    }

    public static void main(String args[]) {
        createStore();
        updateStore();
        deleteStore();
        listStoresInVicinity();
    }
}