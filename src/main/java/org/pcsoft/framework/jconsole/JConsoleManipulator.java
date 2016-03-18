package org.pcsoft.framework.jconsole;

import org.pcsoft.framework.jconsole.exception.JConsoleException;
import org.pcsoft.framework.jconsole.type.JConsoleColor;

import java.awt.*;
import java.io.BufferedWriter;

/**
 * Created by Christoph on 18.03.2016.
 */
public interface JConsoleManipulator {
    void setErrorWriter(BufferedWriter writer);
    void setStandardWriter(BufferedWriter writer);

    void gotoCaretPosition(int x, int y) throws JConsoleException;
    default void gotoCaretPosition(Point point) throws JConsoleException {
        gotoCaretPosition(point.x, point.y);
    }
    Point getCaretPosition() throws JConsoleException;
    void storeCaretPosition() throws JConsoleException;
    void resetCaretPosition() throws JConsoleException;

    void setForegroundColor(JConsoleColor color) throws JConsoleException;
    void setBackgroundColor(JConsoleColor color) throws JConsoleException;
    default void setColor(JConsoleColor foregroundColor, JConsoleColor backgroundColor) throws JConsoleException {
        setForegroundColor(foregroundColor);
        setBackgroundColor(backgroundColor);
    }
    JConsoleColor getForegroundColor() throws JConsoleException;
    JConsoleColor getBackgroundColor() throws JConsoleException;
    void resetForegroundColor() throws JConsoleException;
    void resetBackgroundColor() throws JConsoleException;
    default void resertColor() throws JConsoleException {
        resetForegroundColor();
        resetBackgroundColor();
    }
}
