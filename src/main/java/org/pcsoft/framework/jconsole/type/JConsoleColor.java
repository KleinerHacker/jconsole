package org.pcsoft.framework.jconsole.type;

import java.util.Objects;

public final class JConsoleColor {
    public static final JConsoleColor DEFAULT_FOREGROUND = new JConsoleColor(false, ColorValue.White);
    public static final JConsoleColor DEFAULT_BACKGROUND = new JConsoleColor(false, ColorValue.Black);

    public static JConsoleColor createDefault(ColorValue value) {
        return new JConsoleColor(false, value);
    }

    public static JConsoleColor createHighlighted(ColorValue value) {
        return new JConsoleColor(true, value);
    }

    private final boolean highlighted;
    private final ColorValue value;

    private JConsoleColor(boolean highlighted, ColorValue value) {
        this.highlighted = highlighted;
        this.value = value;
    }

    public boolean isHighlighted() {
        return highlighted;
    }

    public ColorValue getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JConsoleColor that = (JConsoleColor) o;
        return highlighted == that.highlighted &&
                value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(highlighted, value);
    }

    @Override
    public String toString() {
        return "JConsoleColor{" +
                "highlighted=" + highlighted +
                ", value=" + value +
                '}';
    }

    public enum ColorValue {
        Black(30),
        Red(31),
        Green(32),
        Yellow(33),
        Blue(34),
        Magenta(35),
        Cyan(36),
        White(37);

        private final int basicCode;

        ColorValue(int basicCode) {
            this.basicCode = basicCode;
        }

        public int getBasicCode() {
            return basicCode;
        }
    }
}
