package org.pcsoft.framework.jconsole.core.ansi;

/**
 * Created by Christoph on 18.04.2016.
 */
public enum ANSIModifyAction implements ANSIAction {
    InsertSpace(ANSIConstants.TAG_MODIFY_INSERT_CHARACTER),
    DeleteCharacter(ANSIConstants.TAG_MODIFY_DELETE_CHARACTER),
    InsertLine(ANSIConstants.TAG_MODIFY_INSERT_LINE),
    DeleteLine(ANSIConstants.TAG_MODIFY_DELETE_LINE),
    ;

    private final String code;

    private ANSIModifyAction(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
