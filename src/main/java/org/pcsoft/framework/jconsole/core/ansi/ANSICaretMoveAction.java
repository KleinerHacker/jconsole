package org.pcsoft.framework.jconsole.core.ansi;

/**
 * Created by Christoph on 18.04.2016.
 */
public enum ANSICaretMoveAction implements ANSIAction {
    MoveUp(ANSIConstants.TAG_CARET_MOVE_UP),
    MoveDown(ANSIConstants.TAG_CARET_MOVE_DOWN),
    MoveForward(ANSIConstants.TAG_CARET_MOVE_FORWARD),
    MoveBackward(ANSIConstants.TAG_CARET_MOVE_BACKWARD),
    ;

    private final String code;

    private ANSICaretMoveAction(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
