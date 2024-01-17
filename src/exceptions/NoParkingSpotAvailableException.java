package exceptions;

public class NoParkingSpotAvailableException extends RuntimeException{
    public NoParkingSpotAvailableException(String message) {
        super(message);
    }
}
