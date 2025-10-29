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
                table.table[row][col] = " " + Emoji.kross + " ";
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
        System.out.println(Color.cyan + "Tack för att du spelade!" +  Color.reset + Emoji.happy);
    }

    private boolean askPlayAgain() {
        System.out.println(Color.yellow + "Vill du spela igen? (j/n)" + Color.reset);
        String answer = InputHandler.sc.nextLine().trim().toLowerCase();
        return answer.equals("j");
    }
}
