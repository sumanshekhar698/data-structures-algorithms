package company.munix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CacheQueries {

    public static void main(String[] args) {

    }

    static List<Integer> getQueryAnswer(List<List<String>> cache_entries, List<List<String>> queries) {


        // Create a HashMap to store key-value pairs with timestamps
        HashMap<String, Integer> cache = new HashMap<>();

        // Parse cache entries
        // Parse cache entries
        for (List<String> entry : cache_entries) {
            String timestamp = entry.get(0);
            String key = entry.get(1);
            String value = entry.get(2);

            // Use timestamp as part of the key to differentiate entries
            String combinedKey = key + ":" + timestamp;

            // Create a list if it doesn't exist for the key
            if (!cache.containsKey(combinedKey)) {
                cache.put(combinedKey, Integer.valueOf(value));
            }

        }

        // Process queries and store results
        List<Integer> results = new ArrayList<>();
        for (List<String> query : queries) {
            String key = query.get(0);
            String targetTimestamp = query.get(1);

            // Find the entry with the matching key and the closest timestamp
            // Find the entries with the matching key
            String combinedKey = key + ":" + targetTimestamp;
            if (cache.containsKey(combinedKey)) {
                Integer queryFromCache = cache.get(key + ":" + targetTimestamp);
                results.add(queryFromCache);
            }
        }
        return results;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;

        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
