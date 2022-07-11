package Queue.DesignHitCounter;

/**
 * there can multiple hits at same timestamp
 */
public class Optimised {
    private final int[] times;
    private final int[] hits;
    private static final int MAX = 300;

    public Optimised() {
        times = new int[MAX];
        hits = new int[MAX];
    }

    public void hit(int timestamp) {
        int idx = timestamp % MAX;
        if (times[idx] == 0) {
            times[idx] = timestamp;
            hits[idx] = 1;
        } else {
            hits[idx]++;
        }
    }

    public int getHits(int timestamp) {
        int res = 0;
        for (int i = 0; i < MAX; i++) {
            if (timestamp - times[i] < 300)
                res += hits[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Optimised hitCounter = new Optimised();
        hitCounter.hit(1);
        hitCounter.hit(200);
        System.out.println(hitCounter.getHits(250));
    }
}
