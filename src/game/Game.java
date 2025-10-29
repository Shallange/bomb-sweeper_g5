package game;
import dangers.Bomb;
import dangers.BombPlacer;
import utils.InputHandler;
import utils.RatioCalculator;
import utils.Emoji;
import utils.Color;

import java.util.List;

public class Game {
    int rows = 6;
    int cols = 6;
    int numBombs;
    boolean [][] revealed = new boolean[rows][cols];

    InputHandler inputHandler = new InputHandler();
    BombPlacer bombPlacer = new BombPlacer();
    RatioCalculator calc = new RatioCalculator();

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


    public void playGame() {
        boolean playAgain = true;

        while (playAgain) {
            revealed = new boolean[rows][cols];
            calc.setRatio(0.15);
            numBombs = calc.calculateNumOfBombs(rows, cols);
            List<Bomb> bombs = bombPlacer.placeBombs(rows, cols, numBombs);
            Table table = new Table(rows, cols, bombs);
            table.showTable();

        while (true) {
            String input = inputHandler.getInput(rows,cols);

            int row = inputHandler.rowIndex(input);
            int col = inputHandler.colIndex(input);

            boolean hitBomb = bombPlacer.isHitBomb(bombs, row, col, false);

            if (hitBomb) {
                table.revealBombs(bombs, Emoji.bomb);
                System.out.println(Color.orange + "Boom!" + Color.reset + Emoji.bomb + Color.lightBlue + " Game over!" + Color.reset + Emoji.crying);
                break; // exit loop
            } else {
                int adjacent = countAdjacentBombs(bombs, row, col);

                if (adjacent > 0) {
                    table.insertSymbol(row, col, String.valueOf(adjacent));
                } else {
                    table.insertSymbol(row, col, "·"); // or " " or Emoji.grass
                }
            }

            if (revealed[row][col]) {
                System.out.println(Emoji.collision + Color.red + "Rutan är redan undersökt, försök med en annan: " + Color.reset);
                continue;
            }

                revealed[row][col] = true;
                table.showTable();
                if (checkWin()) break;

            }
             playAgain = askPlayAgain();
        }
        System.out.println("Tack för att du spelade!");
    }

    private boolean askPlayAgain() {
        System.out.println("Vill du spela igen? (y/n)");
        String answer = InputHandler.sc.nextLine().trim().toLowerCase();
        return answer.equals("y");
    }

    private int countAdjacentBombs(List<Bomb> bombs, int row, int col) {
        int count = 0;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {

                if (dr == 0 && dc == 0) continue; // skip the cell itself

                int newRow = row + dr;
                int newCol = col + dc;

                // check inside grid
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    if (bombPlacer.isHitBomb(bombs, newRow, newCol, false)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
