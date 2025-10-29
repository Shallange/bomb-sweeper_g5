package utils;

public class Color {

    private Color() {
    }

    public static final String reset    = "\u001B[0m";
    // write reset after every color
    // ex. System.out.println(Color.blue + "Hello World" + Color.reset)

    public static final String purple   = "\u001B[35m";
    public static final String yellow   = "\u001B[33m";
    public static final String cyan     = "\u001B[36m";
    public static final String gray     = "\u001B[90m";
    public static final String red      = "\u001B[31m";
    public static final String green    = "\u001B[32m";
    public static final String pink     = "\u001B[95m";
    public static final String orange   = "\u001B[38;5;208m";
    public static final String blue     = "\u001B[34m";
    public static final String black    = "\u001B[30m";
    public static final String white    = "\u001B[97m";
    public static final String lightBlue = "\u001B[94m";
}
