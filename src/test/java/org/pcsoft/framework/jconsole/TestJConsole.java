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

        console.setForegroundColor(JConsoleColor.Red);
        console.writeLine("Hello World");
        console.resetForegroundColor();

        console.setForegroundColor(JConsoleColor.Blue);
        console.gotoCaretPosition(10, 10);
        console.writeLine("Hello World");
        console.resetForegroundColor();
    }

}
