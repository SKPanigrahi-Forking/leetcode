package queue;

import java.util.*;

/**
 * 
 * Given a stream of integers and a window size, calculate the moving average of
 * all integers in the sliding window.
 * 
 * Example:
 * 
 * MovingAverage m = new MovingAverage(3);
 * 
 * m.next(1) = 1
 * 
 * m.next(10) = (1 + 10) / 2
 * 
 * m.next(3) = (1 + 10 + 3) / 3
 * 
 * m.next(5) = (10 + 3 + 5) / 3
 */
class MovingAverage {

    /** Initialize your data structure here. */
    private double sum = 0.0;
    private int count = 0;
    private int window_size = 0;
    private Queue<Integer> queue;

    public MovingAverage(int size) {
        queue = new LinkedList<>();
        window_size = size;
    }

    public double next(int val) {
        queue.offer(val);
        if (queue.size() <= window_size) {
            sum += val;
            count++;
            return sum / count;
        } else {
            sum -= queue.poll();
            sum += val;
            return sum / window_size;
        }
    }
}
