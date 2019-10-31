package org.pcsoft.framework.jconsole.internal.natives;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

class WinNative {
    private static final NativeLibrary JNA_NATIVE_LIB;

    static {
        JNA_NATIVE_LIB = NativeLibrary.getInstance("kernel32");
        Native.register(WinNative.class, JNA_NATIVE_LIB);
    }

    public static native boolean SetConsoleMode(Pointer handle, int mode);

    public static native boolean GetConsoleMode(Pointer handle, IntByReference mode);

    public static native Pointer GetStdHandle(int handle);
}
