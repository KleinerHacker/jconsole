package org.pcsoft.framework.jconsole;

import org.junit.Test;
import org.pcsoft.framework.jconsole.core.JANSIConsoleManipulator;
import org.pcsoft.framework.jconsole.type.JConsoleColor;

import java.io.IOException;

/**
 * Created by Christoph on 18.03.2016.
 */
public class TestJConsole {

    @Test
    public void test() throws IOException {
        final JConsole console = JConsoleFactory.getDefaultConsole();
        console.setConsoleManipulator(JANSIConsoleManipulator.class);
        console.clearScreen();
        console.write("\u001B[c");

        console.setForegroundColor(JConsoleColor.Red);
        console.writeLine("Hello World");
        console.resetForegroundColor();

        console.setForegroundColor(JConsoleColor.Green);
        console.setBold(true);
        console.write("Hello");
        console.setBold(false);
        console.writeLine(" World");

        console.setForegroundColor(JConsoleColor.Blue);
        console.gotoCaretPosition(10, 10);
        console.write("Hello World");
        console.resetForegroundColor();
        console.moveCaretDown();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
