package search;

import java.util.*;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        if ((tasks.size() != 0) && tasks.getFirst().getPriority() > task.getPriority()) {
            tasks.add(0, task);
        } else {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}