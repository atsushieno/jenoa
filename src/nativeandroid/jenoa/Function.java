package nativeandroid.jenoa;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

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
		return inArgs;
	}
	
	static boolean isVarArgs(Method m)
	{
		return m.isVarArgs();
	}
	
	static Boolean valueOf(boolean b)
	{
		return Boolean.valueOf(b);
	}
	
	int callFlags;
	final Map options = new Hashtable ();
	NativeLibrary library;
	String name;
	Pointer native_ptr;
	
	Function(NativeLibrary library, String functionName, int callFlags)
	{
		if (functionName == null)
			throw new java.lang.IllegalArgumentException ("null functionName");
		this.library = library;
		this.name = functionName;
		this.callFlags = callFlags;
	}
	
	Function(Pointer functionAddress, int callFlags)
	{
		native_ptr = functionAddress;
		this.callFlags = callFlags;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getCallingConvention()
	{
		// ... correct?
		return callFlags;
	}
	
	public Object invoke(Class returnType, Object[] inArgs)
	{
		return invoke(returnType, inArgs, null);
	}
	
	public Object invoke(Class returnType, Object[] inArgs, Map options)
	{
		return invoke(inArgs, returnType, true);
	}
	
	Object invoke(Object[] args, Class returnType, boolean allowObjects)
	{
		// the documentation says "implementation" that points to NativeLibrary... so it is there?
		if (native_ptr == null)
			native_ptr = new Pointer (library.getSymbolAddress(name));
		if (native_ptr == Pointer.NULL)
			throw new UnsupportedOperationException(String.format("Function %d not found", name));

		// FIXME: convert argument types.
		
		return LibDL.getInstance().invoke(native_ptr.peer, returnType, args);
	}
	
	public void invoke(Object[] args)
	{
		invoke(args, Void.class, true);
	}
	
	@Override
	public String toString()
	{
		return super.toString(); // why override then??
		//return getName();
	}
	
	public Object invokeObject(Object[] args)
	{
		return invoke(Object.class, args);
	}
	
	public Pointer invokePointer(Object[] args)
	{
		return (Pointer) invoke(Pointer.class, args);
	}
	
	public String invokeString(Object[] args, boolean wide)
	{
		if (wide)
			return ((WString) invoke(WString.class, args)).toString();
		else
			return (String) invoke(String.class, args);
	}
	
	public int invokeInt(Object[] args)
	{
		return (Integer) invoke(Integer.class, args);
	}
	
	public long invokeLong(Object[] args)
	{
		return (Long) invoke(Long.class, args);
	}
	
	public float invokeFloat(Object[] args)
	{
		return (Float) invoke(Float.class, args);
	}
	
	public double invokeDouble(Object[] args)
	{
		return (Double) invoke(Double.class, args);
	}
	
	public void invokeVoid(Object[] args)
	{
		invoke(Void.class, args);
	}
	
	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
		//if (!(o instanceof Pointer))
		//	return false;
		//Pointer p = (Pointer) o;
		//return library.equals(f.library) && name.equals(f.name);
	}
}
