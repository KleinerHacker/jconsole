package org.pcsoft.framework.jconsole.core.ansi;

/**
 * Created by Christoph on 18.03.2016.
 */
final class ANSIConstants {
    private static final String TAG_START = "\u001B[";

    public static final String TAG_STYLE_UNSET = TAG_START + "0m";
    public static final String TAG_COLOR_FOREGROUND = TAG_START + "3%sm";
    public static final String TAG_COLOR_BACKGROUND = TAG_START + "4%sm";
    public static final String TAG_STYLE_BOLD = TAG_START + "1m";

    public static final String TAG_CARET_HOME = TAG_START + "%s;%sH";
    public static final String TAG_CARET_GOTO_HOME = TAG_START + "H";
    public static final String TAG_CARET_VISIBLE = TAG_START + "?25l";
    public static final String TAG_CARET_INVISIBLE = TAG_START + "?25h";


    private ANSIConstants() {
    }
}
