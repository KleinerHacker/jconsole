package org.pcsoft.framework.jconsole.core;

import org.apache.commons.lang.SystemUtils;
import org.pcsoft.framework.jconsole.core.ansi.ANSICaretMoveAction;
import org.pcsoft.framework.jconsole.core.ansi.ANSICaretStoreAction;
import org.pcsoft.framework.jconsole.core.ansi.ANSIClearAction;
import org.pcsoft.framework.jconsole.core.ansi.ANSIUtils;
import org.pcsoft.framework.jconsole.exception.JConsoleException;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by Christoph on 18.03.2016.
 */
public final class JANSIConsoleManipulator extends JAbstractConsoleManipulatorEx {
    private BufferedWriter standardWriter, errorWriter;

    @Override
    public void gotoCaretPosition(int x, int y) throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getANSICaretHome(x, y));
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to change foreground color", e);
        }
    }

    @Override
    public Point getCaretPosition() throws JConsoleException {
        return null;
    }

    @Override
    public void storeCaretPosition() throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getANSICaretAction(ANSICaretStoreAction.StorePosition));
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to change foreground color", e);
        }
    }

    @Override
    public void restoreCaretPosition() throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getANSICaretAction(ANSICaretStoreAction.RestorePosition));
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to change foreground color", e);
        }
    }

    @Override
    protected void updateStyle() throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getANSIStyle(getBold(), getForegroundColor(), getBackgroundColor()));
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to change caret visibility", e);
        }
    }

    @Override
    protected void updateCaretVisible(boolean visible) throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getANSICaretVisible(visible));
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to change caret visibility", e);
        }
    }

    @Override
    public void moveCaretUp(int count) throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getANSICaretAction(ANSICaretMoveAction.MoveUp, count));
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to move caret up", e);
        }
    }

    @Override
    public void moveCaretDown(int count) throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getANSICaretAction(ANSICaretMoveAction.MoveDown, count));
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to move caret down", e);
        }
    }

    @Override
    public void moveCaretForward(int count) throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getANSICaretAction(ANSICaretMoveAction.MoveForward, count));
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to move caret forward", e);
        }
    }

    @Override
    public void moveCaretBackward(int count) throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getANSICaretAction(ANSICaretMoveAction.MoveBackward, count));
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to move caret backward", e);
        }
    }

    @Override
    public void clearScreen() throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getANSIClearAction(ANSIClearAction.Screen));
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to clear screen", e);
        }
    }

    @Override
    public void clearScreenAfter() throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getANSIClearAction(ANSIClearAction.ScreenAfter));
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to clear screen after caret", e);
        }
    }

    @Override
    public void clearScreenBefore() throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getANSIClearAction(ANSIClearAction.ScreenBefore));
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to clear screen before caret", e);
        }
    }

    @Override
    public void clearLine() throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getANSIClearAction(ANSIClearAction.Line));
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to clear line", e);
        }
    }

    @Override
    public void clearLineAfterCaret() throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getANSIClearAction(ANSIClearAction.LineAfter));
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to clear line after caret", e);
        }
    }

    @Override
    public void clearLineBeforeCaret() throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getANSIClearAction(ANSIClearAction.LineBefore));
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to clear line before caret", e);
        }
    }

    public BufferedWriter getStandardWriter() {
        return standardWriter;
    }

    @Override
    public void setStandardWriter(BufferedWriter standardWriter) {
        this.standardWriter = standardWriter;
    }

    public BufferedWriter getErrorWriter() {
        return errorWriter;
    }

    @Override
    public void setErrorWriter(BufferedWriter errorWriter) {
        this.errorWriter = errorWriter;
    }

    @Override
    public boolean fitForCurrentOS() {
        return SystemUtils.IS_OS_UNIX;
    }
}
