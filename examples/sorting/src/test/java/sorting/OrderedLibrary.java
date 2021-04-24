package sorting;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class OrderedLibrary {

    private Set<Book> library;

    public OrderedLibrary(Set<Book> books) {
        this.library = new HashSet<>(books);
    }

    public Book lendFirstBook() {
        if (library.isEmpty()){
            throw new NullPointerException("Libray is empty!");
        }
        return library.stream().sorted().findFirst().orElse(null);
    }
}
