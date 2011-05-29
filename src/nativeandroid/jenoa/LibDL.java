package nativeandroid.jenoa;

class LibDL {
	static {
		System.loadLibrary ("jenoa");
	}
	
	static LibDL instance;
	
	public static LibDL getInstance ()
	{
		if (instance == null)
			instance = new LibDL ();
		return instance;
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
	
	Object invoke (long handle, Class returnType, Object... params)
	{
		if (returnType.equals(boolean.class))
			return invokeBoolean (handle, params);
		if (returnType.equals(byte.class))
			return invokeByte (handle, params);
		if (returnType.equals(short.class))
			return invokeShort(handle, params);
		if (returnType.equals(int.class))
			return invokeInt (handle, params);
		if (returnType.equals(long.class))
			return invokeLong (handle, params);
		if (returnType.equals(float.class))
			return invokeFloat (handle, params);
		if (returnType.equals(double.class))
			return invokeDouble (handle, params);
		if (returnType.equals(void.class)) {
			invokeVoid (handle, params);
			return null;
		}
		throw new UnsupportedOperationException (String.format ("Class %s is not supported", returnType.getName()));
	}

	boolean invokeBoolean (long handle, Object... params)
	{
		return invokeBoolean (handle, dyncall_handle, params);
	}
	byte invokeByte (long handle, Object... params)
	{
		return invokeByte(handle, dyncall_handle, params);
	}
	short invokeShort (long handle, Object... params)
	{
		return invokeShort (handle, dyncall_handle, params);
	}
	int invokeInt (long handle, Object... params)
	{
		return invokeInt (handle, dyncall_handle, params);
	}
	long invokeLong (long handle, Object... params)
	{
		return invokeLong (handle, dyncall_handle, params);
	}
	float invokeFloat (long handle, Object... params)
	{
		return invokeFloat (handle, dyncall_handle, params);
	}
	double invokeDouble (long handle, Object... params)
	{
		return invokeDouble (handle, dyncall_handle, params);
	}
	void invokeVoid (long handle, Object... params)
	{
		invokeVoid (handle, dyncall_handle, params);
	}
	long invokePointer (long handle, Object... params)
	{
		return invokePointer (handle, dyncall_handle, params);
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
