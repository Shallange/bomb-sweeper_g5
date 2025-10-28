package dangers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BombPlacer {
    private Random rand = new Random();

    /**
     * Generates a list of bombs(object Bomb) random on the grid
     *
     * @param rows number of rows in the table grid
     * @param cols number of columns in the table grid
     * @param numberOfBombs total number of bombs to place
     * @return {@code ArrayList} containing all bombs with unique coordinates
     */
    public List<Bomb> placeBombs(int rows, int cols, int numberOfBombs){
        List<Bomb> bombs = new ArrayList<>();

        while(bombs.size() < numberOfBombs) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);

            boolean exists = false;
            for(Bomb b : bombs){
                if(b.getRow() == r && b.getCol() == c){
                    exists = true;
                    break;
                }
            }
            if(!exists){
            bombs.add(new Bomb(r,c));
            }
        }
        return bombs;
    }

    /**
     * Checks if the given coordinates row, col is same as a bomb position
     *
     * @param bombs list of all bombs placed on ht
     * @param row the row coordinate being checked
     * @param col the column coordinate being checked
     * @param hitBomb {@code boolean} flag that becomes true if bomb is found
     * @return {@code true} if the given position contains a bomb, false otherwise
     */
    public boolean isHitBomb(List<Bomb> bombs, int row, int col, boolean hitBomb) {
        for (Bomb b : bombs) {
            if (b.getRow() == row && b.getCol() == col) {
                hitBomb = true;
                break;
            }
        }
        return hitBomb;
    }
}
