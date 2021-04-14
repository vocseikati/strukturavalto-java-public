package lambdastreams.bookstore;

import java.util.ArrayList;
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
        return books.stream().map(book -> book.pieces).reduce(0, Integer::sum);
    }

    public Optional<Book> findNewestBook() {
        Optional<Book> max = books.stream().max(Comparator.comparingInt(book -> book.yearOfPublish));
        return max;
    }

    public int getTotalValue() {
        return books.stream().mapToInt(book -> book.price * book.pieces).sum();
    }

    public List<Book> getByYearOfPublish(int year) {
        if (books.isEmpty()){
            return null;
        }
        List<Book> collect = books.stream()
                .filter(book -> book.yearOfPublish == year)
                .collect(Collectors.toList());
        if (collect.isEmpty()){
            return null;
        }
        return collect;

        //return books.stream().collect(Collectors.groupingBy(Book::getYearOfPublish)).get(year);
    }
}
