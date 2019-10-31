package org.pcsoft.framework.jconsole.internal.natives;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import org.apache.commons.lang.SystemUtils;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class WinNativeTest {

    @Test
    public void setConsoleMode() {
        Assume.assumeTrue(SystemUtils.IS_OS_WINDOWS);

        final Pointer handle = WinNative.GetStdHandle(-10);
        WinNative.SetConsoleMode(handle, 0);
    }

    @Test
    public void getConsoleMode() {
        Assume.assumeTrue(SystemUtils.IS_OS_WINDOWS);

        final Pointer handle = WinNative.GetStdHandle(-10);
        final IntByReference mode = new IntByReference();
        WinNative.GetConsoleMode(handle, mode);
    }

    @Test
    public void getStdHandle() {
        Assume.assumeTrue(SystemUtils.IS_OS_WINDOWS);

        final Pointer handle = WinNative.GetStdHandle(-10);
        Assert.assertNotNull(handle);
        Assert.assertNotSame(Pointer.NULL, handle);
    }
}