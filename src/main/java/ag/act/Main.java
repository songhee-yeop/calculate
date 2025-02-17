package ag.act;

import ag.act.calculate.Calculate;
import ag.act.calculate.CalculateValue;
import ag.act.util.InputUtil;

public class Main {
    public static void main(String[] args) {
        String input = InputUtil.input();
        Calculate calculate = Calculate.of(CalculateValue.of(input));
        System.out.println(calculate.getResult());
    }
}