package ag.act.calculate.exception;

public class DivideZeroException extends RuntimeException {
    public DivideZeroException() {
        super("Division by zero is not allowed.");
    }
}
