package nativeandroid.jenoa;

class LibDL {
	static {
		System.loadLibrary ("jenoa");
	}
	
	long dyncall_handle;
	
	public LibDL ()
	{
		init_libdl ();
		dyncall_handle = init_dyncall ();
	}
	
	public void finalize ()
	{
		cleanup_libdl ();
		if (dyncall_handle != 0)
			cleanup_dyncall (dyncall_handle);
	}
	
	// sample
	public static void main (String [] args)
	{
		new LibDL ().run ();
	}
	
	void run ()
	{
		long dlptr = dlopen ("libc.so.6", RTLD_LAZY);
		if (dlptr != 0) {
			long funcptr = dlsym (dlptr, "isalpha");
			System.out.printf ("%d %d\n", dlptr, funcptr);
			int ret = invokeInt (funcptr, dyncall_handle, 0x30);
			System.out.printf ("RESULT: %d", ret);
			dlclose (dlptr);
		} else {
			System.out.printf ("dlerror: %s\n", dlerror ());
		}
	}
	
	public static final int RTLD_LAZY = 1;
	public static final int RTLD_NOW = 2;
	public static final int RTLD_BINDING_MASK = 3;
	public static final int RTLD_NOLOAD = 4;
	public static final int RTLD_DEEPBIND = 8;
	public static final int RTLD_NODELETE = 0x1000;

	native void init_libdl ();
	native void cleanup_libdl ();
	native long init_dyncall ();
	native void cleanup_dyncall (long handle);
	native long dlopen (String file, int mode);
	native String dlerror ();
	native int dlclose (long handle);
	native long dlsym (long handle, String name);

	native boolean invokeBoolean (long handle, long dcHandle, Object... params);
	native byte invokeByte (long handle, long dcHandle, Object... params);
	native short invokeShort (long handle, long dcHandle, Object... params);
	native int invokeInt (long handle, long dcHandle, Object... params);
	native long invokeLong (long handle, long dcHandle, Object... params);
	native float invokeFloat (long handle, long dcHandle, Object... params);
	native double invokeDouble (long handle, long dcHandle, Object... params);
	native void invokeVoid (long handle, long dcHandle, Object... params);
	native long invokePointer (long handle, long dcHandle, Object... params);
}
