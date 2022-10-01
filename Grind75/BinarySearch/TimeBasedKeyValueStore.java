package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
 * <p>
 * Implement the TimeMap class:
 * <p>
 * TimeMap() Initializes the object of the data structure.
 * void set(String key, String value, int timestamp) Stores the key with the  value at the given time timestamp.
 * String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 */
public class TimeBasedKeyValueStore {
    private Map<String, List<Pair>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int time) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(value, time));
    }

    public String get(String key, int time) {
        if (!map.containsKey(key)) return "";
        return binarySearch(map.get(key), time);
    }

    // just find the floor in ascending order sorted array
    public String binarySearch(List<Pair> list, int time) {
        int n = list.size();
        int low = 0, high = n - 1;
        int index = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int currentTime = list.get(mid).time;
            if (currentTime == time)
                return list.get(mid).value;
            if (currentTime < time) {
                int previousTime = list.get(index).time;
                // take the max possible
                if (currentTime > previousTime)
                    index = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        return list.get(index).time <= time ? list.get(index).value : "";
    }

    public class Pair {
        int time;
        String value;

        public Pair(String value, int time) {
            this.value = value;
            this.time = time;
        }
    }
}
