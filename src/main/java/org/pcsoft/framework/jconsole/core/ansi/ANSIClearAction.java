package org.pcsoft.framework.jconsole.core.ansi;

/**
 * Created by Christoph on 18.04.2016.
 */
public enum ANSIClearAction implements ANSIAction {
    Screen(ANSIConstants.TAG_CLEAR_SCREEN),
    ScreenAfter(ANSIConstants.TAG_CLEAR_SCREEN_AFTER),
    ScreenBefore(ANSIConstants.TAG_CLEAR_SCREEN_BEFORE),
    Line(ANSIConstants.TAG_CLEAR_LINE),
    LineAfter(ANSIConstants.TAG_CLEAR_LINE_AFTER),
    LineBefore(ANSIConstants.TAG_CLEAR_LINE_BEFORE),
    ;

    private final String code;

    private ANSIClearAction(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
