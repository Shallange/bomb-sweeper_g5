package game;
import dangers.Bomb;
import dangers.BombPlacer;
import utils.InputHandler;

import java.util.List;

public class Game {
    int rows = 6;
    int cols = 6;
    int numBombs = 3;//

    boolean [][] revealed = new boolean[rows][cols];

    InputHandler inputHandler = new InputHandler();
    BombPlacer bombPlacer = new BombPlacer();

    public void playGame() {
        List<Bomb> bombs = bombPlacer.placeBombs(rows,cols,numBombs);
        Table table = new Table(rows,cols,bombs);
        table.showTable();

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
