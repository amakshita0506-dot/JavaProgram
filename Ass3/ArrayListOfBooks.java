import java.util.ArrayList;

public class ArrayListOfBooks {

    public static void main(String[] args) {

        // Create ArrayList of Book objects
        ArrayList<Book> bookList = new ArrayList<>();

        // Book 1
        try {
            Book b1 = new Book("The Alchemist", "Paulo Coelho", "Fiction", 399);
            bookList.add(b1);
        } catch (InvalidPriceException | InvalidGenreException e) {
            System.out.println(e.getMessage());
        }

        // Book 2
        try {
            Book b2 = new Book("Sherlock Holmes", "Arthur Conan Doyle", "Mystery", 450);
            bookList.add(b2);
        } catch (InvalidPriceException | InvalidGenreException e) {
            System.out.println(e.getMessage());
        }

        // Book 3 (Negative price example)
        try {
            Book b3 = new Book("Clean Code", "Robert Martin", "Non-Fiction", -800);
            bookList.add(b3);
        } catch (InvalidPriceException | InvalidGenreException e) {
            System.out.println(e.getMessage());
        }

        // Book 4
        try {
            Book b4 = new Book("Harry Potter", "J.K. Rowling", "Fantasy", 550);
            bookList.add(b4);
        } catch (InvalidPriceException | InvalidGenreException e) {
            System.out.println(e.getMessage());
        }

        // Display all books
        System.out.println("\nAll Books:");
        for (Book b : bookList) {
            System.out.println("Name: " + b.getName()
                    + ", Author: " + b.getAuthorName()
                    + ", Genre: " + b.getGenre()
                    + ", Price: " + b.getPrice());
        }

        // Calculate average price
        double total = 0;
        for (Book b : bookList) {
            total += b.getPrice();
        }

        if (!bookList.isEmpty()) {
            double average = total / bookList.size();
            System.out.println("\nAverage Price: " + average);
        }

        // Print only Fiction books using forEach()
        System.out.println("\nFiction Books:");
        bookList.forEach(book -> {
            if (book.getGenre().equalsIgnoreCase("Fiction")) {
                System.out.println("Name: " + book.getName()
                        + ", Author: " + book.getAuthorName()
                        + ", Price: " + book.getPrice());
            }
        });
    }
}