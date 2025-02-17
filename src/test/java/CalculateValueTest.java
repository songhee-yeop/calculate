import ag.act.calculate.CalculateValue;
import ag.act.calculate.exception.InvalidInputFormatException;
import ag.act.calculate.operation.OperationType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculateValueTest {

    @Test
    void valueSuccessTest() {
        CalculateValue calculateValue = CalculateValue.of("1 + 2");
        assertThat(calculateValue.getNum1().getNum()).isEqualByComparingTo(new BigDecimal("1"));
        assertThat(calculateValue.getNum2().getNum()).isEqualByComparingTo(new BigDecimal("2"));
        assertThat(calculateValue.getOperationType()).isEqualTo(OperationType.ADDITION);
    }

    @Test
    void valueFailTest() {
        Throwable exception = assertThrows(InvalidInputFormatException.class, () -> {
            CalculateValue.of("1 +");
        });

        assertThat(exception.getMessage()).isEqualTo("Invalid input format");
    }
}
