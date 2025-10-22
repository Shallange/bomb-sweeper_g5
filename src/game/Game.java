package game;

import utils.InputHandler;

int rows = 6;
int cols = 6;

InputHandler inputHandler = new InputHandler();

public class Game {
    while (true){
        String input = inputHandler.getInput();

        if (!inputHandler.isValidInput(input, rows, cols));{
            System.out.println("Felaktig inmatning, försök igen (tex. B3");
            continue;
        }
    }
}
