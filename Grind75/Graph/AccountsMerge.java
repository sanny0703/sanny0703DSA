package Graph;

import java.util.*;

/**
 * Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 * <p>
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 * <p>
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 * <p>
 * <p>
 * Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * <p>
 * Approach:====
 * Treat emails as nodes and connect all nodes and just return all nodes in each component(sorted)
 */
public class AccountsMerge {
    private static Map<String, List<String>> adj;
    private static Set<String> visited;

    public static List<List<String>> merge(List<List<String>> accounts) {

        adj = new HashMap<>();
        visited = new HashSet<>();
        for (List<String> account : accounts) {
            String firsEmail = account.get(1);
            if (!adj.containsKey(firsEmail)) adj.put(firsEmail, new ArrayList<>());
            for (int j = 2; j < account.size(); j++) {
                String email = account.get(j);
                adj.get(firsEmail).add(email);
                if (!adj.containsKey(email)) adj.put(email, new ArrayList<>());
                adj.get(email).add(firsEmail);
            }
        }
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> account : accounts) {
            String accountName = account.get(0);
            String accountFirstEmail = account.get(1);
            if (!visited.contains(accountFirstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                mergedAccount.add(accountName);
                dfs(accountFirstEmail, mergedAccount);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }
        return mergedAccounts;
    }

    public static void dfs(String email, List<String> mergedAccount) {
        mergedAccount.add(email);
        visited.add(email);
        if (!adj.containsKey(email)) return;
        for (String neighbor : adj.get(email)) {
            if (!visited.contains(neighbor)) dfs(neighbor, mergedAccount);
        }
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        System.out.println(merge(accounts));
    }
}
