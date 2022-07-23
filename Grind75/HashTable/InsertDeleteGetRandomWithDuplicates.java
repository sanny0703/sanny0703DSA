package HashTable;

import java.util.*;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * Note: Duplicate elements are allowed.
 * <p>
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements.
 * The probability of each element being returned is linearly related to the number of same value the collection contains.
 * <p>
 * Example:
 * <p>
 * // Init an empty collection.
 * RandomizedCollection collection = new RandomizedCollection();
 * <p>
 * // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 * collection.insert(1);
 * <p>
 * // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 * collection.insert(1);
 * <p>
 * // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 * collection.insert(2);
 * <p>
 * // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 * collection.getRandom();
 * <p>
 * // Removes 1 from the collection, returns true. Collection now contains [1,2].
 * collection.remove(1);
 * <p>
 * // getRandom should return 1 and 2 both equally likely.
 * collection.getRandom();
 */
public class InsertDeleteGetRandomWithDuplicates {
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random random = new Random();

    public InsertDeleteGetRandomWithDuplicates() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) map.put(val, new LinkedHashSet<>());
        list.add(val);
        map.get(val).add(list.size() - 1);
        return map.get(val).size() == 1;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0) return false;
        int removeIndex = map.get(val).iterator().next();
        map.get(val).remove(removeIndex);
        int last = list.get(list.size() - 1);
        list.set(removeIndex, last);
        map.get(last).remove(list.size() - 1);
        map.get(last).add(removeIndex);
        list.remove(list.size() - 1);
        return true;
    }

    public int random() {
        return list.get(random.nextInt(list.size()));
    }
}
