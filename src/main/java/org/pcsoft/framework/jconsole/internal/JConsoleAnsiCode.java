package org.pcsoft.framework.jconsole.internal;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.NotImplementedException;
import org.pcsoft.framework.jconsole.type.JConsoleColor;
import org.pcsoft.framework.jconsole.type.JConsoleFontStyle;

import java.util.ArrayList;
import java.util.List;

public final class JConsoleAnsiCode {
    public static int getAnsiCode(JConsoleColor color, ColorType colorType) {
        switch (colorType) {
            case Foreground:
                return color.getValue().getBasicCode() + (color.isHighlighted() ? 60 : 0);
            case Background:
                return color.getValue().getBasicCode() + (color.isHighlighted() ? 60 : 0) + 10;
            default:
                throw new NotImplementedException();
        }
    }

    public static int[] getAnsiCodes(JConsoleFontStyle style) {
        if (style.equals(JConsoleFontStyle.DEFAULT))
            return new int[] {0};

        final List<Integer> list = new ArrayList<>();
        if (style.isBold()) {
            list.add(1);
        } else {
            list.add(2);
        }
        if (style.isItalic()) {
            list.add(3);
        } else {
            list.add(23);
        }
        if (style.isUnderline()) {
            list.add(4);
        } else {
            list.add(24);
        }
        if (style.isStrikeout()) {
            list.add(9);
        } else {
            list.add(29);
        }
        if (style.isFramed()) {
            list.add(51);
        } else {
            list.add(54);
        }

        return ArrayUtils.toPrimitive(list.toArray(new Integer[0]));
    }

    private JConsoleAnsiCode() {
    }

    public enum ColorType {
        Foreground,
        Background
    }
}
