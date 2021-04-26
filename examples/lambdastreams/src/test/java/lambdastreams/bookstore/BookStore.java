package lambdastreams.bookstore;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookStore {

    List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public int getNumberOfBooks() {
        return books.stream().mapToInt(Book::getPieces).sum();
    }

    public Optional<Book> findNewestBook() {
        return books.stream().max(Comparator.comparing(Book::getYearOfPublish));
    }

    public int getTotalValue() {
        return books.stream().mapToInt(value -> value.pieces * value.price).sum();
    }

    public List<Book> getByYearOfPublish(int publishYear) {
        List<Book> collect = books.stream().filter(book -> book.yearOfPublish == publishYear)
                .collect(Collectors.toList());
        if (collect.isEmpty()){
            return null;
        }
        return collect;
        // return books.stream().collect(Collectors.groupingBy(Book::getYearOfPublish)).get(year);
    }

}
