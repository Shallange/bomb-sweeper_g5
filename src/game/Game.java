package game;
import utils.InputHandler;

public class Game {
    int rows = 6;
    int cols = 6;

    boolean gameOver = false;
    boolean [][] revealed = new boolean[rows][cols];

    InputHandler inputHandler = new InputHandler();

    public void playGame() {
        while (true) {
            String input = inputHandler.getInput();

            if (!inputHandler.isValidInput(input, rows, cols)) {
                System.out.println("Felaktig inmatning, försök igen (tex. B3");
                continue;
            }
            int row = inputHandler.rowIndex(input);
            int col = inputHandler.colIndex(input);

            

            revealed[row][col] = true;
        }
    }

}
