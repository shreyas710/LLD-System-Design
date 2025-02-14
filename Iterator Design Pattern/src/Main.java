import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> bookList = Arrays.asList(
                new Book(100, "Science"),
                new Book(200, "Maths"),
                new Book(300, "GK"),
                new Book(400, "SST")
        );
        Library library = new Library(bookList);
        Iterator libraryIterator = library.createIterator();

        while (libraryIterator.hasNext()) {
            Book book = (Book) libraryIterator.next();
            System.out.println(book.getTitle());
        }
    }
}