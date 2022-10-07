package utils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Map.entry;

public class ColorPrinter {
    public static final Map<String, String> Colors = Map.<String, String>ofEntries(
            entry("RESET", "\033[0m"),
            entry("BLACK", "\033[0;30m"),
            entry("RED", "\033[0;31m"),
            entry("GREEN", "\033[0;32m"),
            entry("YELLOW", "\033[0;33m"),
            entry("BLUE", "\033[0;34m"),
            entry("PURPLE", "\033[0;35m"),
            entry("CYAN", "\033[0;36m"),
            entry("WHITE", "\033[0;37m"),
            entry("BLACK_BOLD", "\033[1;30m"),
            entry("RED_BOLD", "\033[1;31m"),
            entry("GREEN_BOLD", "\033[1;32m"),
            entry("YELLOW_BOLD", "\033[1;33m"),
            entry("BLUE_BOLD", "\033[1;34m"),
            entry("PURPLE_BOLD", "\033[1;35m"),
            entry("CYAN_BOLD", "\033[1;36m"),
            entry("WHITE_BOLD", "\033[1;37m"),
            entry("BLACK_UNDERLINED", "\033[4;30m"),
            entry("RED_UNDERLINED", "\033[4;31m"),
            entry("GREEN_UNDERLINED", "\033[4;32m"),
            entry("YELLOW_UNDERLINED", "\033[4;33m"),
            entry("BLUE_UNDERLINED", "\033[4;34m"),
            entry("PURPLE_UNDERLINED", "\033[4;35m"),
            entry("CYAN_UNDERLINED", "\033[4;36m"),
            entry("WHITE_UNDERLINED", "\033[4;37m"),
            entry("BLACK_BACKGROUND", "\033[40m"),
            entry("RED_BACKGROUND", "\033[41m"),
            entry("GREEN_BACKGROUND", "\033[42m"),
            entry("YELLOW_BACKGROUND", "\033[43m"),
            entry("BLUE_BACKGROUND", "\033[44m"),
            entry("PURPLE_BACKGROUND", "\033[45m"),
            entry("CYAN_BACKGROUND", "\033[46m"),
            entry("WHITE_BACKGROUND", "\033[47m"),
            entry("BLACK_BRIGHT", "\033[0;90m"),
            entry("RED_BRIGHT", "\033[0;91m"),
            entry("GREEN_BRIGHT", "\033[0;92m"),
            entry("YELLOW_BRIGHT", "\033[0;93m"),
            entry("BLUE_BRIGHT", "\033[0;94m"),
            entry("PURPLE_BRIGHT", "\033[0;95m"),
            entry("CYAN_BRIGHT", "\033[0;96m"),
            entry("WHITE_BRIGHT", "\033[0;97m"),
            entry("BLACK_BOLD_BRIGHT", "\033[1;90m"),
            entry("RED_BOLD_BRIGHT", "\033[1;91m"),
            entry("GREEN_BOLD_BRIGHT", "\033[1;92m"),
            entry("YELLOW_BOLD_BRIGHT", "\033[1;93m"),
            entry("BLUE_BOLD_BRIGHT", "\033[1;94m"),
            entry("PURPLE_BOLD_BRIGHT", "\033[1;95m"),
            entry("CYAN_BOLD_BRIGHT", "\033[1;96m"),
            entry("WHITE_BOLD_BRIGHT", "\033[1;97m"),
            entry("BLACK_BACKGROUND_BRIGHT", "\033[0;100m"),
            entry("RED_BACKGROUND_BRIGHT", "\033[0;101m"),
            entry("GREEN_BACKGROUND_BRIGHT", "\033[0;102m"),
            entry("YELLOW_BACKGROUND_BRIGHT", "\033[0;103m"),
            entry("BLUE_BACKGROUND_BRIGHT", "\033[0;104m"),
            entry("PURPLE_BACKGROUND_BRIGHT", "\033[0;105m"),
            entry("CYAN_BACKGROUND_BRIGHT", "\033[0;106m"),
            entry("WHITE_BACKGROUND_BRIGHT", "\033[0;107m")
    );
    public static final String RESET = "\033[0m"; // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m"; // BLACK
    public static final String RED = "\033[0;31m"; // RED
    public static final String GREEN = "\033[0;32m"; // GREEN
    public static final String YELLOW = "\033[0;33m"; // YELLOW
    public static final String BLUE = "\033[0;34m"; // BLUE
    public static final String PURPLE = "\033[0;35m"; // PURPLE
    public static final String CYAN = "\033[0;36m"; // CYAN
    public static final String WHITE = "\033[0;37m"; // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m"; // BLACK
    public static final String RED_BOLD = "\033[1;31m"; // RED
    public static final String GREEN_BOLD = "\033[1;32m"; // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m"; // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m"; // CYAN
    public static final String WHITE_BOLD = "\033[1;37m"; // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m"; // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m"; // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m"; // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m"; // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m"; // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m"; // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m"; // BLACK
    public static final String RED_BACKGROUND = "\033[41m"; // RED
    public static final String GREEN_BACKGROUND = "\033[42m"; // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m"; // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m"; // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m"; // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m"; // BLACK
    public static final String RED_BRIGHT = "\033[0;91m"; // RED
    public static final String GREEN_BRIGHT = "\033[0;92m"; // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m"; // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m"; // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m"; // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m"; // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m"; // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m"; // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m"; // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m"; // WHITE

    public static void println(String x) {
        // Maybe a default color - white for now
        System.out.println(x);
    }

    public static String printfBasic(String x, String... args) {
        String[] colors;
        if (args[args.length - 1].equals(RESET)) {

            colors = new String[args.length];
        } else {
            colors = new String[args.length + 1];

        }
        for (int i = 0; i < args.length; i++) {
            if (args[i].endsWith("m")) {
                colors[i] = args[i];
            } else {
                colors[i] = ColorPrinter.Colors.get(args[i]);
            }
        }
        if (colors.length != args.length) {
            colors[args.length] = RESET;
        }
        return String.format(x + "%s", (Object[]) colors);
    }

    public static String printf(String x) {
        Pattern pattern = Pattern.compile("\\$([\\S+]+)\\{(.*?)(?<!\\\\)}");
        Matcher matcher = pattern.matcher(x);
        return matcher.replaceAll(m -> Colors.get(m.group(1)) + m.group(2) + RESET);
    }

    public static String printf(String x, String... args){
        x = x.replaceAll("\\$\\{(.*?)(?<!\\\\)}", "%s" + "$1" + RESET);
        String[] colors = new String[args.length + 1];
        for (int i = 0; i < args.length; i++) {
            if (args[i].endsWith("m")) {
                colors[i] = args[i];
            } else {
                colors[i] = ColorPrinter.Colors.get(args[i]);
            }
        }
        return String.format(x, (Object[]) colors);
    }

    public static String println(String x, String color) {
        String COLOR = ColorPrinter.Colors.get(color);
        return (COLOR + x + RESET);
    }
}
