package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionManager {

    private List<Book> library;

    public CollectionManager(List<Book> library) {
        this.library = library;
    }

    public List<Book> createUnmodifiableLibrary(){
        return Collections.unmodifiableList(library);
    }

    public List<Book> reverseLibrary(){
        //List<Book> reverseList = new ArrayList<>(library);
        //        Collections.sort(reverseList);
        //        Collections.reverse(reverseList);
        //        return reverseList;
        Collections.reverse(library);
        return library;
    }

    public Book getFirstBook() {
        return library.stream().sorted().findFirst().orElse(null);
        //return Collections.min(library);
    }

    public Book getLastBook() {
        return library.stream().max(Comparator.naturalOrder()).orElse(null);
//        return Collections.max(library);
    }
}
