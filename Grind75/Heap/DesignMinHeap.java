package Heap;

/**
 * Heap is essentially:  a complete binary tree
 * follows a particular fashion(minHeap or maxHeap)
 * Complete binary tree: a binary tree in which all level are completely filled expect the last level where
 * nodes are as much as left inclined(the array representation should not have gaps)
 */
public class DesignMinHeap {
    int[] minHeap;
    int heapSize;
    int size;

    public DesignMinHeap(int size) {
        this.size = size;
        minHeap = new int[size]; //we won't be using minHeap[0]
        heapSize = 0;
    }

    public void addElement(int val) {
        heapSize++;
        if (heapSize > size) {
            heapSize--;
            System.out.println("size is full");
            return;
        }
        minHeap[heapSize] = val; // to maintain complete binary tree always added as left child
        int index = heapSize;
        int parent = index / 2;
        // until miHeap condition doesn't satisfy
        while (minHeap[index] < minHeap[parent] && index > 1) {
            int temp = minHeap[index];
            minHeap[index] = minHeap[parent];
            minHeap[parent] = temp;
            index = parent;
            parent = index / 2;
        }

    }

    public int peek() {
        return minHeap[1];
    }

    public int pop() {
        if (heapSize < 1) {
            System.out.println("minHeap is empty");
            return Integer.MAX_VALUE;
        }
        int val = minHeap[1];
        minHeap[1] = minHeap[heapSize];
        heapSize--;
        int index = 1;
        while (index <= heapSize / 2) {
            int left = index * 2;
            int right = (index * 2) + 1;
            if (minHeap[index] > minHeap[left] || minHeap[index] > minHeap[right]) {
                if (minHeap[left] < minHeap[index]) {
                    int temp = minHeap[left];
                    minHeap[left] = minHeap[index];
                    minHeap[index] = temp;
                    index = left;
                } else {
                    int temp = minHeap[right];
                    minHeap[right] = minHeap[index];
                    minHeap[index] = temp;
                    index = right;
                }
            } else
                break;
        }
        return val;
    }

    public static void main(String[] args) {
        DesignMinHeap minHeap = new DesignMinHeap(5);
        minHeap.addElement(7);
        minHeap.addElement(2);
        minHeap.addElement(4);
        minHeap.addElement(1);
        System.out.println(minHeap.peek());
        minHeap.pop();
        System.out.println(minHeap.peek());
    }
}
