package lambdastreams.bookstore;

public class Book {
    protected String title;
    protected Integer yearOfPublish;
    protected Integer price;
    protected Integer pieces;

    public Book(String title, Integer yearOfPublish, Integer price, Integer pieces) {
        this.title = title;
        this.yearOfPublish = yearOfPublish;
        this.price = price;
        this.pieces = pieces;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYearOfPublish() {
        return yearOfPublish;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getPieces() {
        return pieces;
    }
}
