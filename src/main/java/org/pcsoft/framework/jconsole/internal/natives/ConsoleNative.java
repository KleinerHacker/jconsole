package org.pcsoft.framework.jconsole.internal.natives;

import com.sun.jna.Pointer;
import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.SystemUtils;
import org.pcsoft.framework.jconsole.type.JConsoleInputMode;

public final class ConsoleNative {
    public static void setInputMode(JConsoleInputMode inputMode) {
        if (SystemUtils.IS_OS_WINDOWS) {
            final Pointer pointer = WinNative.GetStdHandle(-10);

            switch (inputMode) {
                case Default:
                    if (!WinNative.SetConsoleMode(pointer, 0x0004 | 0x0002))
                        throw new IllegalStateException("Unable to change to default input mode");
                    break;
                case Direct:
                    if (!WinNative.SetConsoleMode(pointer, 0))
                        throw new IllegalStateException("Unable to change to direct input mode");
                    break;
                default:
                    throw new NotImplementedException();
            }
        } else if (SystemUtils.IS_OS_UNIX) {
            //TODO
        } else
            throw new NotImplementedException("Not supported OS: " + SystemUtils.OS_NAME);
    }

    public static void resetInputMode() {
        if (SystemUtils.IS_OS_WINDOWS) {
            final Pointer pointer = WinNative.GetStdHandle(-10);
            WinNative.SetConsoleMode(pointer, 0x0004 | 0x0002);
        } else if (SystemUtils.IS_OS_UNIX) {
            //TODO
        } else
            throw new NotImplementedException("Not supported OS: " + SystemUtils.OS_NAME);
    }

    public static void initConsole() {
        if (SystemUtils.IS_OS_WINDOWS) {
            final Pointer pointer = WinNative.GetStdHandle(-11);

            if (!WinNative.SetConsoleMode(pointer, 0x0001 | 0x0002 | 0x0004))
                throw new IllegalStateException("Unable to initialize console");
        } else if (SystemUtils.IS_OS_UNIX) {
            //TODO
        } else
            throw new NotImplementedException("Not supported OS: " + SystemUtils.OS_NAME);
    }

    private ConsoleNative() {
    }
}
