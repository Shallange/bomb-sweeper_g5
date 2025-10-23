package game;

public class Table {
    int rows;
    int cols;
    String[][] table = new String[rows][cols];


    public Table(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        table = new String[rows][cols];

    }

    public void showTable() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(""+table[i][j]+ "");
                if (j < table[i].length -1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < table.length -1){
                for (int j = 0; j< table[i].length; j ++){
                    System.out.print("----");
                    if (j< table[i].length -1){
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
    }

}
