package game;
import utils.InputHandler;

public class Game {
    int rows = 6;
    int cols = 6;

    boolean [][] revealed = new boolean[rows][cols];

    InputHandler inputHandler = new InputHandler();

    public void playGame() {
        while (true) {
            String input = inputHandler.getInput();

            if (!inputHandler.isValidInput(input, rows, cols)) {
                System.out.println("Felaktig inmatning, försök igen (tex. B3");
                continue;
            }
            int rows = inputHandler.rowIndex(input);
            int cols = inputHandler.colIndex(input);

            if (revealed[rows][cols]) {
                System.out.println("Rutan är redan undersökt, försök med en annan ");
                continue;
            }

            revealed[rows][cols] = true;

            

        }

    }

}
