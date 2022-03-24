package org.pcsoft.framework.jconsole;

import org.junit.Test;
import org.pcsoft.framework.jconsole.types.JConsoleColor;

public class JConsoleColorTest {
    @Test
    public void testForeground() {
        final var console = JConsole.getInstance();

        console.writeln("Hello World");
        console.setForegroundColor(JConsoleColor.RED);
        console.writeln("Colored World");
        console.setForegroundColor(JConsoleColor.LIGHT_RED);
        console.writeln("Bright Colored World");
        console.resetForegroundColor();
        console.writeln("Gray World");
    }

    @Test
    public void testBackground() {
        final var console = JConsole.getInstance();

        console.writeln("Hello World");
        console.setBackgroundColor(JConsoleColor.RED);
        console.writeln("Colored World");
        console.setBackgroundColor(JConsoleColor.LIGHT_RED);
        console.writeln("Bright Colored World");
        console.resetBackgroundColor();
        console.writeln("Gray World");
    }
}
