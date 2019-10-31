package org.pcsoft.framework.jconsole;

import org.apache.commons.lang.SystemUtils;
import org.pcsoft.framework.jconsole.internal.natives.ConsoleNative;
import org.pcsoft.framework.jconsole.type.JConsoleClearAttribute;
import org.pcsoft.framework.jconsole.type.JConsoleColorPair;
import org.pcsoft.framework.jconsole.type.JConsoleInputMode;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class JConsole {
    private static final Object MONITOR = new Object();
    public static final JConsoleVisual VISUAL = new JConsoleVisual();
    public static final JConsoleCursor CURSOR = new JConsoleCursor();

    private static JConsoleInputMode inputMode = JConsoleInputMode.Default;
    private static boolean backBuffering = false;
    private static StringBuilder backBufferStr = null;

    static {
        ConsoleNative.initConsole();
    }

    //region Print
    public static void print(String s) {
        synchronized (MONITOR) {
            if (backBuffering) {
                backBufferStr.append(s);
            } else {
                System.out.print(s);
            }
        }
    }

    public static void print(Object o) {
        synchronized (MONITOR) {
            if (backBuffering) {
                backBufferStr.append(o);
            } else {
                System.out.print(o);
            }
        }
    }

    public static void println() {
        synchronized (MONITOR) {
            if (backBuffering) {
                backBufferStr.append(SystemUtils.LINE_SEPARATOR);
            } else {
                System.out.println();
            }
        }
    }

    public static void println(String s) {
        synchronized (MONITOR) {
            if (backBuffering) {
                backBufferStr.append(s).append(SystemUtils.LINE_SEPARATOR);
            } else {
                System.out.println(s);
            }
        }
    }

    public static void println(Object o) {
        synchronized (MONITOR) {
            if (backBuffering) {
                backBufferStr.append(o).append(SystemUtils.LINE_SEPARATOR);
            } else {
                System.out.println(o);
            }
        }
    }

    public synchronized static void printAccent(String s, JConsoleColorPair accentColor) {
        final Matcher matcher = Pattern.compile("<<[^>]+>>").matcher(s);

        int currentIndex = 0;
        while (matcher.find()) {
            final int startIndex = matcher.start();
            final int endIndex = matcher.end();

            print(s.substring(currentIndex, startIndex));
            final JConsoleColorPair tmp = VISUAL.getColor();
            VISUAL.setColor(accentColor);
            print(s.substring(startIndex + 2, endIndex - 2));
            VISUAL.setColor(tmp);

            currentIndex = endIndex;
        }

        print(s.substring(currentIndex));
    }

    public static void printlnAccent(String s, JConsoleColorPair accentColor) {
        printAccent(s, accentColor);
        println();
    }

    public static void clearLine() {
        clearLine(JConsoleClearAttribute.All);
    }

    public static void clearLine(JConsoleClearAttribute attribute) {
        printAnsi(attribute.getCode() + "K");
    }

    public static void clearScreen() {
        clearScreen(JConsoleClearAttribute.All);
    }

    public static void clearScreen(JConsoleClearAttribute attribute) {
        printAnsi(attribute.getCode() + "J");
    }
    //endregion

    //region Read
    public static String readLine() {
        synchronized (MONITOR) {
            if (backBuffering)
                throw new IllegalStateException("Unable to read from console while back buffering is started");
        }

        return System.console().readLine();
    }

    public static int read() {
        synchronized (MONITOR) {
            if (backBuffering)
                throw new IllegalStateException("Unable to read from console while back buffering is started");
        }

        try {
            return System.console().reader().read();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static boolean hasKeyInput() {
        synchronized (MONITOR) {
            if (backBuffering)
                throw new IllegalStateException("Unable to read from console while back buffering is started");
        }

        try {
            return System.console().reader().ready();
        } catch (IOException e) {
            throw new IllegalStateException("Unknown error", e);
        }
    }

    public static void setInputMode(JConsoleInputMode inputMode) {
        synchronized (MONITOR) {
            if (backBuffering)
                throw new IllegalStateException("Unable to read from console while back buffering is started");
        }

        ConsoleNative.setInputMode(inputMode);
        JConsole.inputMode = inputMode;
    }

    public static JConsoleInputMode getInputMode() {
        synchronized (MONITOR) {
            if (backBuffering)
                throw new IllegalStateException("Unable to read from console while back buffering is started");
        }

        return inputMode;
    }

    public static void resetInputMode() {
        synchronized (MONITOR) {
            if (backBuffering)
                throw new IllegalStateException("Unable to read from console while back buffering is started");
        }

        ConsoleNative.resetInputMode();
        inputMode = JConsoleInputMode.Default;
    }
    //endregion


    public static boolean isBackBuffering() {
        synchronized (MONITOR) {
            return backBuffering;
        }
    }

    public static void startBackBuffering() {
        synchronized (MONITOR) {
            if (backBuffering)
                throw new IllegalStateException("Back buffering already started");

            backBuffering = true;
            backBufferStr = new StringBuilder();
        }
    }

    public static void endBackBuffering() {
        synchronized (MONITOR) {
            if (!backBuffering)
                throw new IllegalStateException("Back buffering not started");

            backBuffering = false;
            if (backBufferStr.length() > 0) {
                System.out.print(backBufferStr.toString());
            }
            backBufferStr = null;
        }
    }

    static void printAnsi(String value) {
        synchronized (MONITOR) {
            if (backBuffering) {
                backBufferStr.append("\u001B[").append(value);
            } else {
                System.out.print("\u001B[" + value);
            }
        }
    }

    private JConsole() {
    }
}
