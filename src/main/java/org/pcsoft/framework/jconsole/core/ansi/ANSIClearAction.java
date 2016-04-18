package org.pcsoft.framework.jconsole.core.ansi;

/**
 * Created by Christoph on 18.04.2016.
 */
public enum ANSIClearAction implements ANSIAction {
    Screen(ANSIConstants.TAG_MODIFY_CLEAR_SCREEN, false),
    ScreenAfter(ANSIConstants.TAG_MODIFY_CLEAR_SCREEN_AFTER, false),
    ScreenBefore(ANSIConstants.TAG_MODIFY_CLEAR_SCREEN_BEFORE, false),
    Line(ANSIConstants.TAG_MODIFY_CLEAR_LINE, false),
    LineAfter(ANSIConstants.TAG_MODIFY_CLEAR_LINE_AFTER, false),
    LineBefore(ANSIConstants.TAG_MODIFY_CLEAR_LINE_BEFORE, false),
    Character(ANSIConstants.TAG_MODIFY_CLEAR_CHARACTER, false),
    ;

    private final String code;
    private final boolean needsCount;

    private ANSIClearAction(String code, boolean needsCount) {
        this.code = code;
        this.needsCount = needsCount;
    }

    @Override
    public String getCode() {
        return code;
    }

    public boolean isNeedsCount() {
        return needsCount;
    }
}
