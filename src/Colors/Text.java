package Colors;

/**
 * Class for coloring a text
 */
public class Text {

    /**
     * Returns a given text in a given color
     * @param text - the original text
     * @param color - char of the color
     * @return - the colored text
     */
    public static String color(String text, char color) {
        return switch (color) {
            case 'r' -> "\u001B[38;2;202;95;71m" + text + "\u001B[0m";
            case 'b' -> "\u001B[38;2;80;121;221m" + text + "\u001B[0m";
            case 'o' -> "\u001B[38;2;230;148;30m" + text + "\u001B[0m";
            case 'g' -> "\u001B[38;2;63;222;137m" + text + "\u001B[0m";
            case 'y' -> "\u001B[38;2;220;220;35m" + text + "\u001B[0m";
            case 'p' -> "\u001B[38;2;180;121;226m" + text + "\u001B[0m";
            case 'd' -> "\u001B[38;2;255;0;0m" + text + "\u001B[0m";
            case 'c' -> "\u001B[38;2;255;0;180m" + text + "\u001B[0m";
            default -> text;
        };
    }
}
