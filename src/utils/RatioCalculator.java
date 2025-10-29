package utils;
/**
 * Utility class used to calculate the number of bombs
 * based on a given ratio and grid size
 *
 */
public class RatioCalculator {
    private double ratio;

    /**
     * Creates a new RatioCalculator with a given ratio.
     *
     * @param ratio percentage (e.g. 0.15 = 15%) used to scale the number of bombs
     */
    public RatioCalculator(double ratio){
        this.ratio = ratio;
    }

    /**
     * Calculates total number of bombs based on ratio and grid size
     *
     * @param rows number of rows in the grid
     * @param cols number of cols in the grid
     * @return number of bombs rounded to nearest int(with given ratio ex. 0.15)
     */
    public int calculateNumOfBombs(int rows, int cols){
        return (int) Math.round(rows * cols * ratio);
    }

    public double getRatio() {return ratio;}
    public void setRatio(double ratio) {this.ratio = ratio;}
}
