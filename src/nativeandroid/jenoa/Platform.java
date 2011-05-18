package nativeandroid.jenoa;

public final class Platform {
	public static final int UNSPECIFIED = -1;
	public static final int MAC = 0;
	public static final int LINUX = 1;
	public static final int WINDOWS = 2;
	public static final int SOLARIS = 3;
	public static final int FREEBSD = 4;
	public static final int OPENBSD = 5;
	public static final int WINDOWSCE = 6;
	
	public static final int getOSType()
	{
		throw new UnsupportedOperationException();
	}
	
	public static final boolean isMac()
	{
		throw new UnsupportedOperationException();
	}
	
	public static final boolean isLinux()
	{
		throw new UnsupportedOperationException();
	}
	
	public static final boolean isWindowsCE()
	{
		throw new UnsupportedOperationException();
	}
	
	public static final boolean isWindows()
	{
		throw new UnsupportedOperationException();
	}
	
	public static final boolean isSolaris()
	{
		throw new UnsupportedOperationException();
	}
	
	public static final boolean isFreeBSD()
	{
		throw new UnsupportedOperationException();
	}
	
	public static final boolean isOpenBSD()
	{
		throw new UnsupportedOperationException();
	}
	
	public static final boolean isX11()
	{
		throw new UnsupportedOperationException();
	}
	
	public static final boolean deleteNativeLibraryAfterVMExit()
	{
		throw new UnsupportedOperationException();
	}
	
	public static final boolean hasRuntimeExec()
	{
		throw new UnsupportedOperationException();
	}
	
	public static final boolean is64Bit()
	{
		throw new UnsupportedOperationException();
	}
}
