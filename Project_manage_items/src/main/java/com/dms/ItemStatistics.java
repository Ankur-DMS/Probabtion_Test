package com.dms;

import java.util.HashMap;
import java.util.Map;

public class ItemStatistics {
	  private Map<String, Integer> categoryCounts;

	    public ItemStatistics() {
	        categoryCounts = new HashMap<>();
	    }

	    public void addItem(String category) {
	        categoryCounts.put(category, categoryCounts.getOrDefault(category, 0) + 1);
	    }

	    public int getTotalItemCount() {
	        int totalCount = 0;
	        for (int count : categoryCounts.values()) {
	            totalCount += count;
	        }
	        return totalCount;
	    }

	    public int getCategoryItemCount(String category) {
	        return categoryCounts.getOrDefault(category, 0);
	    }

	    public double getCategoryPercentage(String category) {
	        int totalItemCount = getTotalItemCount();
	        int categoryItemCount = getCategoryItemCount(category);

	        if (totalItemCount == 0) {
	            return 0.0;
	        }

	        return ((double) categoryItemCount / totalItemCount) * 100;
	    }
}
