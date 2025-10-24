package dangers;

/**
 * Represents a bomb on the grid with its coordinates
 */
public class Bomb {
    private int row;
    private int col;

    /**
     * Creates a New Bomb at given row and col
     *
     * @param row rows index on the gamegrid
     * @param col col index on the gamegrid
     */
    public Bomb(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getCol() {return col;}
    public int getRow() {return row;}
}
