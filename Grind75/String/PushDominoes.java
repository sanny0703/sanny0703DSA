package String;

/**
 * There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push
 * some dominoes either to the left or to the right.
 * <br>
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the
 * dominoes falling to the right push their adjacent dominoes standing on the right.
 * <br>
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
 * <br>
 * For the purposes of this question, we will consider that a falling domino expends no additional force to a falling
 * or already fallen domino.
 * <br>
 * You are given a string dominoes representing the initial state where:
 * <br>
 * dominoes[i] = 'L', if the ith domino has been pushed to the left,
 * dominoes[i] = 'R', if the ith domino has been pushed to the right, and
 * dominoes[i] = '.', if the ith domino has not been pushed.
 * Return a string representing the final state.
 * <br>
 * <code>
 * Input: dominoes = "RR.L"
 * Output: "RR.L"
 * Explanation: The first domino expends no additional force on the second domino.
 * <p>
 * Input: dominoes = ".L.R...LR..L.."
 * Output: "LL.RR.LLRRLL.."
 * </code>
 */
public class PushDominoes {
    public static String push(String s) {
        // to take care of starting and ending with '.'
        s = "L" + s + "R";
        StringBuilder result = new StringBuilder();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '.') continue;
            // j-i+1 gives length including the two ends but j-i-1 gives length excluding the two ends :)
            int middlePartLength = j - i - 1;
            if (i > 0)
                // because we added extra "L" which is not part of actual s
                result.append(s.charAt(i));
            if (s.charAt(i) == s.charAt(j))
                // 'L'..'L' and 'R'..'R' case
                result.append(String.valueOf(s.charAt(i)).repeat(Math.max(0, middlePartLength)));
            else if (s.charAt(i) == 'L' && s.charAt(j) == 'R')
                // in this case also middle part is not affected as either sides fall either side
                result.append(".".repeat(Math.max(0, middlePartLength)));
            else {
                //'R'...'L' case
                result.append(String.valueOf(s.charAt(i)).repeat(Math.max(0, middlePartLength / 2)));
                // only the exact mid-point won't be affected because opposing forces get canceled at mid
                if (middlePartLength % 2 == 1)
                    result.append('.');
                result.append(String.valueOf(s.charAt(j)).repeat(Math.max(0, middlePartLength / 2)));
            }
            i = j;// update the start point after we are done with that particular pair
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(push(".L.R...LR..L.."));
    }
}
