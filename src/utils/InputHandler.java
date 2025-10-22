package utils;

import java.util.Scanner;

public class InputHandler {
    public static Scanner sc = new Scanner(System.in);

    public  InputHandler() {
    }

    public String getInput() {
        System.out.println("Viken ruta vill du undersöka? (tex. b5)");
        return sc.nextLine().toLowerCase();
    }
    public boolean isValidInput(String input, int maxRow, int maxCol) {
        if (input.length() != 2)
            return false;
        // todo symbol, inom bounds
        return true;
    }

    //int till rad
    public int rowIndex(String input) {
        return input.charAt(0) - 'a';
    }
    //bokstav till index
    public int colIndex(String input) {
        return Character.getNumericValue(input.charAt(1)) -1;
    }







}
