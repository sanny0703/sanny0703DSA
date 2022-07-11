package Queue.DesignHitCounter;

import java.util.ArrayDeque;

/**
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 */
public class Basic {
    private static final int MAX = 300;//5 minutes;
    private final ArrayDeque<Integer> queue;

    public Basic() {
        queue = new ArrayDeque<>();
    }

    public void hit(int timestamp) {
        queue.addLast(timestamp);
    }

    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.getFirst() >= MAX)
            queue.removeFirst();
        return queue.size();
    }

    public static void main(String[] args) {
        Basic hitCounter = new Basic();
        hitCounter.hit(1);
        hitCounter.hit(200);
        hitCounter.hit(310);
        System.out.println(hitCounter.getHits(300));
    }
}
