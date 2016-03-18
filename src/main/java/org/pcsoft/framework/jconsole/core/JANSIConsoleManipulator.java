package org.pcsoft.framework.jconsole.core;

import org.apache.commons.lang.SystemUtils;
import org.pcsoft.framework.jconsole.JConsoleManipulatorEx;
import org.pcsoft.framework.jconsole.core.ansi.ANSIUtils;
import org.pcsoft.framework.jconsole.exception.JConsoleException;
import org.pcsoft.framework.jconsole.type.JConsoleColor;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by Christoph on 18.03.2016.
 */
public final class JANSIConsoleManipulator implements JConsoleManipulatorEx {
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
    public void setForegroundColor(JConsoleColor color) throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getForegroundANSIColor(color));
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to change foreground color", e);
        }
    }

    @Override
    public void setBackgroundColor(JConsoleColor color) throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getBackgroundANSIColor(color));
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to change background color", e);
        }
    }

    @Override
    public JConsoleColor getForegroundColor() throws JConsoleException {
        return null;
    }

    @Override
    public JConsoleColor getBackgroundColor() throws JConsoleException {
        return null;
    }

    @Override
    public void resetForegroundColor() throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getResetForegroundANSIColor());
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to reset foreground color", e);
        }
    }

    @Override
    public void resetBackgroundColor() throws JConsoleException {
        try {
            standardWriter.write(ANSIUtils.getResetBackgroundANSIColor());
            standardWriter.flush();
        } catch (IOException e) {
            throw new JConsoleException("Unable to reset background color", e);
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
