package search;

public class Task implements Comparable<Task> {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }


    @Override
    public int compareTo(Task o) {
        if (priority != o.priority) {
            return Integer.compare(priority, o.priority);
        } else {
            return 0;
        }
    }
}
