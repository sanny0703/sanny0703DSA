package MatrixChainMultiplication.problems.EvaluateExpression;

public class RecursiveOptimised {

    public static int countTrue(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        Pair p = solve(s, i, j);
        return p.tCount;
    }

    public static Pair solve(String s, int i, int j) {
        if (i > j) return new Pair(0, 0);
        if (i == j) {
            Pair p = new Pair();
            p.tCount = s.charAt(i) == 'T' ? 1 : 0;
            p.fCount = s.charAt(i) == 'F' ? 1 : 0;
            return p;
        }
        int trueCount = 0, falseCount = 0;
        for (int k = i + 1; k < j; k += 2) {
            Pair left = solve(s, i, k - 1);
            Pair right = solve(s, k + 1, j);
            int lt = left.tCount;
            int lf = left.fCount;
            int rt = right.tCount;
            int rf = right.fCount;
            char c = s.charAt(k);
            if (c == '|') {
                trueCount += lt * rt + lf * rt + lt * rf;
                falseCount += lf * rf;
            } else if (c == '&') {
                trueCount += lt * rt;
                falseCount += lf * rt + lt * rf + lf * rf;
            } else {//^ case(XOR)
                trueCount += lt * rf + lf * rt;
                falseCount += lt * rt + lf * rf;
            }
        }
        return new Pair(trueCount, falseCount);
    }

    private static class Pair {
        int tCount, fCount;

        public Pair(int tCount, int fCount) {
            this.tCount = tCount;
            this.fCount = fCount;
        }

        public Pair() {

        }
    }

    public static void main(String[] args) {
        //2"((T ^ F) & T)" and "(T ^ (F & T))"
        System.out.println(countTrue("T^F&T"));
        // There are 4 ways
        // ((T|T)&(F^T)), (T|(T&(F^T))),
        // (((T|T)&F)^T) and (T|((T&F)^T))
        System.out.println(countTrue("T|T&F^T"));
    }
}
