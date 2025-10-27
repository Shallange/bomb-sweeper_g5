package game;
import dangers.Bomb;
import dangers.BombPlacer;
import utils.InputHandler;

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
                System.out.println("Boom!\uD83D\uDCA3 Game over.");
                break; // exit loop
            } else {
                table.table[row][col] = " X  ";
            }
     
            if (revealed[row][col]) {
                System.out.println("Rutan är redan undersökt, försök med en annan ");
                continue;
            }
          
            revealed[row][col] = true;
            table.showTable();
            if (checkWin()) break;

        }

    }

    private int countRevealed() {
        int revealedCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (revealed[i][j]) {
                    revealedCount++;
                }
            }
        }
        return revealedCount;
    }

    private boolean checkWin() {
        if (countRevealed() + numBombs == rows * cols) {
            System.out.println(Emoji.partyPopper + Color.green + "Grattis! Du har klarat spelet!!!" + Color.reset + Emoji.happy);
            return true;
        }
        return false;
    }

}
