package org.pcsoft.framework.jconsole;

import org.junit.Test;
import org.pcsoft.framework.jconsole.types.JConsolePoint;

public class JConsoleCursorTest {
    @Test
    public void test() throws Exception {
        final var console = JConsole.getInstance();

        for (var i=0; i<100; i++) {
            console.moveCursor(new JConsolePoint(10, 10));
            console.write(i);

            Thread.sleep(10);
        }
    }
}
