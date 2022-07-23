package HashTable;

import java.util.*;

/**
 * We are given some website visits: the user with name username[i] visited the website,website[i] at time timestamp[i].
 * <p>
 * A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits. (The websites in a 3-sequence are not necessarily distinct.)
 * <p>
 * Find the 3-sequence visited by the largest number of users. If there is more than one solution, return the lexicographically smallest such 3-sequence.
 * <p>
 * Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
 * Output: ["home","about","career"]
 * Explanation:
 * The tuples in this example are:
 * ["joe", 1, "home"]
 * ["joe", 2, "about"]
 * ["joe", 3, "career"]
 * ["james", 4, "home"]
 * ["james", 5, "cart"]
 * ["james", 6, "maps"]
 * ["james", 7, "home"]
 * ["mary", 8, "home"]
 * ["mary", 9, "about"]
 * ["mary", 10, "career"]
 * The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
 * The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
 * The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
 * The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
 * The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.
 */
public class AnalyzeUserVisitPattern {
    public static List<String> analyze(String[] userName, int[] timestamp, String[] website) {
        User[] users = new User[userName.length];
        for (int i = 0; i < users.length; i++) {
            users[i] = new User(userName[i], timestamp[i], website[i]);
        }
        //first let's sort the users based on timestamp
        Arrays.sort(users);
        // no we need a user history of each website, so create a map to hold that info
        Map<String, List<String>> userHistory = new HashMap<>();
        for (User user : users) {
            List<String> history = userHistory.getOrDefault(user.userName, new ArrayList<>());
            history.add(user.website);
            System.out.println(userHistory.get(user.userName));
            userHistory.put(user.userName, history);
        }
        // Now we just have to create unique combinations of size 3 from each user history and maintain a Count of each
        // such unique combination and just return the combination with majority count

        // map to count occurrence of each unique combination
        Map<String, Integer> countMap = new HashMap<>();
        // map to hold the sequence that has the count mentioned in countMap
        Map<String, List<String>> sequenceMap = new HashMap<>();
        int maxCount = 0; // variable to store max frequency of a sequence
        for (String u : userHistory.keySet()) {
            Set<String> uniqueSequences = new HashSet<>();
            List<String> list = userHistory.getOrDefault(u, new ArrayList<>());
            int n = list.size();
            if (n >= 3) {
                for (int i = 0; i < n - 2; i++) {
                    for (int j = i + 1; j < n - 1; j++) {
                        for (int k = j + 1; j < n; j++) {
                            List<String> currentSequence = Arrays.asList(list.get(i), list.get(j), list.get(k));
                            String currentSequenceString = currentSequence.toString();
                            if (uniqueSequences.add(currentSequenceString)) {
                                countMap.put(currentSequenceString, countMap.getOrDefault(currentSequenceString, 0) + 1);
                                maxCount = Math.max(maxCount, countMap.get(currentSequenceString));
                                sequenceMap.put(currentSequenceString, currentSequence);
                            }
                        }
                    }
                }
            }
        }
        List<List<String>> candidates = new ArrayList<>();
        for (String sequence : countMap.keySet()) {
            if (maxCount == countMap.get(sequence))
                candidates.add(sequenceMap.get(sequence));
        }
        if (candidates.size() == 1)
            return candidates.get(0);
        Collections.sort(candidates, Comparator.comparing(Object::toString));
        return candidates.get(0);
    }

    public static void main(String[] args) {
        String[] userName = {"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
        int[] timestamp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] website = {"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};
        System.out.println(analyze(userName, timestamp, website));
    }

    static class User implements Comparable<User> {
        String userName;
        int timestamp;
        String website;

        public User(String userName, int timestamp, String website) {
            this.userName = userName;
            this.timestamp = timestamp;
            this.website = website;
        }

        @Override
        public int compareTo(User that) {
            if (this.timestamp != that.timestamp)
                return this.timestamp - that.timestamp;
            return this.userName.compareTo(that.userName);
        }
    }
}
