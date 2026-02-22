import java.time.LocalDate;

public class Book {

    private String name;
    private String authorName;
    private double price;
    private String publisherName;
    private String genre;
    private String ISBN;
    private LocalDate dateOfPublishing;

    // Default Constructor
    public Book() {
        name = "unknown";
        authorName = "unknown";
        price = 0.0;
        publisherName = "unspecified";
        genre = "uncategorised";
        ISBN = "00000000";
        dateOfPublishing = LocalDate.parse("2020-01-01");
    }

    // Constructor with Genre + Price validation
    public Book(String n, String a, String g, double p)
            throws InvalidPriceException, InvalidGenreException {

        name = n;
        authorName = a;

        if (g == null ||
           !(g.equalsIgnoreCase("Fiction") ||
             g.equalsIgnoreCase("Non-Fiction") ||
             g.equalsIgnoreCase("Mystery") ||
             g.equalsIgnoreCase("Fantasy"))) {

            throw new InvalidGenreException("Invalid genre!");
        }

        genre = g;

        if (p < 0) {
            throw new InvalidPriceException("Price cannot be negative.");
        }

        price = p;

        publisherName = "unspecified";
        ISBN = "00000000";
        dateOfPublishing = LocalDate.now();
    }

    // Constructor with ISBN + Price validation
    public Book(String n, String a, double p, String isbn)
            throws InvalidPriceException {

        name = n;
        authorName = a;

        if (p < 0) {
            throw new InvalidPriceException("Price cannot be negative.");
        }

        price = p;
        ISBN = isbn;

        genre = "uncategorised";
        publisherName = "unspecified";
        dateOfPublishing = LocalDate.now();
    }

    // Copy Constructor
    public Book(Book b) {
        name = b.name;
        authorName = b.authorName;
        price = b.price;
        publisherName = b.publisherName;
        genre = b.genre;
        ISBN = b.ISBN;
        dateOfPublishing = b.dateOfPublishing;
    }

    // Getter Methods
    public String getName() { return name; }
    public String getAuthorName() { return authorName; }
    public double getPrice() { return price; }
    public String getGenre() { return genre; }
}