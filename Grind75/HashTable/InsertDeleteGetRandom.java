package HashTable;

import java.util.*;

/**
 * Implement the RandomizedSet class:
 * <p>
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 */
public class InsertDeleteGetRandom {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random rand = new Random();

    public InsertDeleteGetRandom() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if (contains) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        boolean contains = map.containsKey(val);
        if (!contains) return false;
        int loc = map.get(val);
        if (loc != list.size() - 1) {
            int lastOne = list.get(list.size() - 1);
            map.put(lastOne, loc);
            list.set(loc, lastOne);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
