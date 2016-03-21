package org.pcsoft.framework.jconsole.core;

import org.apache.commons.lang.SystemUtils;
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

    }

    @Override
    public void resetCaretPosition() throws JConsoleException {

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
