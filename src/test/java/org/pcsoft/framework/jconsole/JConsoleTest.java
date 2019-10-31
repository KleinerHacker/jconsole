package org.pcsoft.framework.jconsole;

import org.pcsoft.framework.jconsole.type.*;

public class JConsoleTest {

    public static void main(String[] args) {
        JConsole.startBackBuffering();
        try {
            JConsole.SYSTEM.setWindowTitle("JConsole DEMO");
            JConsole.SYSTEM.setWidth(JConsoleWidth.Default);
            JConsole.VISUAL.setForeground(JConsoleColor.createDefault(JConsoleColor.ColorValue.Red));
            JConsole.VISUAL.setBackground(JConsoleColor.createDefault(JConsoleColor.ColorValue.Yellow));
            JConsole.println("That is my text");
            JConsole.VISUAL.inverseColors();
            JConsole.println("Ups, turn around");

            JConsole.VISUAL.resetColor();
            JConsole.printlnAccent("H<<a>>llo W<<e>>lt", new JConsoleColorPair(JConsoleColor.createDefault(JConsoleColor.ColorValue.Red), JConsoleColor.createDefault(JConsoleColor.ColorValue.White)));

            JConsole.VISUAL.resetVisual();
            JConsole.VISUAL.setFontStyle(JConsoleFontStyle.UNDERLINE);
            JConsole.println("My Text");

            JConsole.VISUAL.resetVisual();
            JConsole.CURSOR.gotoXY(0,25);
            JConsole.CURSOR.setCursorVisible(false);
        } finally {
            JConsole.endBackBuffering();
        }

        JConsole.setInputMode(JConsoleInputMode.Direct);
        while (true) {
            final int value = JConsole.read();
            if (value != 0) {
                break;
            }
        }
        JConsole.resetInputMode();
    }

}
