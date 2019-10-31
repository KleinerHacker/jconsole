package org.pcsoft.framework.jconsole;

public final class JConsoleCursor {
    private boolean showCursor = true;

    public void gotoXY(int x, int y) {
        JConsole.printAnsi(y + ";" + x + "H");
    }

    public void goHome() {
        JConsole.printAnsi("H");
    }

    public void goUp() {
        goUp(1);
    }

    public void goUp(int v) {
        if (v <= 0)
            throw new IllegalArgumentException("Value must be greater than 0");

        JConsole.printAnsi(v + "A");
    }

    public void goDown() {
        goDown(1);
    }

    public void goDown(int v) {
        if (v <= 0)
            throw new IllegalArgumentException("Value must be greater than 0");

        JConsole.printAnsi(v + "B");
    }

    public void goForward() {
        goForward(1);
    }

    public void goForward(int v) {
        if (v <= 0)
            throw new IllegalArgumentException("Value must be greater than 0");

        JConsole.printAnsi(v + "C");
    }

    public void goBackward() {
        goBackward(1);
    }

    public void goBackward(int v) {
        if (v <= 0)
            throw new IllegalArgumentException("Value must be greater than 0");

        JConsole.printAnsi(v + "D");
    }

    public void storePosition() {
        JConsole.printAnsi("s");
    }

    public void restorePosition() {
        JConsole.printAnsi("u");
    }

    public void setCursorVisible(boolean visible) {
        if (visible) {
            JConsole.printAnsi("?25h");
        } else {
            JConsole.printAnsi("?25l");
        }
        showCursor = visible;
    }

    public boolean isCursorVisible() {
        return showCursor;
    }

    JConsoleCursor() {
    }
}
