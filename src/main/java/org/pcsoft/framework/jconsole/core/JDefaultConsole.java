package org.pcsoft.framework.jconsole.core;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import org.pcsoft.framework.jconsole.JConsole;
import org.pcsoft.framework.jconsole.JConsoleManipulator;
import org.pcsoft.framework.jconsole.JConsoleManipulatorFactory;
import org.pcsoft.framework.jconsole.exception.JConsoleException;
import org.pcsoft.framework.jconsole.type.JConsoleColor;
import org.pcsoft.framework.jconsole.type.JConsoleOutput;

import java.awt.*;
import java.io.*;

/**
 * Created by Christoph on 18.03.2016.
 */
public final class JDefaultConsole implements JConsole {
    private BufferedWriter standardOut = new BufferedWriter(new OutputStreamWriter(System.out)), errorOut = new BufferedWriter(new OutputStreamWriter(System.err));
    private BufferedReader standardIn = new BufferedReader(new InputStreamReader(System.in));
    private JConsoleManipulator consoleManipulator = JConsoleManipulatorFactory.getConsolePrinter(standardOut, errorOut);

    public BufferedWriter getStandardOut() {
        return standardOut;
    }

    @Override
    public void setStandardWriter(BufferedWriter standardOut) {
        this.standardOut = standardOut;
    }

    public BufferedWriter getErrorWriter() {
        return errorOut;
    }

    @Override
    public void setErrorWriter(BufferedWriter errorOut) {
        this.errorOut = errorOut;
    }

    public BufferedReader getStandardReader() {
        return standardIn;
    }

    public void setStandardReader(BufferedReader standardIn) {
        this.standardIn = standardIn;
    }

    public JConsoleManipulator getConsoleManipulator() {
        return consoleManipulator;
    }

    public void setConsoleManipulator(Class<? extends JConsoleManipulator> consoleManipulatorClass) {
        this.consoleManipulator = JConsoleManipulatorFactory.getConsolePrinter(consoleManipulatorClass, standardOut, errorOut);
    }

    @Override
    public void write(String str, JConsoleOutput output) throws JConsoleException {
        try {
            switch (output) {
                case Error:
                    errorOut.write(str);
                    errorOut.flush();
                    break;
                case Standard:
                    standardOut.write(str);
                    standardOut.flush();
                    break;
                default:
                    throw new RuntimeException();
            }
        } catch (IOException e) {
            throw new JConsoleException("Unable to write to console", e);
        }
    }

    @Override
    public void writeLine(String str, JConsoleOutput output) throws JConsoleException {
        try {
            switch (output) {
                case Error:
                    errorOut.write(str);
                    errorOut.newLine();
                    errorOut.flush();
                    break;
                case Standard:
                    standardOut.write(str);
                    standardOut.newLine();
                    standardOut.flush();
                    break;
                default:
                    throw new RuntimeException();
            }
        } catch (IOException e) {
            throw new JConsoleException("Unable to write to console", e);
        }
    }

    @Override
    public int read() throws JConsoleException {
        try {
            return standardIn.read();
        } catch (IOException e) {
            throw new JConsoleException("Unable to read from console", e);
        }
    }

    @Override
    public String readLine() throws JConsoleException {
        try {
            return standardIn.readLine();
        } catch (IOException e) {
            throw new JConsoleException("Unable to read from console", e);
        }
    }

    @Override
    public void gotoCaretPosition(int x, int y) throws JConsoleException {
        consoleManipulator.gotoCaretPosition(x, y);
    }

    @Override
    public void gotoCaretPosition(Point point) throws JConsoleException {
        consoleManipulator.gotoCaretPosition(point);
    }

    @Override
    public void moveCaretUp() throws JConsoleException {
        consoleManipulator.moveCaretUp();
    }

    @Override
    public void moveCaretUp(int count) throws JConsoleException {
        consoleManipulator.moveCaretUp(count);
    }

    @Override
    public void moveCaretDown() throws JConsoleException {
        consoleManipulator.moveCaretDown();
    }

    @Override
    public void moveCaretDown(int count) throws JConsoleException {
        consoleManipulator.moveCaretDown(count);
    }

    @Override
    public void moveCaretForward() throws JConsoleException {
        consoleManipulator.moveCaretForward();
    }

    @Override
    public void moveCaretForward(int count) throws JConsoleException {
        consoleManipulator.moveCaretForward(count);
    }

    @Override
    public void moveCaretBackward() throws JConsoleException {
        consoleManipulator.moveCaretBackward();
    }

