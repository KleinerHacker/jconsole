package org.pcsoft.framework.jconsole;

import org.junit.Test;

public class JConsoleClearTest {
    @Test
    public void testClearAll() {
        final var console = JConsole.getInstance();

        console.writeln("Hello World");
        console.writeln("Hello World");
        console.writeln("Hello World");

        console.clearScreen();
    }

    @Test
    public void testClearLine() {
        final var console = JConsole.getInstance();

        console.writeln("Hello World");
        console.writeln("Hello World");
        console.write("Hello World");

        console.clearLine();
    }
}
