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

//        console.gotoCaretPosition(1,1);
//        console.writeLine("Hallo");
//        console.gotoCaretPosition(1,1);
//        console.write("\u001B[4X");

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
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        console.deleteLineAt(0);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        console.deleteCharacterAt(0, 0, 2);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
