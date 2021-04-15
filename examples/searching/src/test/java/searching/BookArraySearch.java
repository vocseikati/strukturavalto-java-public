package searching;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BookArraySearch {

    Book[] bookArray;

    public BookArraySearch(Book[] books) {
        this.bookArray = books;
    }

    public Book findBookByAuthorTitle(String author, String title) {
        if (author == null || author.isEmpty() || title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Author or title must not be empty!");
        }
//        Book key = new Book(author, title);
//        Arrays.sort(bookArray);
//        int index = Arrays.binarySearch(bookArray, key);
//        if (index < 0) {
//            throw new IllegalArgumentException("No book found by " + author + " with title " + title);
//        }
//        return bookArray[index];
        for (Book book : bookArray) {
            if (book.getAuthor().equals(author) && book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new IllegalArgumentException("No book found by " + author + " with title " + title);
    }
}
