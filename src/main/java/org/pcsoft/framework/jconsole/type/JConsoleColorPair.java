package org.pcsoft.framework.jconsole.type;

import java.util.Objects;

public final class JConsoleColorPair {
    public static final JConsoleColorPair DEFAULT = new JConsoleColorPair(
            JConsoleColor.DEFAULT_FOREGROUND,
            JConsoleColor.DEFAULT_BACKGROUND
    );

    private final JConsoleColor foreground, background;

    public JConsoleColorPair(JConsoleColor foreground, JConsoleColor background) {
        this.foreground = foreground;
        this.background = background;
    }

    public JConsoleColor getForeground() {
        return foreground;
    }

    public JConsoleColor getBackground() {
        return background;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JConsoleColorPair that = (JConsoleColorPair) o;
        return Objects.equals(foreground, that.foreground) &&
                Objects.equals(background, that.background);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foreground, background);
    }

    @Override
    public String toString() {
        return "JCConsoleColorPair{" +
                "foreground=" + foreground +
                ", background=" + background +
                '}';
    }
}
