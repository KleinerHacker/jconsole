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
    public void restoreCaretPosition() throws JConsoleException {

    }

    @Override
    protected void updateStyle() throws JConsoleException {

    }

    @Override
    protected void updateCaretVisible(boolean visible) throws JConsoleException {

    }

    @Override
    public void moveCaretUp(int count) throws JConsoleException {

    }

    @Override
    public void moveCaretDown(int count) throws JConsoleException {

    }

    @Override
    public void moveCaretForward(int count) throws JConsoleException {

    }

    @Override
    public void moveCaretBackward(int count) throws JConsoleException {

    }

    @Override
    public void clearScreen() throws JConsoleException {

    }

    @Override
    public void clearScreenAfter() throws JConsoleException {

    }

    @Override
    public void clearScreenBefore() throws JConsoleException {

    }

    @Override
    public void clearLine() throws JConsoleException {

    }

    @Override
    public void clearLineAfterCaret() throws JConsoleException {

    }

    @Override
    public void clearLineBeforeCaret() throws JConsoleException {

    }

    @Override
    public void clearCharacter(int count) throws JConsoleException {

    }

    @Override
    public void insertSpace(int count) throws JConsoleException {

    }

    @Override
    public void deleteCharacter(int count) throws JConsoleException {

    }

    @Override
    public void insertLine(int count) throws JConsoleException {

    }

    @Override
    public void deleteLine(int count) throws JConsoleException {

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
