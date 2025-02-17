package ag.act.calculate.exception;

public class OperationTypeInvalidException extends RuntimeException {

    public OperationTypeInvalidException() {
        super("Invalid operation");
    }
}
