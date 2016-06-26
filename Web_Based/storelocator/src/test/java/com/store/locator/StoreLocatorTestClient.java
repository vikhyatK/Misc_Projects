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
          
    /* GET */
    private static void getStore(){
        System.out.println("Testing getStore API----------");
        RestTemplate restTemplate = new RestTemplate();
        Store store = restTemplate.getForObject(REST_SERVICE_URI+"/store/1555", Store.class);
        System.out.println(store);
    }
     
    /* POST */
    private static void createStore() {
        System.out.println("Testing create Store API----------");
        RestTemplate restTemplate = new RestTemplate();
        Store store = new Store();
        store.setName("McDonalds Aundh Pune");
        store.setAddress("Opposite Wetend Mall, Aundh");
        store.setLatitude(18.5617902);
        store.setLongitude(73.8072249);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/store/", store, Store.class);
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
        restTemplate.delete(REST_SERVICE_URI+"/store/3");
    }
 
    /* GET */
    @SuppressWarnings("unchecked")
    private static void listStoresInVicinity(){
        System.out.println("Testing listStoresInVicinity API-----------");
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> storesMap = restTemplate.getForObject(REST_SERVICE_URI+"/store?zipcode=" + ZIPCODE + "&" + "radius=" + RADIUS, List.class);
        if(storesMap!=null){
            for(LinkedHashMap<String, Object> map : storesMap){
                System.out.println("Store : id="+map.get("id")+", Name="+map.get("name")+", Address="+map.get("address"));
            }
        }else{
            System.out.println("No store exist----------");
        }
    }

    public static void main(String args[]) {
        getStore();
        createStore();
        updateStore();
        deleteStore();
        listStoresInVicinity();
    }
}