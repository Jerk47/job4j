package search;

import java.util.*;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        if (tasks.size() == 0 || tasks.get(0).getPriority() > task.getPriority()) {
            tasks.add(index, task);
        } else {
            for (int i = 0; tasks.get(i).getPriority() < task.getPriority(); i++) {
                index++;
            }
            tasks.add(index, task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}