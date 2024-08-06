import java.util.*;

public class LeetCode146 {
    class LRUCache {
        private LinkedHashMap<Integer, Integer> map;
        private int capacity;

        public LRUCache(int capacity) {
            map = new LinkedHashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            int value = -1;
            if (map.containsKey(key)) {
                value = map.remove(key);
                map.put(key, value);
            }
            return value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.remove(key);
            }
            map.put(key, value);
            if (map.size() > capacity)
                map.remove(map.entrySet().iterator().next().getKey());
        }
    }

}
