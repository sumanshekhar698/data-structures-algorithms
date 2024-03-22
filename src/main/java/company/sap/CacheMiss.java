package company.sap;

import java.util.LinkedHashMap;

public class CacheMiss {

    public static void main(String[] args) {
        int[] inputNum = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0};
        int size = 3;
        int[] inputNum1 = {1, 2, 1, 3, 1, 2};
        int size1 = 2;
        System.out.println(cacheMisses(inputNum1, size1));
    }

    public static int cacheMisses(int[] inputNum, int size) {
        // Create a LinkedHashMap for efficient insertion and eviction based on usage order
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>(size);

        int misses = 0;

        // Iterate through each request
        for (int num : inputNum) {
            // Check if the requested number is already in the cache
            if (cache.containsKey(num)) {
                // Cache hit: Move the entry to the front of the map
                Integer i = cache.get(num);
                cache.remove(num);
                cache.put(num, i);
            } else {
                // Cache miss: Increment misses, add the entry, and potentially evict
                misses++;

                cache.put(num, 1);
                // If cache is full, evict the least recently used entry
                if (cache.size() > size) {
                    cache.remove(cache.entrySet().iterator().next().getKey());
                }
            }
        }

        return misses;
    }


}
