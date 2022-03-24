package org.pcsoft.framework.jconsole.types;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public final class JConsoleFont {
    public static final JConsoleFont DEFAULT = JConsoleFont.createBuilder().build();
    public static final JConsoleFont BOLD = JConsoleFont.createBuilder().bold().build();
    public static final JConsoleFont ITALIC = JConsoleFont.createBuilder().italic().build();
    public static final JConsoleFont UNDERLINE = JConsoleFont.createBuilder().underline().build();
    public static final JConsoleFont STRIKEOUT = JConsoleFont.createBuilder().strikeout().build();
    public static final JConsoleFont BLINKING = JConsoleFont.createBuilder().blinking().build();

    public static Builder createBuilder() {
        return new Builder();
    }

    private final boolean bold;
    private final boolean italic;
    private final boolean underline;
    private final boolean strikeout;
    private final boolean blinking;

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Builder {
        private boolean bold;
        private boolean italic;
        private boolean underline;
        private boolean strikeout;
        private boolean blinking;

        public Builder bold() {
            this.bold = true;
            return this;
        }

        public Builder italic() {
            this.italic = true;
            return this;
        }

        public Builder underline() {
            this.underline = true;
            return this;
        }

        public Builder strikeout() {
            this.strikeout = true;
            return this;
        }

        public Builder blinking() {
            this.blinking = true;
            return this;
        }

        public JConsoleFont build() {
            return new JConsoleFont(bold, italic, underline, strikeout, blinking);
        }
    }
}
