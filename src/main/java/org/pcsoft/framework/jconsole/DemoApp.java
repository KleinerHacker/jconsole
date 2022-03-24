package org.pcsoft.framework.jconsole;

import org.pcsoft.framework.jconsole.types.JConsoleColor;

public class DemoApp {
    public static void main(String[] args) {
        final var console = JConsole.getInstance();

        console.setForegroundColor(JConsoleColor.RED);
        console.write("bdcsuiugru");
    }
}
