// 1 задание обьединить два листа
import java.util.*;
/*
class ListMerger {
    public static <T> List<T> unionLists(List<T> list1, List<T> list2) {
        List<T> unionLists = new ArrayList<>();
        int size = Math.max(list1.size(), list2.size());

        for (int i = 0; i < size; i++) {
            if (i < list1.size()) unionLists.add(list1.get(i));
            if (i < list2.size()) unionLists.add(list2.get(i));
        }

        return unionLists;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(-1, -3, 5);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8);

        System.out.println(unionLists(list1, list2));
    }
} */

// 2 задание распечатать ключи и значения
class MapPrinter {
    public static <K, V> void printedM(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Nazima", 90);
        scores.put("Jaina", 85);
        printedM(scores);


    }
}

// 3 задание планировщик для задач
class Task implements Comparable<Task> {
    String taskName;
    int priority;
    int duration;

    public Task(String taskName, int priority, int duration) {
        this.taskName = taskName;
        this.priority = priority;
        this.duration = duration;
    }

    @Override
    public int compareTo(Task other) {
        if (this.priority != other.priority) {
            return Integer.compare(other.priority, this.priority); 
        }
        return Integer.compare(this.duration, other.duration);
    }

    @Override
    public String toString() {
        return "[Priority " + priority + "] " + taskName + " (Duration: " + duration + " mins)";
    }
}

public class TaskScedulerManaging {
    private PriorityQueue<Task> taskQueue;
    private Queue<Task> pendingQueue;

    public TaskScedulerManaging() {
        this.taskQueue = new PriorityQueue<>();
        this.pendingQueue = new LinkedList<>();
    }

    public void addTask(String name, int priority, int duration) {
        Task task = new Task(name, priority, duration);
        taskQueue.add(task);
        System.out.println("Task added: " + task);
    }

    public void processNextTask() {
        if (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("Processing Task: " + task);
        } else if (!pendingQueue.isEmpty()) {
            Task task = pendingQueue.poll();
            System.out.println("Processing Pending Task: " + task);
        } else {
            System.out.println("No tasks to process.");
        }
    }

    public void delayTask(String taskName) {
        Iterator<Task> iterator = taskQueue.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.taskName.equals(taskName)) {
                iterator.remove();
                pendingQueue.add(task);
                System.out.println("Delaying Task: " + taskName);
                return;
            }
        }
        System.out.println("Task not found: " + taskName);
    }

    public void displayTasks() {
            System.out.println("Scheduled Tasks (sorted by priority):");
            PriorityQueue<Task> tempQueue = new PriorityQueue<>(taskQueue);
            while (!tempQueue.isEmpty()) {
                System.out.println(tempQueue.poll());

        }

        System.out.println("\nPending Tasks (FIFO Order):");
        if (pendingQueue.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            for (Task task : pendingQueue) {
                System.out.println(task);
            }
        }
    }

    public static void main(String[] args) {
        TaskScedulerManaging scheduler = new TaskScedulerManaging();

        scheduler.addTask("Code Review", 3, 20);
        scheduler.addTask("System Update", 5, 45);
        scheduler.addTask("Database Backup", 2, 30);
        scheduler.addTask("Deploy New Feature", 5, 50);
        scheduler.addTask("Bug Fixing", 4, 25);

        scheduler.displayTasks();

        scheduler.processNextTask();
        scheduler.delayTask("Code Review");
        scheduler.displayTasks();

        scheduler.delayTask("Database Backup");
        scheduler.displayTasks();

        scheduler.processNextTask();
        scheduler.processNextTask();
        scheduler.processNextTask();
        scheduler.processNextTask();
        scheduler.processNextTask();
    }
}
