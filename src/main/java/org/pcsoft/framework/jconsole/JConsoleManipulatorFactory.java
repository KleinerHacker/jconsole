package org.pcsoft.framework.jconsole;

import org.apache.commons.lang.SystemUtils;
import org.pcsoft.framework.jconsole.core.JANSIConsoleManipulator;
import org.pcsoft.framework.jconsole.core.JWindowsConsoleManipulator;
import org.pcsoft.framework.jconsole.exception.JConsoleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Christoph on 18.03.2016.
 */
public final class JConsoleManipulatorFactory {
    private static final Logger LOG = LoggerFactory.getLogger(JConsoleManipulatorFactory.class);

    private static final Map<Class<? extends JConsoleManipulatorEx>, JConsoleManipulatorEx> CONSOLE_PRINTER_MAP = new HashMap<>();

    static {
        registerConsolePrinter(JWindowsConsoleManipulator.class);
        registerConsolePrinter(JANSIConsoleManipulator.class);
    }

    public static void registerConsolePrinter(Class<? extends JConsoleManipulatorEx> consolePrinter) throws JConsoleException {
        try {
            CONSOLE_PRINTER_MAP.put(consolePrinter, consolePrinter.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            throw new JConsoleException("Unable to instantiate printer: " + consolePrinter.getName(), e);
        }
    }

    public static void unregisterConsolePrinter(Class<? extends JConsoleManipulatorEx> consolePrinter) {
        CONSOLE_PRINTER_MAP.remove(consolePrinter);
    }

    public static JConsoleManipulator getConsolePrinter(BufferedWriter standardWriter, BufferedWriter errorWriter) throws JConsoleException {
        final List<? extends JConsoleManipulatorEx> consoleManipulators = CONSOLE_PRINTER_MAP.values().parallelStream()
                .filter(JConsoleManipulatorEx::fitForCurrentOS)
                .collect(Collectors.toList());
        if (consoleManipulators.isEmpty())
            throw new JConsoleException("Unable to find a fit console printer for OS " + SystemUtils.OS_NAME + ", " + SystemUtils.OS_VERSION);

        final JConsoleManipulatorEx consoleManipulator = consoleManipulators.stream().findFirst().get();
        consoleManipulator.setStandardWriter(standardWriter);
        consoleManipulator.setErrorWriter(errorWriter);
        return consoleManipulator;
    }

    public static JConsoleManipulator getConsolePrinter(Class<? extends JConsoleManipulator> manipulatorClass, BufferedWriter standardWriter, BufferedWriter errorWriter) throws JConsoleException {
        final JConsoleManipulatorEx consoleManipulator = CONSOLE_PRINTER_MAP.get(manipulatorClass);
        if (consoleManipulator == null)
            throw new JConsoleException("Unable to find registered console manipulator: " + manipulatorClass.getName());
        if (!consoleManipulator.fitForCurrentOS()) {
            LOG.warn("This console manipulator is not supported for current OS: " + manipulatorClass.getName());
        }

        consoleManipulator.setStandardWriter(standardWriter);
        consoleManipulator.setErrorWriter(errorWriter);
        return consoleManipulator;
    }

    private JConsoleManipulatorFactory() {
    }
}
