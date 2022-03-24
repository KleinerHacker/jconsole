package org.pcsoft.framework.jconsole;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.pcsoft.framework.jconsole.types.JConsoleColor;
import org.pcsoft.framework.jconsole.types.JConsoleFont;
import org.pcsoft.framework.jconsole.types.JConsolePoint;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public final class JConsole {
    private static final JConsole INSTANCE = new JConsole();

    public static JConsole getInstance() {
        return INSTANCE;
    }

    //region Read
    public String readLine() {
        return System.console().readLine();
    }

    public String readLine(String format, Object... args) {
        return System.console().readLine(format, args);
    }

    public char[] readPassword() {
        return System.console().readPassword();
    }

    public char[] readPassword(String format, Object... args) {
        return System.console().readPassword(format, args);
    }
    //endregion

    //region Write
    public void write(Object msg) {
        System.out.print(msg);
    }

    public void writef(String msg, Object... args) {
        System.out.printf(msg, args);
    }

    public void writeln(Object msg) {
        System.out.println(msg);
    }

    public void writelnf(String msg, Object... args) {
        System.out.printf(msg, args);
        System.out.println();
    }

    public void writeln() {
        System.out.println();
    }
    //endregion

    //region Clear
    public void clearScreen() {
        System.out.print(JConsoleAnsi.ESCAPE + "[2J");
    }

    public void clearScreenAfterCursor() {
        System.out.print(JConsoleAnsi.ESCAPE + "[0J");
    }

    public void clearScreenAfter(JConsolePoint point) {
        saveCursorPosition();
        moveCursor(point);
        clearScreenAfterCursor();
        restoreCursorPosition();
    }

    public void clearScreenBeforeCursor() {
        System.out.print(JConsoleAnsi.ESCAPE + "[1J");
    }

    public void clearScreenBefore(JConsolePoint point) {
        saveCursorPosition();
        moveCursor(point);
        clearScreenBeforeCursor();
        restoreCursorPosition();
    }

    public void clearLine() {
        System.out.print(JConsoleAnsi.ESCAPE + "[2K");
    }

    public void clearLineAfterCursor() {
        System.out.print(JConsoleAnsi.ESCAPE + "[0K");
    }

    public void clearLineAfter(JConsolePoint point) {
        saveCursorPosition();
        moveCursor(point);
        clearLineAfterCursor();
        restoreCursorPosition();
    }

    public void clearLineBeforeCursor() {
        System.out.print(JConsoleAnsi.ESCAPE + "[1K");
    }

    public void clearLineBefore(JConsolePoint point) {
        saveCursorPosition();
        moveCursor(point);
        clearLineBeforeCursor();
        restoreCursorPosition();
    }
    //endregion

    //region Color
    private JConsoleColor foregroundColor = JConsoleColor.DEFAULT;
    private JConsoleColor backgroundColor = JConsoleColor.DEFAULT;

    public void setForegroundColor(JConsoleColor foregroundColor) {
        this.foregroundColor = foregroundColor;
        JConsoleAnsi.setColor(30 + foregroundColor.getAnsiCode());
    }

    public void setBackgroundColor(JConsoleColor backgroundColor) {
        this.backgroundColor = backgroundColor;
        JConsoleAnsi.setColor(40 + backgroundColor.getAnsiCode());
    }

    public void setColor(JConsoleColor foregroundColor, JConsoleColor backgroundColor) {
        setForegroundColor(foregroundColor);
        setBackgroundColor(backgroundColor);
    }

    public void resetForegroundColor() {
        setForegroundColor(JConsoleColor.DEFAULT);
    }

    public void resetBackgroundColor() {
        setBackgroundColor(JConsoleColor.DEFAULT);
    }

    public void resetColor() {
        resetForegroundColor();
        resetBackgroundColor();
    }
    //endregion

    //region Font
    private JConsoleFont font = JConsoleFont.DEFAULT;

    public void setFont(JConsoleFont font) {
        this.font = font;
        JConsoleAnsi.setFont(font);
    }

    public void resetFont() {
        setFont(JConsoleFont.DEFAULT);
    }
    //endregion

    //region Cursor
    private boolean hasSavedCursorPosition;
    private boolean cursorVisible;

    public void saveCursorPosition() {
        System.out.print(JConsoleAnsi.ESCAPE + " 7");
        hasSavedCursorPosition = true;
    }

    public void restoreCursorPosition() {
        if (!hasSavedCursorPosition)
            throw new IllegalStateException("No cursor position stored yet");

        System.out.print(JConsoleAnsi.ESCAPE + " 8");
    }

    public void resetCursorPosition() {
        System.out.print(JConsoleAnsi.ESCAPE + "[H");
    }

    public void moveCursor(JConsolePoint point) {
        System.out.print(JConsoleAnsi.ESCAPE + "[" + point.getX() + ";" + point.getY() + "H");
    }

    public void moveCursorUp(int lines, boolean backToStart) {
        if (backToStart) {
            JConsoleAnsi.moveCursor("F", lines);
        } else {
            JConsoleAnsi.moveCursor("A", lines);
        }
    }

    public void moveCursorUp(int lines) {
        moveCursorUp(lines, false);
    }

    public void moveCursorUp(boolean backToStart) {
        moveCursorUp(1, backToStart);
    }

    public void moveCursorUp() {
        moveCursorUp(1, false);
    }

    public void moveCursorDown(int lines, boolean backToStart) {
        if (backToStart) {
            JConsoleAnsi.moveCursor("E", lines);
        } else {
            JConsoleAnsi.moveCursor("B", lines);
        }
    }

    public void moveCursorDown(int lines) {
        moveCursorDown(lines, false);
    }

    public void moveCursorDown(boolean backToStart) {
        moveCursorDown(1, backToStart);
    }

    public void moveCursorDown() {
        moveCursorDown(1, false);
    }

    public void moveCursorRight(int lines) {
        JConsoleAnsi.moveCursor("C", lines);
    }

    public void moveCursorRight() {
        moveCursorRight(1);
    }

    public void moveCursorLeft(int lines) {
        JConsoleAnsi.moveCursor("D", lines);
    }

    public void moveCursorLeft() {
        moveCursorLeft(1);
    }

    public void setCursorVisible(boolean cursorVisible) {
        this.cursorVisible = cursorVisible;
        System.out.print(JConsoleAnsi.ESCAPE + "[?25" + (cursorVisible ? "h" : "l"));
    }
    //endregion

    //region Commons
    private boolean hasSavedScreen;
    private boolean wrapping;

    public void saveScreen() {
        System.out.print(JConsoleAnsi.ESCAPE + "[?47h");
        hasSavedScreen = true;
    }

    public void restoreScreen() {
        if (!hasSavedScreen)
            throw new IllegalStateException("No screen stored yet");

        System.out.print(JConsoleAnsi.ESCAPE + "[?47l");
    }

    public void setWrapping(boolean wrapping) {
        this.wrapping = wrapping;
        System.out.print(JConsoleAnsi.ESCAPE + "[=7" + (wrapping ? "h" : "l"));
    }

    //endregion
}
