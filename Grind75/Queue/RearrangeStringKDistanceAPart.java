package Queue;


import java.util.*;

/**
 * Given a non-empty string str and an integer k,
 * rearrange the string such that the same characters are at least distance k from each other.
 * <p>
 * All input strings are given in lowercase letters.
 * If it is not possible to rearrange the string, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * str = "aabbcc", k = 3
 * <p>
 * Result: "abcabc"
 * <p>
 * The same letters are at least distance 3 from each other.
 */
public class RearrangeStringKDistanceAPart {
    public static String rearrange(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        Queue<Pair> queue = new PriorityQueue<>((a, b) -> {
            if (a.count != b.count) return b.count - a.count;
            return a.ch - b.ch;
        });
        for (char c : map.keySet())
            queue.offer(new Pair(c, map.get(c)));
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        while (!queue.isEmpty()) {
            List<Pair> list = new ArrayList<>(); // this is to take care of the case where we add,the same char within the k block
            int d = Math.min(k, len);
            for (int i = 0; i < d; i++) {
                if (queue.isEmpty()) return "";
                Pair currentPair = queue.poll();
                sb.append(currentPair.ch);
                if (--currentPair.count > 0) list.add(currentPair); // if we directly add to the queue here,if it has high enough count ,it might come in the next
                //same k block
                len--;
            }
            queue.addAll(list);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(rearrange("aabbcc", 3));
        System.out.println(rearrange("aaabc", 3));
    }

    private static class Pair {
        char ch;
        int count;

        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
