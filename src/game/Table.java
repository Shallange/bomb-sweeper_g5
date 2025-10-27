package game;

import dangers.Bomb;
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

    private void initTable(int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                table[i][j] = "    ";
            }
        }
    }

    public void showTable() {
        // print column letters
        System.out.print("   ");
        for (int j = 0; j < cols; j++) {
            char columnLetter = (char) ('a' + j);
            System.out.print("  " + columnLetter + "  ");
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            // separator line
            System.out.print("   ");
            for (int j = 0; j < cols; j++) {
                System.out.print("----");
                if (j < cols - 1) System.out.print("+");
            }
            System.out.println();

            // row number
            System.out.printf("%2d |", (i + 1));

            // row content
            for (int j = 0; j < cols; j++) {
                System.out.print(table[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public List<Bomb> getBombs() {return bombs;}
}
