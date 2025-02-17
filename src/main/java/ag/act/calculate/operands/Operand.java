package ag.act.calculate.operands;

import ag.act.calculate.exception.OperandInvalidNumberFormatException;
import ag.act.calculate.exception.OperandSeperatorException;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class Operand {
    private static final String PATTERN = "^[0-9]+(?:\\.[0-9]*)?$";

    BigDecimal num;

    private Operand(BigDecimal num) {
        this.num = num;
    }

    public static Operand of(String input) {
        validationCheck(input);
        return new Operand(new BigDecimal(input));
    }

    private static void validationCheck(String input) {
        if (input.contains(",")) {
            throw new OperandSeperatorException();
        }

        Pattern pattern = Pattern.compile(PATTERN);
        if (!pattern.matcher(input).matches()) {
            throw new OperandInvalidNumberFormatException();
        }
    }

    public BigDecimal getNum() {
        return num;
    }
}
