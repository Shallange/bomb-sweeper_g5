package utils;

/**
 *
 */
public class RatioCalculator {
    private double ratio;

    public RatioCalculator(){}

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
