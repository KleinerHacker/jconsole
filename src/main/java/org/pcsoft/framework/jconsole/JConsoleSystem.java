package org.pcsoft.framework.jconsole;

import org.apache.commons.lang.NotImplementedException;
import org.pcsoft.framework.jconsole.type.JConsoleWidth;

public final class JConsoleSystem {
    private String windowTitle = "";
    private JConsoleWidth width = JConsoleWidth.Default;

    public String getWindowTitle() {
        return windowTitle;
    }

    public void setWindowTitle(String windowTitle) {
        this.windowTitle = windowTitle;
        JConsole.printAnsiSpecial("2;" + windowTitle + "BEL");
    }

    public JConsoleWidth getWidth() {
        return width;
    }

    public void setWidth(JConsoleWidth width) {
        this.width = width;
        switch (width) {
            case Default:
                JConsole.printAnsi("?3l");
                break;
            case Big:
                JConsole.printAnsi("?3h");
                break;
            default:
                throw new NotImplementedException();
        }
    }

    JConsoleSystem() {
    }
}
