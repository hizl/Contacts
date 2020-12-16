package contacts.utils;

import java.util.*;

public class ConsoleUtils {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void printMessageln(String message, Object... args) {
        System.out.printf(message.concat("\n"), args);
    }

    public static void printMessage(String message, Object... args) {
        System.out.printf(message, args);
    }

    public static ConsoleUtils simplePrint(String m) {
        System.out.printf("%s%n", m);
        return null;
    }

    public static String readLine() {
        return SCANNER.nextLine();
    }

    public static int readInt() {
        int readValue = SCANNER.nextInt();
        SCANNER.nextLine();
        return readValue;
    }

}
