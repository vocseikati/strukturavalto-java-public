package collectionspriorityqueue;

public class Job implements Comparable<Job> {

    private final int priority;
    private final String jobDescription;
    private final boolean urgent;

    public Job(int priority, String jobDescription) {
        this.priority = priority;
        this.jobDescription = jobDescription;
        this.urgent = priority < 5; // minden olyan job esetén true, ahol a prioritás < 5
    }

    public int getPriority() {
        return priority;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public boolean isUrgent() {
        return urgent;
    }

    @Override
    public int compareTo(Job o) {
        return this.priority - o.priority;
    }
}
