package nativeandroid.jenoa;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Function extends Pointer {
	public static interface PostCallRead {
		void read();
	}
	
	public static final int MAX_NARGS = 256;
	public static final int C_CONVENTION = 0;
	public static final int ALT_CONVENTION = 1;
	public static final int THROW_LAST_ERROR = 4;
	static final Integer INTEGER_TRUE = new Integer (1);
	static final Integer INTEGER_FALSE = new Integer (0);
	static final String OPTION_INVOKING_METHOD = "invoking-method";
	
	public static Function getFunction(String libraryName, String functionName)
	{
		return getFunction(libraryName, functionName, C_CONVENTION);
	}
	
	public static Function getFunction(String libraryName, String functionName, int callFlags)
	{
		return NativeLibrary.getInstance(libraryName).getFunction(functionName, callFlags);
	}
	
	public static Function getFunction(Pointer p)
	{
		return getFunction(p, C_CONVENTION);
	}

	static Map<Pointer,Function> functions_by_pointer = new HashMap<Pointer,Function>();
	
	public static Function getFunction(Pointer p, int callFlags)
	{
		Function f = functions_by_pointer.get(p);
		if (f == null) {
			f = new Function (p, callFlags);
			functions_by_pointer.put(p, f);
		}
		return f;
	}
	
	static Object[] concatenateVarArgs(Object[] inArgs)
	{
		throw new UnsupportedOperationException();
	}
	
	static boolean isVarArgs(Method m)
	{
		throw new UnsupportedOperationException();
	}
	
	static Boolean valueOf(boolean b)
	{
		throw new UnsupportedOperationException();
	}
	
	int callFlags;
	final Map options = new Hashtable ();
	NativeLibrary library;
	String name;
	
	Function(NativeLibrary library, String functionName, int callFlags)
	{
		this.library = library;
		this.name = name;
		this.callFlags = callFlags;
	}
	
	Function(Pointer functionAddress, int callFlags)
	{
		throw new UnsupportedOperationException();
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getCallingConvention()
	{
		throw new UnsupportedOperationException();
	}
	
	public Object invoke(Class returnType, Object[] inArgs)
	{
		throw new UnsupportedOperationException();
	}
	
	public Object invoke(Class returnType, Object[] inArgs, Map options)
	{
		throw new UnsupportedOperationException();
	}
	
	Object invoke(Object[] args, Class returnType, boolean allowObjects)
	{
		throw new UnsupportedOperationException();
	}
	
	public void invoke(Object[] args)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String toString()
	{
		return getName();
	}
	
	public Object invokeObject(Object[] args)
	{
		throw new UnsupportedOperationException();
	}
	
	public Pointer invokePointer(Object[] args)
	{
		throw new UnsupportedOperationException();
	}
	
	public String invokeString(Object[] args, boolean wide)
	{
		throw new UnsupportedOperationException();
	}
	
	public int invokeInt(Object[] args)
	{
		throw new UnsupportedOperationException();
	}
	
	public long invokeLong(Object[] args)
	{
		throw new UnsupportedOperationException();
	}
	
	public float invokeFloat(Object[] args)
	{
		throw new UnsupportedOperationException();
	}
	
	public double invokeDouble(Object[] args)
	{
		throw new UnsupportedOperationException();
	}
	
	public void invokeVoid(Object[] args)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Function))
			return false;
		Function f = (Function) o;
		return library.equals(f.library) && name.equals(f.name);
	}
}
