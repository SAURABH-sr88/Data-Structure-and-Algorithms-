package LeetcodeQuestions;

import java.util.*;

class DesignTaskManager3408 {
    private static class Task {
        int userId;
        int taskId;
        int priority;

        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    // Maps taskId -> Task (so we can find current priority & user quickly)
    private Map<Integer, Task> taskMap;
    // TreeSet to maintain sorted order of tasks
    private TreeSet<Task> taskSet;

    public DesignTaskManager3408(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        taskSet = new TreeSet<>(new Comparator<Task>() {
            @Override
            public int compare(Task a, Task b) {
                if (a.priority != b.priority) {
                    return Integer.compare(b.priority, a.priority);
                }
                // if same priority, higher taskId first
                return Integer.compare(b.taskId, a.taskId);
            }
        });

        for (List<Integer> t : tasks) {
            int userId = t.get(0);
            int taskId = t.get(1);
            int priority = t.get(2);
            add(userId, taskId, priority);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        taskSet.add(task);
    }

    public void edit(int taskId, int newPriority) {
        Task old = taskMap.get(taskId);
        if (old == null) return;  // or error, but as per guarantees it exists
        // Remove old from set
        taskSet.remove(old);
        // Create new updated task
        Task updated = new Task(old.userId, taskId, newPriority);
        taskMap.put(taskId, updated);
        taskSet.add(updated);
    }

    public void rmv(int taskId) {
        Task old = taskMap.get(taskId);
        if (old == null) return;
        taskSet.remove(old);
        taskMap.remove(taskId);
    }

    public int execTop() {
        if (taskSet.isEmpty()) return -1;
        Task top = taskSet.first();  // the highest priority / highest taskId among ties
        taskSet.remove(top);
        taskMap.remove(top.taskId);
        return top.userId;
    }
}
