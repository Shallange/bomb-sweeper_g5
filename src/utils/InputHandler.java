package utils;

import java.util.Scanner;

public class InputHandler {
    public static Scanner sc = new Scanner(System.in);

    public  InputHandler() {
    }

    public String getInput() {
        System.out.println(Emoji.neutral + Color.yellow + "Viken ruta vill du undersöka? " + Color.gray + "(tex. b5)" + Color.reset);
        return sc.nextLine().trim().toLowerCase();
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
