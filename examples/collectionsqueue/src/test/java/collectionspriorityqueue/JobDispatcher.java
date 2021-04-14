package collectionspriorityqueue;

import collectionsdeque.NoJobException;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {


    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.poll();
    }

    public Queue<Job> addJob(Job... jobs) {
        return new PriorityQueue<>(Arrays.asList(jobs));
    }
}
