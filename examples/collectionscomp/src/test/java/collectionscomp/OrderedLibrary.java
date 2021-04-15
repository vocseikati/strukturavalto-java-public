package collectionscomp;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class OrderedLibrary {

    List<Book> libraryBooks = new LinkedList<>();

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public List<Book> orderedByTitle() {
        List<Book> orderedList = new ArrayList<>(libraryBooks);
        Collections.sort(orderedList);
        return orderedList;
    }


    public List<Book> orderedByAuthor() {
        Collections.sort(libraryBooks, new AuthorComparator());
        return libraryBooks;
    }


    public List<String> orderedByTitleLocale(Locale locale) {
        Collator collator = Collator.getInstance(locale);
        libraryBooks.sort((o1, o2) -> collator.compare(o1.getTitle(), o2.getTitle()));

        return libraryBooks.stream().map(Book::getTitle).collect(Collectors.toList());
    }
}
