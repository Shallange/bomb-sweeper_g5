package game;
import utils.RatioCalculator;

public class Difficulty {

    private int difficulty; // 1 , 2 , 3
    private int rows;
    private int cols;
    private String name; // EASY, MEDIUM and HARD

    public Difficulty(int difficulty, String name){
        this.difficulty = difficulty;
        this.name = name;
    }

    public int getDifficulty() {return difficulty;}
    public void setDifficulty(int difficulty) {this.difficulty = difficulty;}

    public int getRows() {return rows;}
    public void setRows(int rows) {this.rows = rows;}

    public int getCols() {return cols;}
    public void setCols(int cols) {this.cols = cols;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
