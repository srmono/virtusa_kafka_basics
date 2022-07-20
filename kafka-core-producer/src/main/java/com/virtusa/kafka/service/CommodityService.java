package com.virtusa.kafka.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.virtusa.kafka.entity.Commodity;

@Service
public class CommodityService {

	public static final Map<String, Commodity> COMMODITY_BASE = new HashMap<>();
	
	private static final String COPPER = "copper";
	private static final String GOLD = "gold";
	private static final double MAX_ADJUSTMENT = 1.05d;
	private static final double MIN_ADJUSTMENT = 0.95d;
	
	static {
		var timestamp = System.currentTimeMillis();
	
		COMMODITY_BASE.put(COPPER, new Commodity(COPPER, 5_900.57, "tonne", timestamp));
		COMMODITY_BASE.put(GOLD, new Commodity(GOLD, 1_900.07, "ounce", timestamp));
	}
	
	public List<Commodity> createDummyCommodities() {
		var result = new ArrayList<Commodity>();
		
		COMMODITY_BASE.keySet().forEach(c -> result.add(createDummyCommodity(c)));
		
		return result;
	}
	
	public Commodity createDummyCommodity(String name) {
		if (!COMMODITY_BASE.keySet().contains(name)) {
			throw new IllegalArgumentException("Invalid Commodity " + name);
		}
		
		var commodity = COMMODITY_BASE.get(name);
		var basePrice = commodity.getPrice();
		var newPrice = basePrice * ThreadLocalRandom.current().nextDouble(MIN_ADJUSTMENT, MAX_ADJUSTMENT);
		commodity.setPrice(newPrice);
		commodity.setTimestamp(System.currentTimeMillis());
		
		return commodity;
	}
	
}





