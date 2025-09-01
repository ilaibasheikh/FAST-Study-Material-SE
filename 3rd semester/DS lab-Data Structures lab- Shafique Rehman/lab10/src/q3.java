import java.util.*;

class Task {
    int priority;
    String name;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}
public class q3 {



    private static List<Task> RandomTasks(int n) {
        List<Task> tasks = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= n; i++) {
            tasks.add(new Task("Task" + i, random.nextInt(10) + 1));
        }

        return tasks;
    }


    public static void main(String[] args) {
        List<Task> tasks = RandomTasks(10);


        System.out.println("Original");
        display(tasks);


        PriorityQueue<Task> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(task -> -task.priority));
        priorityQueue.addAll(tasks);


        System.out.println("\n  Order ");
        while (!priorityQueue.isEmpty()) {
            Task currentTask = priorityQueue.poll();
            System.out.println("Processing Task: " + currentTask.name + " (Priority: " + currentTask.priority + ")");
        }
    }
    public static void display(List<Task> tasks) {
        for (Task task : tasks) {
            System.out.println("Task: " + task.name + " (Priority: " + task.priority + ")");
        }
    }
}



