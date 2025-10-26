package utils;

import java.sql.SQLOutput;
import java.util.Scanner;

public class InputHandler {
    public static Scanner sc = new Scanner(System.in);

    public  InputHandler() {
    }

    public String getInput(int maxRows, int maxCols) {
        String input;
        while (true) {
            System.out.println("Viken ruta vill du undersöka? (tex. C5)");
            input = sc.nextLine().trim().toLowerCase();
            if (isValidInput(input, maxRows, maxCols)) {
                return input;
            } else {
                System.out.println("Felaktig inmatning, försök igen (tex. B3");
            }
        }
    }

    public boolean isValidInput(String input, int maxRow, int maxCol) {
        if (input.length() != 2)
            return false;

        char rowChar = input.charAt(0);
        char colChar = input.charAt(1);

        if (rowChar < 'a' || rowChar >= 'a' + maxRow)
            return false;

        int col = Character.getNumericValue(colChar);
        if (col < 1 || col >= 1 + maxCol)
            return false;

        return true;
    }

    //rad till index
    public int rowIndex(String input) {
        return input.charAt(0) - 'a';
    }
    //bokstav till index
    public int colIndex(String input) {
        return Character.getNumericValue(input.charAt(1)) -1;
    }
}
