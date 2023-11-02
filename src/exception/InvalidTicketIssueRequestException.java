package exception;

public class InvalidTicketIssueRequestException extends RuntimeException{
    public InvalidTicketIssueRequestException(String message) {
        super(message);
    }
}
