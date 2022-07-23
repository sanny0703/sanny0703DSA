package Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class BoundedBlockingQueue {
    private int capacity;
    private Semaphore semaphoreEnqueue;
    private Semaphore semaphoreDequeue;
    private Queue<Integer>queue;
    public BoundedBlockingQueue(int capacity){
        this.capacity = capacity;
        semaphoreEnqueue = new Semaphore(capacity);
        semaphoreDequeue = new Semaphore(0);
        queue = new ArrayDeque<>();
    }
    public void enqueue(int val) throws InterruptedException{
        semaphoreEnqueue.acquire();
        queue.offer(val);
        semaphoreDequeue.release();
    }
    public int dequeue() throws  InterruptedException{
        semaphoreDequeue.acquire();
        int x = queue.poll();
        semaphoreEnqueue.release();
        return x;
    }
}
