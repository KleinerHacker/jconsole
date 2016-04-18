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
    public static final String TAG_CARET_STORE = TAG_START + "s";
    public static final String TAG_CARET_RESTORE = TAG_START + "u";
    public static final String TAG_CARET_MOVE_UP = TAG_START + "%sA";
    public static final String TAG_CARET_MOVE_DOWN = TAG_START + "%sB";
    public static final String TAG_CARET_MOVE_FORWARD = TAG_START + "%sC";
    public static final String TAG_CARET_MOVE_BACKWARD = TAG_START + "%sD";

    public static final String TAG_MODIFY_CLEAR_SCREEN = TAG_START + "2J";
    public static final String TAG_MODIFY_CLEAR_SCREEN_AFTER = TAG_START + "J";
    public static final String TAG_MODIFY_CLEAR_SCREEN_BEFORE = TAG_START + "1J";
    public static final String TAG_MODIFY_CLEAR_LINE = TAG_START + "2K";
    public static final String TAG_MODIFY_CLEAR_LINE_AFTER = TAG_START + "0K";
    public static final String TAG_MODIFY_CLEAR_LINE_BEFORE = TAG_START + "1K";
    public static final String TAG_MODIFY_CLEAR_CHARACTER = TAG_START + "%sX";

    public static final String TAG_MODIFY_INSERT_CHARACTER = TAG_START + "%s@";
    public static final String TAG_MODIFY_DELETE_CHARACTER = TAG_START + "%sP";
    public static final String TAG_MODIFY_INSERT_LINE = TAG_START + "%sL";
    public static final String TAG_MODIFY_DELETE_LINE = TAG_START + "%sM";

    private ANSIConstants() {
    }
}
