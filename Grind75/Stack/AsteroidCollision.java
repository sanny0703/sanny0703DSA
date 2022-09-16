package Stack;

import java.util.*;

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 * <p>
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * <p>
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * <p>
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 */
public class AsteroidCollision {
    public static int[] collision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid)
                stack.pop();
            if (stack.isEmpty() || asteroid > 0 || stack.peek() < 0)
                stack.push(asteroid);
            else if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() == -asteroid)
                stack.pop();
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    public static int[] efficient(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean blows;
        for (int asteroid : asteroids) {
            blows = false;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0 && !blows) {
                if (-asteroid < stack.peek()) // asteroid blows when collided with asteroid of greater energy and the asteroid with more energy doesn't blow
                    blows = true;
                else if (-asteroid == stack.peek()) { // when energy of both asteroids are equal both are blown
                    stack.pop();
                    blows = true;
                } else stack.pop(); // the low energy asteroid is blown
            }
            if (!blows) // even after collision if the asteroid doesn't blow add it to the stack
                stack.push(asteroid);
        }
        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--)



            ans[i] = stack.pop();
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(collision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(efficient(new int[]{5, 10, -5})));
    }
}
