package game;
import dangers.Bomb;
import dangers.BombPlacer;
import utils.InputHandler;
import utils.Emoji;

import java.util.List;

public class Game {
    int rows = 6;
    int cols = 6;
    int numBombs = 10;

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
            int row = inputHandler.rowIndex(input);
            int col = inputHandler.colIndex(input);

            boolean hitBomb = bombPlacer.isHitBomb(bombs, row, col, false);

            if (hitBomb) {

                System.out.println("Boom!" + Emoji.bomb + " Game over.");
                break; // exit loop
            } else {
                table.table[row][col] = " " + Emoji.kross + " ";
            }

            if (revealed[row][col]) {
                System.out.println(Emoji.collision + "Rutan är redan undersökt, försök med en annan ");
                continue;
            }

            revealed[row][col] = true;
            table.showTable();

        }

    }

}
