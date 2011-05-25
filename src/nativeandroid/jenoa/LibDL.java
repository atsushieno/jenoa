package nativeandroid.jenoa;

class LibDL {
	static {
		System.loadLibrary ("jenoa");
		init_libdl ();
	}
	
	public LibDL ()
	{
		init_libdl ();
	}
	
	public void finalize ()
	{
		cleanup_libdl ();
	}

	public static final int RTLD_LAZY = 1;
	public static final int RTLD_NOW = 2;
	public static final int RTLD_BINDING_MASK = 3;
	public static final int RTLD_NOLOAD = 4;
	public static final int RTLD_DEEPBIND = 8;
	public static final int RTLD_NODELETE = 0x1000;

	static native void init_libdl ();
	static native void cleanup_libdl ();
	native long dlopen (String file, int mode);
	native String dlerror ();
	native int dlclose (long handle);
	native long dlsym (long handle, String name);
}
