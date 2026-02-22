// User-defined exception for invalid price
public class InvalidPriceException extends Exception {

    public InvalidPriceException(String message) {
        super(message);
    }
}