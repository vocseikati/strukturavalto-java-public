package exam03retake02;

public class Todo implements Comparable<Todo> {

    private String text;
    private State state;
    private int priority;

    public Todo(String text, int priority) {
        if (priority < 1 || priority > 5){
            throw new IllegalArgumentException("Invalid priority: " + priority);
        }
        this.text = text;
        this.state = State.NON_COMPLETED;
        this.priority = priority;
    }

    public void complete(){
        this.state = State.COMPLETED;
    }



    public String getText() {
        return text;
    }

    public State getState() {
        return state;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Todo o) {
        return this.priority > o.priority ? 1 : -1;
    }
}
