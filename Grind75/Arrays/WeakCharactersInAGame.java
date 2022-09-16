package Arrays;

import java.util.Arrays;

/**
 * You are playing a game that contains multiple characters, and each of the characters has two main properties: attack and defense.
 * You are given a 2D integer array properties where properties[i] = [attacki, defensei] represents the properties of the ith character in the game.
 * <p>
 * A character is said to be weak if any other character has both attack and defense levels strictly greater than this character's attack and defense levels.
 * More formally, a character i is said to be weak if there exists another character j where attackj > attacki and defensej > defensei.
 * <p>
 * Return the number of weak characters.
 * <p>
 * Input: properties = [[5,5],[6,3],[3,6]]
 * Output: 0
 * Explanation: No character has strictly greater attack and defense than the other.
 * <p>
 * Input: properties = [[1,5],[10,4],[4,3]]
 * Output: 1
 * Explanation: The third character is weak because the second character has a strictly greater attack and defense.
 */
public class WeakCharactersInAGame {
    public static int weakCharacters(int[][] properties) {
        int weakCharacters = 0;
        // we have to worry about two variables attack and defense, so lets just be done with one of them,
        // sort the properties based on attack in decreasing order and if attack is same sort them on defence increasing
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        //since attack is decreasing now, we just have to take care of max defence so far,
        // because if defence is low(as attack is decreasing),then it is a week one
        int maxDefence = 0;
        for (int[] property : properties) {
            if (property[1] < maxDefence)
                weakCharacters++;
            maxDefence = Math.max(maxDefence, property[1]);
        }
        return weakCharacters;
    }

    public static void main(String[] args) {
        System.out.println(weakCharacters(new int[][]{{5, 5}, {6, 3}, {3, 6}}));
        System.out.println(weakCharacters(new int[][]{{1, 5}, {10, 4}, {4, 3}}));
    }
}
