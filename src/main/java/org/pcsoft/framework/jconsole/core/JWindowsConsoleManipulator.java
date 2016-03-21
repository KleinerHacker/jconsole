package org.pcsoft.framework.jconsole.core;

import org.apache.commons.lang.SystemUtils;
import org.pcsoft.framework.jconsole.exception.JConsoleException;

import java.awt.*;
import java.io.BufferedWriter;

/**
 * Created by Christoph on 18.03.2016.
 */
public final class JWindowsConsoleManipulator extends JAbstractConsoleManipulatorEx {
    private BufferedWriter standardWriter, errorWriter;

    @Override
    public void gotoCaretPosition(int x, int y) throws JConsoleException {

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

    }

    @Override
    protected void updateCaretVisible(boolean visible) throws JConsoleException {

    }

    @Override
    public boolean fitForCurrentOS() {
        return SystemUtils.IS_OS_WINDOWS;
    }

    @Override
    public void setErrorWriter(BufferedWriter writer) {
        this.errorWriter = writer;
    }

    @Override
    public void setStandardWriter(BufferedWriter writer) {
        this.standardWriter = writer;
    }

    public BufferedWriter getStandardWriter() {
        return standardWriter;
    }

    public BufferedWriter getErrorWriter() {
        return errorWriter;
    }
}
