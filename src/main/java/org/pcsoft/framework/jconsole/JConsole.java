package org.pcsoft.framework.jconsole;

/**
 * Created by Christoph on 18.03.2016.
 */
public interface JConsole extends JConsoleManipulator, JConsolePrinter {
    void setConsoleManipulator(Class<? extends JConsoleManipulator> consoleManipulatorClass);

}
