package org.pcsoft.framework.jconsole.core.ansi;

/**
 * Created by Christoph on 18.04.2016.
 */
public enum ANSICaretStoreAction implements ANSIAction {
    StorePosition(ANSIConstants.TAG_CARET_STORE),
    RestorePosition(ANSIConstants.TAG_CARET_RESTORE),
    ;

    private final String code;

    private ANSICaretStoreAction(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
