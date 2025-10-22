package utils;

import java.util.Scanner;

public class InputHandler {
    private Scanner sc;

    public  InputHandler(Scanner scanner) {
        this.sc = sc;
    }

    public String getInput() {
        System.out.println("Viken ruta vill du undersöka?");
        return sc.nextLine().toLowerCase();
    }
    public boolean isValidInput(String input, int maxRow, int maxCol) {
        if (input.length() != 2)
            return false;
        // todo symbol, inom bounds
        return true;
    }

    //todo int till rad
    //Todo int till kolumn







}
