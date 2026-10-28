
import java.util.*;

// Interface
interface Printable {
    void print();
}

// Abstraction and encapsulation
abstract class LibraryItem implements Printable {
    private int id;
    private String title;

    LibraryItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }

    abstract void display();
}

// Inheritance and polymorphism
class Book extends LibraryItem {
    Book(int id, String title) {
        super(id, title);
    }

    void display() {
        System.out.println(getId() + ": " + getTitle());
    }

    public void print() {
        display();
    }
}

// Generic repository
class Repository<T> {
    private List<T> items = new ArrayList<>();

    void add(T item) { items.add(item); }
    List<T> getAll() { return items; }
}

// Composition: Library owns its repository and queue
class Library {
    private Repository<Book> books = new Repository<>();
    private Queue<String> requests = new LinkedList<>();

    void addBook(Book b) {
        books.add(b);
    }

    void showBooks() {
        for (Book b : books.getAll())
            b.display();
    }

    void requestBook(String title) {
        requests.offer(title);
    }

    void serveRequest() {
        String title = requests.poll();
        if (title == null)
            throw new IllegalStateException("No pending requests");
        System.out.println("Serving request: " + title);
    }
}

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        try {
            lib.addBook(new Book(1, "Java Basics"));
            lib.addBook(new Book(2, "OOP in Java"));

            System.out.println("Library Books:");
            lib.showBooks();

            lib.requestBook("Java Basics");
            lib.serveRequest();
            lib.serveRequest(); // Empty queue error

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Library demo completed.");
        }
    }
}
