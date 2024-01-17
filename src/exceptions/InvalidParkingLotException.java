package exceptions;

public class InvalidParkingLotException extends RuntimeException{
    public InvalidParkingLotException(String message) {
        super(message);
    }
}
