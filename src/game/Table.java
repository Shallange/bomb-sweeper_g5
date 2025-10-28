package game;

import dangers.Bomb;
import utils.Color;
import java.util.List;

public class Table {
    int rows;
    int cols;
    String[][] table = new String[rows][cols];
    private List<Bomb> bombs;

    public Table(int rows, int cols, List<Bomb> bombs) {
        this.rows = rows;
        this.cols = cols;
        this.bombs = bombs;
        table = new String[rows][cols];
        initTable(rows, cols);
    }

    public void revealBombs(List<Bomb> bombs, String symbol){
        for(Bomb bomb : bombs){
            int r = bomb.getRow();
            int c = bomb.getCol();
            insertSymbol(r,c, symbol);
        }
        showTable();
    }

    public void insertSymbol(int row, int col, String symbol){
        this.table[row][col] = " " + symbol + " ";
    }

    private void initTable(int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                table[i][j] = "    ";
            }
        }
    }

    public void showTable() {
        // print column numbers
        System.out.print("    "); // spacing for the top-left corner
        for (int j = 0; j < cols; j++) {
            System.out.printf(Color.lightBlue + " %2d  " + Color.reset, (j + 1));
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            // print separator line
            System.out.print("    ");
            for (int j = 0; j < cols; j++) {
                System.out.print(Color.gray + "----" + Color.reset);
                if (j < cols - 1) System.out.print(Color.white + "+" + Color.reset);
            }
            System.out.println();

            // print row letter (a, b, c, ...)
            char rowLetter = (char) ('a' + i);
            System.out.print(" " + Color.lightBlue + rowLetter  + Color.gray + " |" + Color.reset);

            // print the table contents
            for (int j = 0; j < cols; j++) {
                System.out.print(table[i][j]);
                System.out.print(Color.gray + "|" + Color.reset);
            }
            System.out.println();
        }
    }
}
