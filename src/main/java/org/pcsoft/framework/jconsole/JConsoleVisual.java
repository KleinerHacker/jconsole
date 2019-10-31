package org.pcsoft.framework.jconsole;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.pcsoft.framework.jconsole.internal.JConsoleAnsiCode;
import org.pcsoft.framework.jconsole.type.JConsoleColorPair;
import org.pcsoft.framework.jconsole.type.JConsoleColor;
import org.pcsoft.framework.jconsole.type.JConsoleFontStyle;

public final class JConsoleVisual {
    private JConsoleColor foreground = JConsoleColor.DEFAULT_FOREGROUND;
    private JConsoleColor background = JConsoleColor.DEFAULT_FOREGROUND;
    private JConsoleFontStyle fontStyle = JConsoleFontStyle.DEFAULT;

    public void resetVisual() {
        printAnsiStyle(0);
        foreground = JConsoleColor.DEFAULT_FOREGROUND;
        background = JConsoleColor.DEFAULT_BACKGROUND;
        fontStyle = JConsoleFontStyle.DEFAULT;
    }

    //region Colors
    public void setForeground(JConsoleColor color) {
        printAnsiStyle(JConsoleAnsiCode.getAnsiCode(color, JConsoleAnsiCode.ColorType.Foreground));
        foreground = color;
    }

    public JConsoleColor getForeground() {
        return foreground;
    }

    public void resetForeground() {
        printAnsiStyle(39);
        foreground = JConsoleColor.DEFAULT_FOREGROUND;
    }

    public void setBackground(JConsoleColor color) {
        printAnsiStyle(JConsoleAnsiCode.getAnsiCode(color, JConsoleAnsiCode.ColorType.Background));
        background = color;
    }

    public JConsoleColor getBackground() {
        return background;
    }

    public void resetBackground() {
        printAnsiStyle(49);
        background = JConsoleColor.DEFAULT_BACKGROUND;
    }

    public void setColor(JConsoleColorPair color) {
        setForeground(color.getForeground());
        setBackground(color.getBackground());
    }

    public JConsoleColorPair getColor() {
        return new JConsoleColorPair(foreground, background);
    }

    public void resetColor() {
        resetForeground();
        resetBackground();
    }

    public void inverseColors() {
        final JConsoleColor tmp = foreground;
        foreground = background;
        background = tmp;

        setForeground(foreground);
        setBackground(background);
    }
    //endregion

    //region Fonts
    public void setFontStyle(JConsoleFontStyle style) {
        printAnsiStyle(JConsoleAnsiCode.getAnsiCodes(style));
        fontStyle = style;
    }

    public JConsoleFontStyle getFontStyle() {
        return fontStyle;
    }

    public void resetFontStyle() {
        printAnsiStyle(JConsoleAnsiCode.getAnsiCodes(JConsoleFontStyle.DEFAULT));
        fontStyle = JConsoleFontStyle.DEFAULT;
    }
    //endregion

    private void printAnsiStyle(int... code) {
        JConsole.printAnsi(StringUtils.join(ArrayUtils.toObject(code), ';') + "m");
    }

    JConsoleVisual() {
    }
}
