import ag.act.calculate.exception.OperandInvalidNumberFormatException;
import ag.act.calculate.exception.OperandSeperatorException;
import ag.act.calculate.operands.Operand;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class OperandTest {

    @Test
    void operandTest() {
        String value = "1";
        Operand operand = Operand.of(value);
        assertThat(operand.getNum().subtract(new BigDecimal("1"))).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    void operandSeperaorTest() {
        String value = "1,000";

        Throwable exception = assertThrows(OperandSeperatorException.class, () -> {
            Operand.of(value);
        });

        assertThat(exception.getMessage()).isEqualTo("No thousand separators");
    }

    @Test
    void operandInvalidNumberFormatTest() {
        String value = "ttt";

        Throwable exception = assertThrows(OperandInvalidNumberFormatException.class, () -> {
            Operand.of(value);
        });

        assertThat(exception.getMessage()).isEqualTo("Invalid number format");

    }
}