    @Override
    public void moveCaretBackward(int count) throws JConsoleException {
        consoleManipulator.moveCaretBackward(count);
    }

    @Override
    public Point getCaretPosition() throws JConsoleException {
        return consoleManipulator.getCaretPosition();
    }

    @Override
    public void storeCaretPosition() throws JConsoleException {
        consoleManipulator.storeCaretPosition();
    }

    @Override
    public void restoreCaretPosition() throws JConsoleException {
        consoleManipulator.restoreCaretPosition();
    }

    @Override
    public void setForegroundColor(JConsoleColor color) throws JConsoleException {
        consoleManipulator.setForegroundColor(color);
    }

    @Override
    public void setBackgroundColor(JConsoleColor color) throws JConsoleException {
        consoleManipulator.setBackgroundColor(color);
    }

    @Override
    public void setColor(JConsoleColor foregroundColor, JConsoleColor backgroundColor) throws JConsoleException {
        consoleManipulator.setColor(foregroundColor, backgroundColor);
    }

    @Override
    public JConsoleColor getForegroundColor() throws JConsoleException {
        return consoleManipulator.getForegroundColor();
    }

    @Override
    public JConsoleColor getBackgroundColor() throws JConsoleException {
        return consoleManipulator.getBackgroundColor();
    }

    @Override
    public void resetForegroundColor() throws JConsoleException {
        consoleManipulator.resetForegroundColor();
    }

    @Override
    public void resetBackgroundColor() throws JConsoleException {
        consoleManipulator.resetBackgroundColor();
    }

    @Override
    public void resetColor() throws JConsoleException {
        consoleManipulator.resetColor();
    }

    @Override
    public void setCaretVisible(boolean flag) throws JConsoleException {
        consoleManipulator.setCaretVisible(flag);
    }

    @Override
    public BooleanProperty caretVisibleProperty() throws JConsoleException {
        return consoleManipulator.caretVisibleProperty();
    }

    @Override
    public boolean getCaretVisible() throws JConsoleException {
        return consoleManipulator.getCaretVisible();
    }

    @Override
    public ObjectProperty<JConsoleColor> foregroundColorProperty() {
        return consoleManipulator.foregroundColorProperty();
    }

    @Override
    public ObjectProperty<JConsoleColor> backgroundColorProperty() {
        return consoleManipulator.backgroundColorProperty();
    }

    @Override
    public void setBold(boolean bold) throws JConsoleException {
        consoleManipulator.setBold(bold);
    }

    @Override
    public BooleanProperty boldProperty() throws JConsoleException {
        return consoleManipulator.boldProperty();
    }

    @Override
    public boolean getBold() throws JConsoleException {
        return consoleManipulator.getBold();
    }

    @Override
    public void clearLine() throws JConsoleException {
        consoleManipulator.clearLine();
    }

    @Override
    public void clearLineAfterCaret() throws JConsoleException {
        consoleManipulator.clearLineAfterCaret();
    }

    @Override
    public void clearLineBeforeCaret() throws JConsoleException {
        consoleManipulator.clearLineBeforeCaret();
    }

    @Override
    public void clearLine(int line) throws JConsoleException {
        consoleManipulator.clearLine(line);
    }

    @Override
    public void clearLineAfterCaret(int x, int y) throws JConsoleException {
        consoleManipulator.clearLineAfterCaret(x, y);
    }

    @Override
    public void clearLineBeforeCaret(int x, int y) throws JConsoleException {
        consoleManipulator.clearLineBeforeCaret(x, y);
    }

    @Override
    public void clearScreen() throws JConsoleException {
        consoleManipulator.clearScreen();
    }

    @Override
    public void clearScreenAfter() throws JConsoleException {
        consoleManipulator.clearScreenAfter();
    }

    @Override
    public void clearScreenAfter(int x, int y) throws JConsoleException {
        consoleManipulator.clearScreenAfter(x, y);
    }

    @Override
    public void clearScreenAfter(int line) throws JConsoleException {
        consoleManipulator.clearScreenAfter(line);
    }

    @Override
    public void clearScreenBefore() throws JConsoleException {
        consoleManipulator.clearScreenBefore();
    }

    @Override
    public void clearScreenBefore(int x, int y) throws JConsoleException {
        consoleManipulator.clearScreenBefore(x, y);
    }

    @Override
    public void clearScreenBefore(int line) throws JConsoleException {
        consoleManipulator.clearScreenBefore(line);
    }
}
