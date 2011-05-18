package nativeandroid.jenoa;


import java.lang.reflect.*;
import java.util.*;

public interface Library {
	public static class Handler implements InvocationHandler {

		static final Class object_class = Object.class;
		static final Method OBJECT_TOSTRING = GetMethod ("toString");

		static final Method OBJECT_HASHCODE = GetMethod ("hashCode");
		
		static final Method OBJECT_EQUALS = GetMethod ("equals");
		
		static Method GetMethod (String name)
		{
			try {
				return object_class.getMethod (name);
			} catch (NoSuchMethodException ex) {
				return null;
			}
		}

		public Handler(String libname, Class interfaceClass, Map options)
        {
			throw new UnsupportedOperationException();
        }
		
		public NativeLibrary getNativeLibrary()
		{
			throw new UnsupportedOperationException();
		}
		
		public String getLibraryName()
		{
			throw new UnsupportedOperationException();
		}
		
		public Class getInterfaceClass()
		{
			throw new UnsupportedOperationException();
		}
		
		public Object invoke(Object proxy, Method method, Object[] inArgs)
         throws Throwable
		{
     		throw new UnsupportedOperationException();
		}
	}
	
	static final String OPTION_TYPE_MAPPER = "type-mapper";
	static final String OPTION_FUNCTION_MAPPER = "function-mapper";
	static final String OPTION_INVOCATION_MAPPER = "invocation-mapper";
	static final String OPTION_STRUCTURE_ALIGNMENT = "structure-alignment";
	static final String OPTION_ALLOW_OBJECTS = "allow-objects";
	static final String OPTION_CALLING_CONVENTION = "calling-convention";
}
