package exam03retake02;

import java.util.*;

public class TodoList {

    private List<Todo> todos = new ArrayList<>();

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public int getNumberOfItemsLeft() {
        int numberOfNonCompletedTodos = (int) todos.stream().filter(todo -> todo.getState().equals(State.NON_COMPLETED)).count();
//        for (Todo todo : todos) {
//            if (todo.getState().equals(State.NON_COMPLETED)){
//                numberOfNonCompletedTodos++;
//            }
//        }
        return numberOfNonCompletedTodos;
    }

    public List<String> getMostImportantTodosText() {
        List<String> importantTodos = new ArrayList<>();
        Queue<Todo> pq = new PriorityQueue<>(todos);
        for (Todo todo : pq) {
                if (todo.getPriority() == Objects.requireNonNull(pq.peek()).getPriority()) {
                    importantTodos.add(todo.getText());
                }

        }
        return importantTodos;
    }

    public void deleteCompleted() {
        todos.removeIf(todo -> todo.getState().equals(State.COMPLETED));
    }
}
