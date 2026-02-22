// User-defined exception for invalid genre
public class InvalidGenreException extends Exception {

    public InvalidGenreException(String message) {
        super(message);
    }
}