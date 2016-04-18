package org.pcsoft.framework.jconsole;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
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
    void restoreCaretPosition() throws JConsoleException;
    void setCaretVisible(boolean flag) throws JConsoleException;
    BooleanProperty caretVisibleProperty() throws JConsoleException;
    boolean getCaretVisible() throws JConsoleException;
    default void moveCaretUp() throws JConsoleException {
        moveCaretUp(1);
    }
    void moveCaretUp(int count) throws JConsoleException;
    default void moveCaretDown() throws JConsoleException {
        moveCaretDown(1);
    }
    void moveCaretDown(int count) throws JConsoleException;
    default void moveCaretForward() throws JConsoleException {
        moveCaretForward(1);
    }
    void moveCaretForward(int count) throws JConsoleException;
    default void moveCaretBackward() throws JConsoleException {
        moveCaretBackward(1);
    }
    void moveCaretBackward(int count) throws JConsoleException;

    void setForegroundColor(JConsoleColor color) throws JConsoleException;
    void setBackgroundColor(JConsoleColor color) throws JConsoleException;
    default void setColor(JConsoleColor foregroundColor, JConsoleColor backgroundColor) throws JConsoleException {
        setForegroundColor(foregroundColor);
        setBackgroundColor(backgroundColor);
    }
    ObjectProperty<JConsoleColor> foregroundColorProperty();
    ObjectProperty<JConsoleColor> backgroundColorProperty();
    JConsoleColor getForegroundColor() throws JConsoleException;
    JConsoleColor getBackgroundColor() throws JConsoleException;
    void resetForegroundColor() throws JConsoleException;
    void resetBackgroundColor() throws JConsoleException;
    default void resetColor() throws JConsoleException {
        resetForegroundColor();
        resetBackgroundColor();
    }

    void clearScreen() throws JConsoleException;
    void clearScreenAfter() throws JConsoleException;
    default void clearScreenAfter(int x, int y) throws JConsoleException {
        storeCaretPosition();
        try {
            gotoCaretPosition(x, y);
            clearScreenAfter();
        } finally {
            restoreCaretPosition();
        }
    }
    default void clearScreenAfter(int line) throws JConsoleException {
        clearScreenAfter(0, line);
    }
    void clearScreenBefore() throws JConsoleException;
    default void clearScreenBefore(int x, int y) throws JConsoleException {
        storeCaretPosition();
        try {
            gotoCaretPosition(x, y);
            clearScreenBefore();
        } finally {
            restoreCaretPosition();
        }
    }
    default void clearScreenBefore(int line) throws JConsoleException {
        clearScreenBefore(0, line);
    }
    void clearLine() throws JConsoleException;
    default void clearLine(int line) throws JConsoleException {
        storeCaretPosition();
        try {
            gotoCaretPosition(0, line);
            clearLine();
        } finally {
            restoreCaretPosition();
        }
    }
    void clearLineAfterCaret() throws JConsoleException;
    default void clearLineAfterCaret(int x, int y) throws JConsoleException {
        storeCaretPosition();
        try {
            gotoCaretPosition(x, y);
            clearLineAfterCaret();
        } finally {
            restoreCaretPosition();
        }
    }
    void clearLineBeforeCaret() throws JConsoleException;
    default void clearLineBeforeCaret(int x, int y) throws JConsoleException {
        storeCaretPosition();
        try {
            gotoCaretPosition(x, y);
            clearLineBeforeCaret();
        } finally {
            restoreCaretPosition();
        }
    }
    void clearCharacter(int count) throws JConsoleException;
    default void clearCharacter() throws JConsoleException {
        clearCharacter(1);
    }
    default void clearCharacterAt(int x, int y, int count) throws JConsoleException {
        storeCaretPosition();
        try {
            gotoCaretPosition(x, y);
            clearCharacter(count);
        } finally {
            restoreCaretPosition();
        }
    }
    default void clearCharacterAt(int x, int y) throws JConsoleException {
        clearCharacterAt(x, y, 1);
    }

    void insertSpace(int count) throws JConsoleException;
    default void insertSpace() throws JConsoleException {
        insertSpace(1);
    }
    default void insertSpaceAt(int x, int y, int count) throws JConsoleException {
        storeCaretPosition();
        try {
            gotoCaretPosition(x, y);
            insertSpace(count);
        } finally {
            restoreCaretPosition();
        }
    }
    default void insertSpaceAt(int x, int y) throws JConsoleException {
        insertSpaceAt(x, y, 1);
    }
    void deleteCharacter(int count) throws JConsoleException;
    default void deleteCharacter() throws JConsoleException {
        deleteCharacter(1);
    }
    default void deleteCharacterAt(int x, int y, int count) throws JConsoleException {
        storeCaretPosition();
        try {
            gotoCaretPosition(x, y);
            deleteCharacter(count);
        } finally {
            restoreCaretPosition();
        }
    }
    default void deleteCharacterAt(int x, int y) throws JConsoleException {
        deleteCharacterAt(x, y, 1);
    }
    void insertLine(int count) throws JConsoleException;
    default void insertLine() throws JConsoleException {
        insertLine(1);
    }
    default void insertLineAt(int line, int count) throws JConsoleException {
        storeCaretPosition();
        try {
            gotoCaretPosition(0, line);
            insertLine(count);
        } finally {
            restoreCaretPosition();
        }
    }
    default void insertLineAt(int line) throws JConsoleException {
        insertLineAt(line, 1);
    }
    void deleteLine(int count) throws JConsoleException;
    default void deleteLine() throws JConsoleException {
        deleteLine(1);
    }
    default void deleteLineAt(int line, int count) throws JConsoleException {
        storeCaretPosition();
        try {
            gotoCaretPosition(0, line);
            deleteLine(count);
        } finally {
            restoreCaretPosition();
        }
    }
    default void deleteLineAt(int line) throws JConsoleException {
        deleteLineAt(line, 1);
    }

    void setBold(boolean bold) throws JConsoleException;
    BooleanProperty boldProperty() throws JConsoleException;
    boolean getBold() throws JConsoleException;
}
