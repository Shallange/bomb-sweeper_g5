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
}
