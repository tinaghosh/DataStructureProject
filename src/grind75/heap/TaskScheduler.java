package grind75.heap;

import java.util.*;

public class TaskScheduler {

    public int minIntervalsRequired(String[] tasks, int n) {
        int totalInterval = 0;
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String taskName : tasks) {
            frequencyMap.put(taskName, (frequencyMap.getOrDefault(taskName, 0) + 1));
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String s : frequencyMap.keySet()) {
            maxHeap.add(frequencyMap.get(s));
        }

        while (!maxHeap.isEmpty()) {
            int iterationLength = n + 1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            while (iterationLength > 0 && !maxHeap.isEmpty()) {
                int currentFreq = maxHeap.poll();
                if (currentFreq - 1 > 0) {
                    store.add(currentFreq - 1);
                }
                iterationLength--;
                taskCount++;
            }
            store.forEach(e -> {
                maxHeap.add(e);
            });
            totalInterval = maxHeap.isEmpty() ? (totalInterval + taskCount) : (totalInterval + (n + 1));
        }
        return totalInterval;
    }

    public static void main(String[] args) {
        String[] tasks = {"A", "A", "A", "B", "B", "B"};
        int n = 2;

        TaskScheduler obj = new TaskScheduler();
        int result = obj.minIntervalsRequired(tasks, n);
        System.out.print("Minimum number of CPU intervals required to complete all tasks -> " + result);
    }
}
