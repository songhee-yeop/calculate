package ag.act.util;

import java.util.Scanner;

public class InputUtil {

    private InputUtil() {}

    public static String input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an expression (e.g., 12.5 + 3.2):");
        String input = scanner.nextLine();

        scanner.close();
        return input;
    }
}
