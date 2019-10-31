package org.pcsoft.framework.jconsole.type;

import java.util.Objects;

public final class JConsoleFontStyle {
    public static final JConsoleFontStyle DEFAULT = new JConsoleFontStyle(false, false, false, false, false);
    public static final JConsoleFontStyle BOLD = new JConsoleFontStyle(true, false, false, false, false);
    public static final JConsoleFontStyle ITALIC = new JConsoleFontStyle(false, true, false, false, false);
    public static final JConsoleFontStyle UNDERLINE = new JConsoleFontStyle(false, false, true, false, false);
    public static final JConsoleFontStyle STRIKEOUT = new JConsoleFontStyle(false, false, false, true, false);
    public static final JConsoleFontStyle FRAMED = new JConsoleFontStyle(false, false, false, false, true);

    private final boolean bold;
    private final boolean italic;
    private final boolean underline;
    private final boolean strikeout;
    private final boolean framed;

    public JConsoleFontStyle(boolean bold, boolean italic, boolean underline, boolean strikeout, boolean framed) {
        this.bold = bold;
        this.italic = italic;
        this.underline = underline;
        this.strikeout = strikeout;
        this.framed = framed;
    }

    public boolean isBold() {
        return bold;
    }

    public boolean isItalic() {
        return italic;
    }

    public boolean isUnderline() {
        return underline;
    }

    public boolean isStrikeout() {
        return strikeout;
    }

    public boolean isFramed() {
        return framed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JConsoleFontStyle that = (JConsoleFontStyle) o;
        return bold == that.bold &&
                italic == that.italic &&
                underline == that.underline &&
                strikeout == that.strikeout &&
                framed == that.framed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bold, italic, underline, strikeout, framed);
    }

    @Override
    public String toString() {
        return "JConsoleFontStyle{" +
                "bold=" + bold +
                ", italic=" + italic +
                ", underline=" + underline +
                ", strikeout=" + strikeout +
                ", framed=" + framed +
                '}';
    }
}
