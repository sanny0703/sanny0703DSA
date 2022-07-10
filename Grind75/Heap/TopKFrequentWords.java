package Heap;

import java.util.*;

/**
 * Given an array of strings words and an integer k, return the k most frequent strings.
 * <p>
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 * <p>
 * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
 * Output: ["the","is","sunny","day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 */
public class TopKFrequentWords {
    public static List<String> frequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        Queue<String> queue = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : a.compareTo(b));
        for (String word : map.keySet()) {
            queue.offer(word);
            if (queue.size() > k)
                queue.poll();
        }
        List<String> ans = new ArrayList<>();
        while (!queue.isEmpty())
            ans.add(0, queue.poll());
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(frequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
}
