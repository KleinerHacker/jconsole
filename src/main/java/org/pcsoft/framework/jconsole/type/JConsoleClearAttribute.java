package org.pcsoft.framework.jconsole.type;

public enum JConsoleClearAttribute {
    BeforeCursor(1),
    AfterCursor(0),
    All(2);

    private final int code;

    JConsoleClearAttribute(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
