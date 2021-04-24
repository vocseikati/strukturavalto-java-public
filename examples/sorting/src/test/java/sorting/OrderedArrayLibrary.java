package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class OrderedArrayLibrary {

    private Book[] bookArray;

    public OrderedArrayLibrary(Book[] books) {
        bookArray = books;
    }

    public Book[] sortingById() {
        Arrays.sort(bookArray);
        return bookArray;
        //Book[] books = new Book[bookArray.length];
        //        System.arraycopy(bookArray, 0, books, 0, bookArray.length);
        //        Arrays.sort(books);
        //        return books;
    }

    public Book[] sortingByTitle() {
        Comparator<Book> comparator = Comparator.comparing(Book::getTitle);
        Arrays.sort(bookArray, comparator);
        return bookArray;
        //Comparator<Book> titleComparator = new Comparator<Book>() {
        //
        //            public int compare(Book bookA, Book bookB) {
        //                return bookA.getTitle().compareTo(bookB.getTitle());
        //            }
        //        };
        //
        //        Book[] books = new Book[bookArray.length];
        //        System.arraycopy(bookArray, 0, books, 0, bookArray.length);
        //        Arrays.sort(books, titleComparator);
        //        return books;
    }
}
