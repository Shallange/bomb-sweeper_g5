package game;
import utils.RatioCalculator;

public class Difficulty {

    private int difficulty; // 1 , 2 , 3
    private int rows;
    private int cols;
    private String name; // EASY, MEDIUM and HARD
    private int numberOfBombs;

    RatioCalculator easy = new RatioCalculator(0.15);
    RatioCalculator medium = new RatioCalculator(0.22);
    RatioCalculator hard = new RatioCalculator(0.30);


    public Difficulty(int difficulty){
        this.difficulty = difficulty;
        chooseDifficulty(this.difficulty);
    }

    /**
     * Sets the difficulty of the game based on userinput (1-3)
     * Each difficulty sets
     *  - grid size
     *  - Number of bombs
     *
     * @param difficulty is an int value representing difficulty level: 1 = easy, 2 = medium and 3 = hard
     */
    public void chooseDifficulty(int difficulty){
        switch (difficulty){
            case 1:
                this.setName("EASY");
                this.setCols(5);
                this.setRows(5);
                setNumberOfBombs(easy.calculateNumOfBombs(this.getCols(), this.getRows()));
                break;
            case 2:
                this.setName("MEDIUM");
                this.setCols(7);
                this.setRows(7);
                setNumberOfBombs(medium.calculateNumOfBombs(this.getCols(), this.getRows()));
                break;
            case 3:
                this.setName("HARD");
                this.setCols(9);
                this.setRows(9);
                setNumberOfBombs(hard.calculateNumOfBombs(this.getCols(), this.getRows()));
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public int getRows() {return rows;}
    public void setRows(int rows) {this.rows = rows;}

    public int getCols() {return cols;}
    public void setCols(int cols) {this.cols = cols;}

    public String getName() {return name;}
    private void setName(String name) {this.name = name;}

    public int getNumberOfBombs() {return numberOfBombs;}

    public void setNumberOfBombs(int numberOfBombs) {this.numberOfBombs = numberOfBombs;}
}
