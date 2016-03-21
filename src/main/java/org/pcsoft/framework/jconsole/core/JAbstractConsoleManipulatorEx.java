package org.pcsoft.framework.jconsole.core;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.pcsoft.framework.jconsole.JConsoleManipulatorEx;
import org.pcsoft.framework.jconsole.exception.JConsoleException;
import org.pcsoft.framework.jconsole.type.JConsoleColor;

/**
 * Created by Christoph on 21.03.2016.
 */
public abstract class JAbstractConsoleManipulatorEx implements JConsoleManipulatorEx {
    private final ObjectProperty<JConsoleColor> foregroundColor = new SimpleObjectProperty<>(JConsoleColor.Default);
    private final ObjectProperty<JConsoleColor> backgroundColor = new SimpleObjectProperty<>(JConsoleColor.Default);
    private final BooleanProperty bold = new SimpleBooleanProperty(false);
    private final BooleanProperty caretVisible = new SimpleBooleanProperty(true);

    protected JAbstractConsoleManipulatorEx() {
        bold.addListener(o -> updateStyle());
        foregroundColor.addListener(o -> updateStyle());
        backgroundColor.addListener(o -> updateStyle());
        caretVisible.addListener(o -> updateCaretVisible(caretVisible.get()));
    }

    @Override
    public final JConsoleColor getForegroundColor() {
        return foregroundColor.get();
    }

    @Override
    public final ObjectProperty<JConsoleColor> foregroundColorProperty() {
        return foregroundColor;
    }

    @Override
    public final void setForegroundColor(JConsoleColor foregroundColor) {
        this.foregroundColor.set(foregroundColor);
    }

    @Override
    public final void resetForegroundColor() throws JConsoleException {
        this.setForegroundColor(JConsoleColor.Default);
    }

    @Override
    public final JConsoleColor getBackgroundColor() {
        return backgroundColor.get();
    }

    @Override
    public final ObjectProperty<JConsoleColor> backgroundColorProperty() {
        return backgroundColor;
    }

    @Override
    public final void setBackgroundColor(JConsoleColor backgroundColor) {
        this.backgroundColor.set(backgroundColor);
    }

    @Override
    public final void resetBackgroundColor() throws JConsoleException {
        this.setBackgroundColor(JConsoleColor.Default);
    }

    @Override
    public final boolean getCaretVisible() {
        return caretVisible.get();
    }

    @Override
    public final BooleanProperty caretVisibleProperty() {
        return caretVisible;
    }

    @Override
    public final void setCaretVisible(boolean caretVisible) {
        this.caretVisible.set(caretVisible);
    }

    @Override
    public final boolean getBold() {
        return bold.get();
    }

    @Override
    public final BooleanProperty boldProperty() {
        return bold;
    }

    @Override
    public final void setBold(boolean bold) {
        this.bold.set(bold);
    }

    protected abstract void updateStyle() throws JConsoleException;
    protected abstract void updateCaretVisible(boolean visible) throws JConsoleException;
}
