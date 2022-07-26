package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 *  For example,
 *
 *  MovingAverage m = new MovingAverage(3);
 *  m.next(1) = 1
 *  m.next(10) = (1 + 10) / 2
 *  m.next(3) = (1 + 10 + 3) / 3
 *  m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverageFromDataStream {
    private Queue<Integer>queue;
    private int size;
    private int sum;
    public MovingAverageFromDataStream(int size){
        this.size = size;
        queue = new ArrayDeque<>();
        sum =0;
    }
    public double next(int val){
        if(queue.size()<size){
            sum += val;
            queue.offer(val);
            return (double) sum/queue.size();
        }
        sum+= val-queue.poll();
        queue.offer(val);
        return (double) sum/size;
    }

    public static void main(String[] args) {
        MovingAverageFromDataStream movingAverageFromDataStream = new MovingAverageFromDataStream(3);
        System.out.println(movingAverageFromDataStream.next(1));
        System.out.println(movingAverageFromDataStream.next(10));
        System.out.println(movingAverageFromDataStream.next(3));
        System.out.println(movingAverageFromDataStream.next(5));
    }
}
