import java.util.List;

public class Library implements Aggregate {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public Iterator createIterator() {
        return new BookIterator(books);
    }
}
