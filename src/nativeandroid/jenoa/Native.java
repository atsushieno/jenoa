package nativeandroid.jenoa;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;

public class Native {
	public static class DeleteNativeLibrary extends Thread {
		public DeleteNativeLibrary(File file)
		{
			throw new UnsupportedOperationException();
		}
		
		public void run()
		{
			throw new UnsupportedOperationException();
		}
		
		public static void main(String[] args)
		{
			throw new UnsupportedOperationException();
		}
	}
	
	/*
	public static interface ffi_callback {
		void invoke(long cif, long resp, long argp);
	}
	*/
	
	static native int getPointerSize();
	static native int getLongSize();
	static native int getWCharSize();
	static native int getSizeTSize();
	
	public static final int POINTER_SIZE = getPointerSize();
	public static final int LONG_SIZE = getLongSize();
	public static final int WCHAR_SIZE = getWCharSize();
	public static final int SIZE_T_SIZE = getSizeTSize();
	
	static boolean is_protected;
	static boolean preserve_last_error;
	
	public static void setProtected(boolean enable)
	{
		is_protected = enable;
	}
	
	public static boolean isProtected()
	{
		return is_protected;
	}
	
	public static void setPreserveLastError(boolean enable)
	{
		preserve_last_error = enable;
	}
	
	public static boolean getPreserveLastError()
	{
		return preserve_last_error;
	}
	
	/*
	public static long getWindowID(Window w)
		throws HeadlessException
    {
    }
	
	public static long getComponentID(Component c)
		throws HeadlessException
    {
    }
	
	public static Pointer getWindowPointer(Window w)
		throws HeadlessException
	{
	}
	
	public static Pointer getComponentPointer(Component c)
		throws HeadlessException
    {
    }
	
	public static Pointer getDirectBufferPointer(Buffer b)
	{
	}
	*/
	
	public static String toString(byte[] buf)
	{
		return toString(buf, null);
	}
	
	public static String toString(byte[] buf, String encoding)
	{
		if (encoding == null || !Charset.isSupported(encoding))
			encoding = Charset.defaultCharset().name();
		int idx = Arrays.asList(buf).indexOf(0);
		if (idx < 0)
			idx = buf.length;
		try {
			return new String (buf, 0, idx, encoding);
		} catch (UnsupportedEncodingException e) {
			// should not happen
			return null;
		}
	}
	
	public static String toString(char[] buf)
	{
		int idx = Arrays.asList(buf).indexOf('\0');
		if (idx < 0)
			idx = buf.length;
		return new String (buf, 0, idx);
	}
	
	public static Object loadLibrary(Class interfaceClass)
	{
		return loadLibrary(interfaceClass, null);
	}
	
	public static Object loadLibrary(Class interfaceClass, Map options)
	{
		return loadLibrary (NativeLibrary.getProcess(options).name, interfaceClass, options);
	}
	
	public static Object loadLibrary(String name, Class interfaceClass)
	{
		return loadLibrary(name, interfaceClass, null);
	}
	
	public static Object loadLibrary(String name, Class interfaceClass, Map options)
	{
		// FIXME: instantiate Library.Handler every time?
		// FIXME: create new proxy instance every time?
		return Proxy.newProxyInstance(interfaceClass.getClassLoader(), interfaceClass.getInterfaces(), new Library.Handler(name, interfaceClass, options));
	}
	
	static Class findEnclosingLibraryClass(Class cls)
	{
		throw new UnsupportedOperationException();
	}
	
	public static Map getLibraryOptions(Class type)
	{
		throw new UnsupportedOperationException();
	}
	
	public static TypeMapper getTypeMapper(Class cls)
	{
		throw new UnsupportedOperationException();
	}
	
	public static int getStructureAlignment(Class cls)
	{
		throw new UnsupportedOperationException();
	}
	
	static byte[] getBytes(String s)
	{
		throw new UnsupportedOperationException();
	}
	
	static final String default_encoding = Charset.defaultCharset().name();
	
	public static byte[] toByteArray(String s)
	{
		try {
			return toByteArray(s, default_encoding);
		} catch(UnsupportedEncodingException ex){
			return null; // must not happen.
		}
	}
	
	public static byte[] toByteArray(String s, String encoding)
    	throws UnsupportedEncodingException
    {
		throw new UnsupportedOperationException();
    }
	
	public static char[] toCharArray(String s)
	{
		throw new UnsupportedOperationException();
	}
	
	static String getNativeLibraryResourcePath(int osType, String arch, String name)
	{
		throw new UnsupportedOperationException();
	}
	
	public static int getLastError()
	{
		throw new UnsupportedOperationException();
	}
	
	public static void setLastError(int code)
	{
		throw new UnsupportedOperationException();
	}
	
	static void updateLastError(int e)
	{
		throw new UnsupportedOperationException();
	}
	
	public static Library synchronizedLibrary(Library library)
	{
		throw new UnsupportedOperationException();
	}
	
	/*
	public static String getWebStartLibraryPath(String libName)
	{
	}
	*/
	
	public static int getNativeSize(Class type, Object value)
	{
		throw new UnsupportedOperationException();
	}
	
	public static int getNativeSize(Class cls)
	{
		throw new UnsupportedOperationException();
	}
	
	public static boolean isSupportedNativeType(Class cls)
	{
		throw new UnsupportedOperationException();
	}
	
	static Callback.UncaughtExceptionHandler callback_exception_handler;
	
	public static void setCallbackExceptionHandler(Callback.UncaughtExceptionHandler eh)
	{
		callback_exception_handler = eh;
	}
	
	public static Callback.UncaughtExceptionHandler getCallbackExceptionHandler()
	{
		return callback_exception_handler;
	}
	
	public static void register(String libName)
	{
		register(new NativeLibrary(libName));
	}
	
	public static void register(NativeLibrary lib)
	{
		register(getCallingClass(), lib);
	}
	
	static Class getNativeClass(Class cls)
	{
		throw new UnsupportedOperationException();
	}
	
	static Class getCallingClass()
	{
		throw new UnsupportedOperationException();
	}
	
	public static void unregister()
	{
		unregister(getCallingClass());
	}
	
	public static void unregister(Class cls)
	{
		throw new UnsupportedOperationException();
	}
	
	static String replace(String s1, String s2, String str)
	{
		throw new UnsupportedOperationException();
	}
	
	public static void register(Class cls, NativeLibrary lib)
	{
		throw new UnsupportedOperationException();		
	}

	// FFI work can be done later
	/* 
	public static long ffi_prep_cif(int abi, int nargs, long ffi_return_type, long ffi_types)
	{
	}
	
	public static void ffi_call(long cif, long fptr, long resp, long args)
	{
	}
	
	public static long ffi_prep_closure(long cif, Native.ffi_callback cb)
	{
	}
	
	public static void ffi_free_closure(long closure)
	{
	}
	
	static int initialize_ffi_type(long type_info)
	{
	}
	*/

	public static void main(String[] args)
	{
		throw new UnsupportedOperationException();
	}
}
