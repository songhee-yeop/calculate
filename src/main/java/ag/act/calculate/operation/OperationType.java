package ag.act.calculate.operation;

import ag.act.calculate.exception.OperationTypeInvalidException;

import java.util.Arrays;

public enum OperationType {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private String symbol;

    OperationType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static OperationType fromSymbol(String symbol) {
        OperationType result = Arrays.stream(values())
                .filter(operationType -> operationType.symbol.equals(symbol))
                .findFirst()
                .orElse(null);

        if (result != null) {
            return result;
        }

        throw new OperationTypeInvalidException();
    }
}
