package nativeandroid.jenoa;


import java.lang.reflect.*;
import java.util.*;

public interface Library {
	public static class Handler implements InvocationHandler {

		static final Class object_class = Object.class;
		static final Method OBJECT_TOSTRING = GetObjectMethod ("toString");

		static final Method OBJECT_HASHCODE = GetObjectMethod ("hashCode");
		
		static final Method OBJECT_EQUALS = GetObjectMethod ("equals");
		
		static Method GetObjectMethod (String name)
		{
			try {
				return object_class.getMethod (name);
			} catch (NoSuchMethodException ex) {
				// should not happen.
				return null;
			}
		}
		
		String libname;
		Class iface_class;
		Map options;
		NativeLibrary native_library;

		public Handler(String libname, Class interfaceClass, Map options)
        {
			this.libname = libname;
			this.iface_class = interfaceClass;
			this.options = options;
        }
		
		public NativeLibrary getNativeLibrary()
		{
			if (native_library == null) {
				native_library = new NativeLibrary (libname);
				options.putAll(native_library.getOptions());
			}
			return native_library;
		}
		
		public String getLibraryName()
		{
			return libname;
		}
		
		public Class getInterfaceClass()
		{
			return iface_class;
		}
		
		public Object invoke(Object proxy, Method method, Object[] inArgs)
       	throws Throwable
		{
    		InvocationMapper im = options == null ? null : (InvocationMapper) options.get(Library.OPTION_INVOCATION_MAPPER);
    		if (im != null)
    			return im.getInvocationHandler(getNativeLibrary(), method);
    		else
    			return defaultInvoke(proxy, method, inArgs);
		}

		Object defaultInvoke(Object proxy, Method method, Object[] inArgs)
       	throws Throwable
       	{
			String fname = null;
			FunctionMapper fm = (FunctionMapper) options.get(Library.OPTION_FUNCTION_MAPPER);
			if (fm != null)
				fname = fm.getFunctionName(getNativeLibrary(), method);
			Function f = getNativeLibrary().getFunction(fname, method);
			return f.invoke(method.getReturnType(), inArgs, options);
		}
	}
	
	static final String OPTION_TYPE_MAPPER = "type-mapper";
	static final String OPTION_FUNCTION_MAPPER = "function-mapper";
	static final String OPTION_INVOCATION_MAPPER = "invocation-mapper";
	static final String OPTION_STRUCTURE_ALIGNMENT = "structure-alignment";
	static final String OPTION_ALLOW_OBJECTS = "allow-objects";
	static final String OPTION_CALLING_CONVENTION = "calling-convention";
}
