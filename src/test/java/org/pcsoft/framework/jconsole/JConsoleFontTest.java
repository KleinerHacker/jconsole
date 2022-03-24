package org.pcsoft.framework.jconsole;

import org.junit.Test;
import org.pcsoft.framework.jconsole.types.JConsoleFont;

public class JConsoleFontTest {
    @Test
    public void testBold() {
        final var console = JConsole.getInstance();

        console.writeln("Hello World");
        console.setFont(JConsoleFont.BOLD);
        console.writeln("Styled World");
        console.resetFont();
        console.writeln("Gray World");
    }

    @Test
    public void testItalic() {
        final var console = JConsole.getInstance();

        console.writeln("Hello World");
        console.setFont(JConsoleFont.ITALIC);
        console.writeln("Styled World");
        console.resetFont();
        console.writeln("Gray World");
    }

    @Test
    public void testUnderline() {
        final var console = JConsole.getInstance();

        console.writeln("Hello World");
        console.setFont(JConsoleFont.UNDERLINE);
        console.writeln("Styled World");
        console.resetFont();
        console.writeln("Gray World");
    }

    @Test
    public void testStrikeout() {
        final var console = JConsole.getInstance();

        console.writeln("Hello World");
        console.setFont(JConsoleFont.STRIKEOUT);
        console.writeln("Styled World");
        console.resetFont();
        console.writeln("Gray World");
    }

    @Test
    public void testBlinking() {
        final var console = JConsole.getInstance();

        console.writeln("Hello World");
        console.setFont(JConsoleFont.BLINKING);
        console.writeln("Styled World");
        console.resetFont();
        console.writeln("Gray World");
    }

    @Test
    public void testAll() {
        final var console = JConsole.getInstance();

        console.writeln("Hello World");
        console.setFont(JConsoleFont.createBuilder().bold().italic().underline().strikeout().blinking().build());
        console.writeln("Styled World");
        console.resetFont();
        console.writeln("Gray World");
    }
}
