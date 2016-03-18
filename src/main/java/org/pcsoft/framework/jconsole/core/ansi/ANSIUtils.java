package org.pcsoft.framework.jconsole.core.ansi;

import org.pcsoft.framework.jconsole.type.JConsoleColor;

/**
 * Created by Christoph on 18.03.2016.
 */
public final class ANSIUtils {

    public static String getForegroundANSIColor(JConsoleColor consoleColor) {
        return String.format(ANSIConstants.TAG_COLOR_FOREGROUND, getANSIColorNumber(consoleColor));
    }

    public static String getResetForegroundANSIColor() {
        return String.format(ANSIConstants.TAG_COLOR_FOREGROUND, 9);
    }

    public static String getBackgroundANSIColor(JConsoleColor consoleColor) {
        return String.format(ANSIConstants.TAG_COLOR_BACKGROUND, getANSIColorNumber(consoleColor));
    }

    public static String getResetBackgroundANSIColor() {
        return String.format(ANSIConstants.TAG_COLOR_BACKGROUND, 9);
    }

    private static int getANSIColorNumber(JConsoleColor consoleColor) {
        switch (consoleColor) {
            case Black:
                return 0;
            case Red:
                return 1;
            case Green:
                return 2;
            case Yellow:
                return 3;
            case Blue:
                return 4;
            case Magenta:
                return 5;
            case Cyan:
                return 6;
            case White:
                return 7;
            default:
                throw new RuntimeException();
        }
    }

    public static String getANSICaretHome(int x, int y) {
        return String.format(ANSIConstants.TAG_CARET_HOME, x, y);
    }

    public static String getANSICaretGotoHome() {
        return ANSIConstants.TAG_CARET_GOTO_HOME;
    }

    private ANSIUtils() {
    }
}
