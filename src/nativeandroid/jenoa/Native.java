package nativeandroid.jenoa;

import java.io.File;
import java.io.UnsupportedEncodingException;
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
	
	public static interface ffi_callback {
		void invoke(long cif, long resp, long argp);
	}
	
	public static final int POINTER_SIZE = getPointerSize();
	public static final int LONG_SIZE = getLongSize();
	public static final int WCHAR_SIZE = getWCharSize();
	public static final int SIZE_T_SIZE = getSizeTSize();
	
	static native int getPointerSize();
	static native int getLongSize();
	static native int getWCharSize();
	static native int getSizeTSize();
	
	public static void setProtected(boolean enable)
	{
		throw new UnsupportedOperationException();
	}
	
	public static boolean isProtected()
	{
		throw new UnsupportedOperationException();
	}
	
	public static void setPreserveLastError(boolean enable)
	{
		throw new UnsupportedOperationException();
	}
	
	public static boolean getPreserveLastError()
	{
		throw new UnsupportedOperationException();
	}
	
	/*
	public static long getWindowID(Window w)
		throws HeadlessException
    {
		throw new UnsupportedOperationException();
    }
	
	public static long getComponentID(Component c)
		throws HeadlessException
    {
		throw new UnsupportedOperationException();
    }
	
	public static Pointer getWindowPointer(Window w)
		throws HeadlessException
	{
			throw new UnsupportedOperationException();
	}
	
	public static Pointer getComponentPointer(Component c)
		throws HeadlessException
    {
		throw new UnsupportedOperationException();		
    }
	
	public static Pointer getDirectBufferPointer(Buffer b)
	{
		throw new UnsupportedOperationException();
	}
	*/
	
	public static String toString(byte[] buf)
	{
		throw new UnsupportedOperationException();
	}
	
	public static String toString(byte[] buf, String encoding)
	{
		throw new UnsupportedOperationException();
	}
	
	public static String toString(char[] buf)
	{
		throw new UnsupportedOperationException();
	}
	
	public static Object loadLibrary(Class interfaceClass)
	{
		throw new UnsupportedOperationException();
	}
	
	public static Object loadLibrary(Class interfaceClass, Map options)
	{
		throw new UnsupportedOperationException();
	}
	
	public static Object loadLibrary(String name, Class interfaceClass)
	{
		throw new UnsupportedOperationException();
	}
	
	public static Object loadLibrary(String name, Class interfaceClass, Map options)
	{
		throw new UnsupportedOperationException();
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
	
	public static byte[] toByteArray(String s)
	{
		throw new UnsupportedOperationException();
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
	
	public static String getWebStartLibraryPath(String libName)
	{
		throw new UnsupportedOperationException();
	}
	
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
	
	public static void setCallbackExceptionHandler(Callback.UncaughtExceptionHandler eh)
	{
		throw new UnsupportedOperationException();
	}
	
	public static Callback.UncaughtExceptionHandler getCallbackExceptionHandler()
	{
		throw new UnsupportedOperationException();
	}
	
	public static void register(String libName)
	{
		throw new UnsupportedOperationException();
	}
	
	public static void register(NativeLibrary lib)
	{
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException();
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
	
	public static long ffi_prep_cif(int abi, int nargs, long ffi_return_type, long ffi_types)
	{
		throw new UnsupportedOperationException();
	}
	
	public static void ffi_call(long cif, long fptr, long resp, long args)
	{
		throw new UnsupportedOperationException();
	}
	
	public static long ffi_prep_closure(long cif, Native.ffi_callback cb)
	{
		throw new UnsupportedOperationException();
	}
	
	public static void ffi_free_closure(long closure)
	{
		throw new UnsupportedOperationException();
	}
	
	static int initialize_ffi_type(long type_info)
	{
		throw new UnsupportedOperationException();
	}
	
	public static void main(String[] args)
	{
		throw new UnsupportedOperationException();
	}
}
