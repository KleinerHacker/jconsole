package org.pcsoft.framework.jconsole;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcsoft.framework.jconsole.types.JConsoleFont;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JConsoleAnsi {
    public static final String ESCAPE = "\u001b";
    private static final String GRAPHIC = ESCAPE + "[%dm";
    private static final String FONT = ESCAPE + "[%d;%d;%d;%dm";
    private static final String CURSOR = ESCAPE + "[%d%s";

    public static void setColor(int index) {
        System.out.printf(GRAPHIC, index);
    }

    public static void setFont(JConsoleFont font) {
        System.out.printf(
                FONT,
                font.isBold() ? 1 : 22,
                font.isItalic() ? 3 : 23,
                font.isUnderline() ? 4 : 24,
                font.isStrikeout() ? 9 : 29
        );
    }

    public static void moveCursor(String cmd, int count) {
        System.out.printf(CURSOR, count, cmd);
    }
}
