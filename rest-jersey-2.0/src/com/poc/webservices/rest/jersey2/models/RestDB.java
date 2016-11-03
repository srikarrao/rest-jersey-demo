package com.poc.webservices.rest.jersey2.models;

import java.util.HashMap;
import java.util.Map;

/**
 * JAVA program to implement static data as database
 * 
 * @author SrikarRao
 *
 */
public class RestDB {

	private static Map<Integer, String> restSampleDataMap = new HashMap<Integer, String>();

	/**
	 * method to get data
	 * 
	 * @param index
	 * @return
	 */
	public String getData(int index) {
		loadMapData();
		if (restSampleDataMap.containsKey(index)) {
			return restSampleDataMap.get(index);
		}
		return null;
	}

	/**
	 * method to load data of the entrepreneurs
	 */
	private static void loadMapData() {
		restSampleDataMap.put(1, "Srikar Gandla");
		restSampleDataMap.put(2, "Elon Musk");
		restSampleDataMap.put(3, "Steve Wozniak");
		restSampleDataMap.put(4, "Steve Jobs");
		restSampleDataMap.put(5, "Peter Thiel");
		restSampleDataMap.put(6, "Bill Gates");
		restSampleDataMap.put(7, "Mark Zuckenberg");
		restSampleDataMap.put(8, "Steve Balmer");
		restSampleDataMap.put(9, "Warren Buffet");
		restSampleDataMap.put(10, "Sherlyn Sandberg");
		restSampleDataMap.put(11, "Marsissa Mayer");
		restSampleDataMap.put(12, "Sean Parker");
		restSampleDataMap.put(13, "Larry Page");
		restSampleDataMap.put(14, "Sergey Brin");
		restSampleDataMap.put(15, "Tim Cook");
		restSampleDataMap.put(16, "Jeff Bezos");
		restSampleDataMap.put(17, "Jack Ma");
		restSampleDataMap.put(18, "Sundar Pichai");
		restSampleDataMap.put(19, "Satya Nadella");
		restSampleDataMap.put(20, "Ritesh Agarwal");
	}
}
