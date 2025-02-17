import ag.act.calculate.exception.DivideZeroException;
import ag.act.calculate.exception.OperationTypeInvalidException;
import ag.act.calculate.operands.Operand;
import ag.act.calculate.Calculate;
import ag.act.calculate.operation.OperationType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperationTest {

    @Test
    void operationTypeTest() {
        assertThat(OperationType.fromSymbol("+")).isEqualTo(OperationType.ADDITION);
        assertThat(OperationType.fromSymbol("-")).isEqualTo(OperationType.SUBTRACTION);
        assertThat(OperationType.fromSymbol("*")).isEqualTo(OperationType.MULTIPLICATION);
        assertThat(OperationType.fromSymbol("/")).isEqualTo(OperationType.DIVISION);

        Throwable exception = assertThrows(OperationTypeInvalidException.class, () -> {
            OperationType.fromSymbol("t");
        });

        assertThat(exception.getMessage()).isEqualTo("Invalid operation");
    }

    @Test
    void calculateTest() {

        Calculate add = Calculate.of(Operand.of("1"), Operand.of("2"), OperationType.ADDITION);
        assertThat(add.getResult()).isEqualByComparingTo(new BigDecimal("3"));

        Calculate sub = Calculate.of(Operand.of("1"), Operand.of("2"), OperationType.SUBTRACTION);
        assertThat(sub.getResult()).isEqualByComparingTo(new BigDecimal("-1"));

        Calculate mul = Calculate.of(Operand.of("3"), Operand.of("2"), OperationType.MULTIPLICATION);
        assertThat(mul.getResult()).isEqualByComparingTo(new BigDecimal("6"));

        Calculate div = Calculate.of(Operand.of("14"), Operand.of("2"), OperationType.DIVISION);
        assertThat(div.getResult()).isEqualByComparingTo(new BigDecimal("7"));

        Throwable exception = assertThrows(DivideZeroException.class, () -> {
            Calculate.of(Operand.of("14"), Operand.of("0"), OperationType.DIVISION);
        });

        assertThat(exception.getMessage()).isEqualTo("Division by zero is not allowed.");
    }
}
