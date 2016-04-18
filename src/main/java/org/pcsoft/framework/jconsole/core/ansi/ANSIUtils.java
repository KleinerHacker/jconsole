package org.pcsoft.framework.jconsole.core.ansi;

import org.pcsoft.framework.jconsole.type.JConsoleColor;

/**
 * Created by Christoph on 18.03.2016.
 */
public final class ANSIUtils {

    private static String getForegroundANSIColor(JConsoleColor consoleColor) {
        return String.format(ANSIConstants.TAG_COLOR_FOREGROUND, getANSIColorNumber(consoleColor));
    }

    private static String getBackgroundANSIColor(JConsoleColor consoleColor) {
        return String.format(ANSIConstants.TAG_COLOR_BACKGROUND, getANSIColorNumber(consoleColor));
    }

    public static String getANSIStyle(boolean bold, JConsoleColor foregroundColor, JConsoleColor backgroundColor) {
        final StringBuilder sb = new StringBuilder();
        sb.append(ANSIConstants.TAG_STYLE_UNSET);
        if (bold) {
            sb.append(ANSIConstants.TAG_STYLE_BOLD);
        }
        sb.append(getForegroundANSIColor(foregroundColor));
        sb.append(getBackgroundANSIColor(backgroundColor));

        return sb.toString();
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
            case Default:
                return 9;
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

    public static String getANSICaretVisible(boolean visible) {
        return visible ? ANSIConstants.TAG_CARET_VISIBLE : ANSIConstants.TAG_CARET_INVISIBLE;
    }

    public static String getANSICaretAction(ANSICaretStoreAction caretAction) {
        return caretAction.getCode();
    }

    public static String getANSICaretAction(ANSICaretMoveAction moveAction, int count) {
        return String.format(moveAction.getCode(), count);
    }

    public static String getANSICaretAction(ANSICaretMoveAction moveAction) {
        return getANSICaretAction(moveAction, 1);
    }

    public static String getANSIClearAction(ANSIClearAction clearAction) {
        if (clearAction.isNeedsCount())
            throw new IllegalArgumentException("Value " + clearAction.isNeedsCount() + " needs a count value");

        return clearAction.getCode();
    }

    public static String getANSIClearAction(ANSIClearAction clearAction, int count) {
        if (!clearAction.isNeedsCount())
            throw new IllegalArgumentException("Value " + clearAction.name() + " do not need a count value");

        return String.format(clearAction.getCode(), count);
    }

    public static String getANSIModifyAction(ANSIModifyAction modifyAction) {
        return getANSIModifyAction(modifyAction, 1);
    }

    public static String getANSIModifyAction(ANSIModifyAction modifyAction, int count) {
        return String.format(modifyAction.getCode(), count);
    }

    private ANSIUtils() {
    }
}
