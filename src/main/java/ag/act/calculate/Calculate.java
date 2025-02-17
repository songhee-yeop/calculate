package ag.act.calculate;

import ag.act.calculate.exception.DivideZeroException;
import ag.act.calculate.operands.Operand;
import ag.act.calculate.operation.OperationType;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculate {
    private BigDecimal result;

    private Calculate(BigDecimal result) {
        this.result = result;
    }

    public static Calculate of(CalculateValue calculateValue) {
        BigDecimal result = calculate(calculateValue);
        return new Calculate(result);
    }

    public static Calculate of(Operand num1, Operand num2, OperationType operationType) {
        BigDecimal result = calculate(num1, num2, operationType);
        return new Calculate(result);
    }

    private static BigDecimal calculate(Operand num1, Operand num2, OperationType operationType) {
        return switch (operationType) {
            case ADDITION -> num1.getNum().add(num2.getNum());
            case SUBTRACTION -> num1.getNum().subtract(num2.getNum());
            case MULTIPLICATION -> num1.getNum().multiply(num2.getNum());
            case DIVISION -> {
                if (num2.getNum().compareTo(BigDecimal.ZERO) == 0) {
                    throw new DivideZeroException();
                }

                yield num1.getNum().divide(num2.getNum(), RoundingMode.HALF_UP);
            }
        };
    }

    private static BigDecimal calculate(CalculateValue calculateValue) {
        return calculate(calculateValue.getNum1(), calculateValue.getNum2(), calculateValue.getOperationType());
    }

    public BigDecimal getResult() {
        return result;
    }
}
