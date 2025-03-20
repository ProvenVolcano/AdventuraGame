package Colors;

public class Text {

    public static String color(String text, char color) {
        switch (color) {
            case 'r':
                return "\u001B[38;2;202;95;71m" + text + "\u001B[0m";
            case 'b':
                return "\u001B[38;2;80;121;221m" + text + "\u001B[0m";
            case 'o':
                return "\u001B[38;2;230;148;30m" + text + "\u001B[0m";
            case 'g':
                return "\u001B[38;2;63;222;137m" + text + "\u001B[0m";
            case 'y':
                return "\u001B[38;2;220;220;35m" + text + "\u001B[0m";
            case 'p':
                return "\u001B[38;2;180;121;226m" + text + "\u001B[0m";
            case 'd':
                return "\u001B[38;2;255;0;0m" + text + "\u001B[0m";
            default:
                return text;
        }
    }
}
