package Heap;

/**
 * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
 * <p>
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
 * <p>
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 * <p>
 * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * Output: 16
 * Explanation:
 * One possible solution is
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 */
public class TaskScheduler {
    /**
     * @param tasks tasks given to CPU
     * @param n     idle time between same tasks
     * @return total working time of cpu to complete all the tasks
     * <p>
     * <p>
     * <p>
     * just arrange all the tasks with the highest frequency and have slots open between them to fill the less frequency ones
     */
    public static int count(char[] tasks, int n) {
        int max = 0; // keeps track of the highest frequency
        int maxCount = 0; // keeps track of how many tasks have that highest frequency
        int[] counter = new int[26];// counter tto count frequency of all tasks
        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A']) // if we found one more task with max frequency maxCount++
                maxCount++;
            else if (max < counter[task - 'A']) { // if we found a task with frequency greater than max
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        int partsCount = max - 1; // no of parts the max frequency group  divides
        int partsLength = n - (maxCount - 1); // no of slots in each part
        int emptySlots = partsCount * partsLength; // total slots(all parts combined)
        int availableTasks = tasks.length - max * maxCount;//tasks remaining to be assigned to cpu
        int idle = Math.max(0, emptySlots - availableTasks); // total idle slots after all tasks are assigned
        return tasks.length + idle;

    }

    public static void main(String[] args) {
        System.out.println(count(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
    }
}
