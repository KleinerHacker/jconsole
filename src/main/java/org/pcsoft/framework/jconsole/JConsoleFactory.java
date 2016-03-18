package org.pcsoft.framework.jconsole;

import org.pcsoft.framework.jconsole.core.JDefaultConsole;
import org.pcsoft.framework.jconsole.exception.JConsoleException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Christoph on 18.03.2016.
 */
public final class JConsoleFactory {
    private static final Map<Class<? extends JConsole>, JConsole> CONSOLE_MAP = new HashMap<>();

    static {
        registerConsole(JDefaultConsole.class);
    }

    public static void registerConsole(Class<? extends JConsole> consoleClass) throws JConsoleException {
        try {
            CONSOLE_MAP.put(consoleClass, consoleClass.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            throw new JConsoleException("Unable to instantiate console " + consoleClass.getName(), e);
        }
    }

    public static void unregisterConsole(Class<? extends JConsole> consoleClass) {
        CONSOLE_MAP.remove(consoleClass);
    }

    public static JConsole getDefaultConsole() {
        return getConsole(JDefaultConsole.class);
    }

    public static JConsole getConsole(Class<? extends JConsole> consoleClass) {
        return CONSOLE_MAP.get(consoleClass);
    }

    private JConsoleFactory() {
    }
}
