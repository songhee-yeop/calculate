package ag.act.calculate;

import ag.act.calculate.exception.InvalidInputFormatException;
import ag.act.calculate.operands.Operand;
import ag.act.calculate.operation.OperationType;

public class CalculateValue {
    private static final String SEPERATOR = " ";

    private Operand num1;
    private Operand num2;
    private OperationType operationType;

    private CalculateValue(Operand num1, Operand num2, OperationType operationType) {
        this.num1 = num1;
        this.num2 = num2;
        this.operationType = operationType;
    }

    public static CalculateValue of(String input) {
        String[] parts = input.split(SEPERATOR);
        if (parts.length != 3) {
            throw new InvalidInputFormatException();
        }

        Operand num1 = Operand.of(parts[0]);
        OperationType operationType = OperationType.fromSymbol(parts[1]);
        Operand num2 = Operand.of(parts[2]);

        return new CalculateValue(num1, num2, operationType);
    }

    public Operand getNum1() {
        return num1;
    }

    public Operand getNum2() {
        return num2;
    }

    public OperationType getOperationType() {
        return operationType;
    }
}
