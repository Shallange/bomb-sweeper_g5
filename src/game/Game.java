package game;
import dangers.Bomb;
import dangers.BombPlacer;
import utils.InputHandler;

import java.util.List;

public class Game {
    int rows = 6;
    int cols = 6;
    int numBombs = 3;//

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
            int row = inputHandler.rowIndex(input);
            int col = inputHandler.colIndex(input);
            boolean hitBomb = false;
            for (Bomb b : bombs) {
                if (b.getRow() == row && b.getCol() == col) {
                    hitBomb = true;
                    break;
                }
            }

            if (hitBomb) {
                System.out.println("Boom!💣Game over.");
                break; // exit loop
            } else {
                table.table[row][col] = "X"; // mark cell as revealed
            }

            table.showTable();

        }
    }

}
