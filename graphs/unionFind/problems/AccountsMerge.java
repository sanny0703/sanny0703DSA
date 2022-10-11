package unionFind.problems;

import java.util.*;

/**
 * Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0]
 * is a name, and the rest of the elements are emails representing emails of the account.
 * <p>
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common
 * email to both accounts. Note that even if two accounts have the same name, they may belong to different people as
 * people could have the same name. A person can have any number of accounts initially, but all of their accounts
 * definitely have the same name.
 * <p>
 * After merging the accounts, return the accounts in the following format: the first element of each account is the
 * name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 * <p>
 * <code>
 * Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com",
 * "john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John",
 * "johnnybravo@mail.com"]]
 * Explanation:
 * The first and second John's are the same person as they have the common email "johnsmith@mail.com".
 * The third John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John',
 * 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * <p>
 * Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co",
 * "Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co",
 * "Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
 * Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],
 * ["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],
 * ["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 * </code>
 */
public class AccountsMerge {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parents = new HashMap<>();
        Map<String, String> owners = new HashMap<>();
        Map<String, TreeSet<String>> union = new HashMap<>();
        for (List<String> account : accounts) {
            String owner = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                parents.put(account.get(i), account.get(i));
                owners.put(account.get(i), owner);
            }
        }
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            String parent = find(parents, firstEmail);
            for (int i = 2; i < account.size(); i++) {
                parents.put(find(parents, account.get(i)), parent);
            }
        }
        for (List<String> account : accounts) {
            String parent = find(parents, account.get(1));
            if (!union.containsKey(parent))
                union.put(parent, new TreeSet<>());
            for (int i = 1; i < account.size(); i++)
                union.get(parent).add(account.get(i));
        }
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (String parent : union.keySet()) {
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(owners.get(parent));
            mergedAccount.addAll(union.get(parent));
            mergedAccounts.add(mergedAccount);
        }
        return mergedAccounts;
    }

    private static String find(Map<String, String> parents, String email) {
        if (!email.equals(parents.get(email))) {
            parents.put(email, find(parents, parents.get(email)));
            return parents.get(email);
        }
        return email;
    }

    public static void main(String[] args) {
        System.out.println(accountsMerge(Arrays.asList(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail" +
                ".com"), Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"), Arrays.asList("Mary", "mary@mail.com"), Arrays.asList(
                "John",
                "johnnybravo@mail.com"))));
    }
}
