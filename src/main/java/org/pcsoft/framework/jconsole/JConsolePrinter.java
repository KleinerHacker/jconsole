package org.pcsoft.framework.jconsole;

import org.pcsoft.framework.jconsole.exception.JConsoleException;
import org.pcsoft.framework.jconsole.type.JConsoleOutput;

/**
 * Created by Christoph on 18.03.2016.
 */
public interface JConsolePrinter {
    void write(String str, JConsoleOutput output) throws JConsoleException;
    default void write(String str) throws JConsoleException {
        write(str, JConsoleOutput.Standard);
    }
    void writeLine(String str, JConsoleOutput output) throws JConsoleException;
    default void writeLine(String str) throws JConsoleException {
        writeLine(str, JConsoleOutput.Standard);
    }
    int read() throws JConsoleException;
    String readLine() throws JConsoleException;
}
