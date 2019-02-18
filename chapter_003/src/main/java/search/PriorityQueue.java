package search;

import java.util.*;

public class PriorityQueue {
    private Queue<Task> queue = new java.util.PriorityQueue<>();

    public void put(Task task) {
        queue.add(task);
    }

    public Task take() {
        return this.queue.poll();
    }
}