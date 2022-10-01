package unionFind.problems;

/**
 * You are given an array of strings equations that represent relationships between variables where each string
 * equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are
 * lowercase letters (not necessarily different) that represent one-letter variable names.
 * <p>
 * Return true if it is possible to assign integers to variable names to satisfy all the given equations, or
 * false otherwise.
 * <p>
 * <code>
 * Input: equations = ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
 * There is no way to assign the variables to satisfy both equations.
 * <p>
 * Input: equations = ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 * </code>
 */
public class SatisfiabilityOfEquations {
    public static boolean isSatisfied(String[] equations) {
        int[] root = new int[26]; // only 26 lower case letters
        for (int i = 0; i < 26; i++)
            root[i] = i;
        // add all equalities to a set
        for (String eq : equations) {
            if (eq.charAt(1) == '=')
                root[find(eq.charAt(0) - 'a', root)] = find(eq.charAt(3) - 'a', root);
        }
        // now if we find an edge between equalities and un-equalities then the equations are incorrect
        for (String eq : equations) {
            if (eq.charAt(1) == '!')
                if (find(eq.charAt(0) - 'a', root) == find(eq.charAt(3) - 'a', root))
                    return false;
        }
        return true;
    }

    private static int find(int x, int[] root) {
        if (x != root[x]) return root[x] = find(root[x], root);
        return x;
    }
    // no rank compression is needed because size is 26 (constant)

    public static void main(String[] args) {
        System.out.println(isSatisfied(new String[]{"a==b", "b!=a"}));
        System.out.println(isSatisfied(new String[]{"b==a", "a==b"}));
    }
}
