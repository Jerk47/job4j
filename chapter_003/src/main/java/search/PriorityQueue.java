package search;

import java.util.*;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.add(task);
        } else if (tasks.get(0).getPriority() > task.getPriority()) {
            tasks.add(0, task);
        } else if (tasks.get(tasks.size() - 1).getPriority() < task.getPriority()) {
            tasks.add(tasks.size(), task);
        } else {
            int i = 0;
            while (tasks.get(i).getPriority() < task.getPriority()) {
                i++;
            }
            tasks.add(i, task);
        }
    }


    public Task take() {
        return this.tasks.poll();
    }

    public static void main(String[] args) {
        PriorityQueue pr = new PriorityQueue();
        pr.put(new Task("low", 5));
        pr.put(new Task("urgent", 1));
        pr.put(new Task("middle", 3));
        pr.put(new Task("lowr", 5));
        System.out.println(pr.tasks.get(1).getPriority());
    }
}