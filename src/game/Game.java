package game;
import dangers.Bomb;
import dangers.BombPlacer;
import utils.InputHandler;
import utils.Emoji;
import utils.Color;

import java.util.List;

public class Game {

    int numBombs;
    InputHandler inputHandler = new InputHandler();
    BombPlacer bombPlacer = new BombPlacer();

    public void playGame() {
        boolean playAgain = true;

        while (playAgain) {
            Difficulty diff = new Difficulty(3);//userinput
            boolean [][] revealed = new boolean[diff.getRows()][diff.getCols()];
            numBombs = diff.getNumberOfBombs();
            List<Bomb> bombs = bombPlacer.placeBombs(diff.getRows(), diff.getCols(), numBombs);
            Table table = new Table(diff.getRows(), diff.getCols(), bombs);
            table.showTable();
            int countNumber = countRevealed(diff.getRows(), diff.getCols(),revealed);
            int totalNumberOfCells = diff.getCols() * diff.getRows();

        while (true) {
            System.out.println("Nuvarande svårighetsgrad:" + diff.getName());
            String input = inputHandler.getInput(diff.getRows(), diff.getCols());
            int row = inputHandler.rowIndex(input);
            int col = inputHandler.colIndex(input);

            boolean hitBomb = bombPlacer.isHitBomb(bombs, row, col, false);

            if (hitBomb) {
                table.revealBombs(bombs, Emoji.bomb);
                System.out.println(Color.orange + "Boom!" + Color.reset + Emoji.bomb + Color.lightBlue + " Game over!" + Color.reset + Emoji.crying);
                break; // exit loop
            } else {
                int adjacent = countAdjacentBombs(bombs,row, col, diff.getRows(), diff.getCols());

                if (adjacent > 0) {
                    String adjacentWithSpace = adjacent + " ";
                    table.insertSymbol(row, col, adjacentWithSpace);
                } else {
                    table.insertSymbol(row, col, Emoji.kross);
                }
            }

            if (revealed[row][col]) {
                System.out.println(Emoji.collision + Color.red + "Rutan är redan undersökt, försök med en annan: " + Color.reset);
                continue;
            }

                revealed[row][col] = true;
                table.showTable();
                if (checkWin(countNumber, totalNumberOfCells)) break;
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

    private int countAdjacentBombs(List<Bomb> bombs, int row, int col, int totalRows, int totalCols) {
        int count = 0;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {

                if (dr == 0 && dc == 0) continue; // skip the cell itself

                int newRow = row + dr;
                int newCol = col + dc;

                // check inside grid
                if (newRow >= 0 && newRow < totalRows && newCol >= 0 && newCol < totalCols) {
                    if (bombPlacer.isHitBomb(bombs, newRow, newCol, false)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    private int countRevealed(int row, int col, boolean [][] revealed) {
        int revealedCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (revealed[i][j]) {
                    revealedCount++;
                }
            }
        }
        return revealedCount;
    }


    private boolean checkWin(int countNumber,int totalNumOfCells) {
        if (countNumber == totalNumOfCells) {
            System.out.println(Emoji.partyPopper + Color.green + "Grattis! Du har klarat spelet!!!" + Color.reset + Emoji.happy);
            return true;
        }
        return false;
    }
}
