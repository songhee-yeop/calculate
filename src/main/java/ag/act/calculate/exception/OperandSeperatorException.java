package ag.act.calculate.exception;

public class OperandSeperatorException extends RuntimeException {
    public OperandSeperatorException() {
        super("No thousand separators");
    }
}
