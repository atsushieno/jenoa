package nativeandroid.jenoa;


import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Vector;

public class NativeLibrary {
	
	static Vector<NativeLibrary> instances;
	
	static {
		instances = new Vector<NativeLibrary> ();
	}
	
	public static final NativeLibrary getInstance(String libraryName)
	{
		return getInstance(libraryName, null);
	}
	
	public static final NativeLibrary getInstance(String libraryName, Map options)
	{
		for (NativeLibrary l : instances)
			if (l.getName().equals(libraryName))
				return l;
		NativeLibrary n = new NativeLibrary(libraryName);
		if(options != null)
			options.putAll(n.local_options);
		instances.add(n);
		return n;
	}
	
	public static final NativeLibrary getProcess()
	{
		return getProcess(null);
	}
	
	public static final NativeLibrary getProcess(Map options)
	{
		throw new UnsupportedOperationException();
	}
	
	public static final void addSearchPath(String libraryName,
            String path)
	{
		throw new UnsupportedOperationException();
	}
	
	public NativeLibrary (String name)
	{
		this.name = name;
		local_options = new Hashtable ();
		options.putAll(local_options);
	}
	
	final int callFlags = Function.C_CONVENTION;
	final Map options = new Hashtable ();
	String name;
	File file;
	Map local_options;
	
	public Function getFunction(String functionName)
	{
		return getFunction(functionName, 0);
	}
	
	public Function getFunction(String functionName, int callFlags)
	{
		return new Function(this, functionName, callFlags);
	}
	
	class NamedFunction {
		public String name;
		public Method method;
		public Function function;
	}
	
	List<NamedFunction> functions = new Vector<NamedFunction>();
	
	Function getFunction(String name, Method method)
	{
		for (NamedFunction nf : functions)
			if (nf.name.equals (name) && nf.method == method)
				return nf.function;
		NamedFunction nf = new NamedFunction();
		nf.name = name;
		nf.method = method;
		Integer cc = (Integer) local_options.get(Library.OPTION_CALLING_CONVENTION);
		nf.function = new Function(this, name, cc);
		functions.add(nf);
		return nf.function;
	}
	
	public Map getOptions()
	{
		return local_options;
	}
	
	public Pointer getGlobalVariableAddress(String symbolName)
	{
		return new Pointer(getSymbolAddress(symbolName));
	}
	
	static native long dlsym(String name);
	
	long getSymbolAddress(String name)
	{
		// FIXME: canonicalize name
		return dlsym(name);
	}
	
	@Override
	public String toString()
	{
		return getName();
	}
	
	public String getName()
	{
		return name;
	}
	
	public File getFile()
	{
		if (file == null)
			file = new File (name);
		return file;
	}
	
	protected void finalize()
	{
		
	}
	
	public void dispose()
	{
		throw new UnsupportedOperationException();
	}
	
	static String matchLibrary(String libName, List searchPath)
	{
		throw new UnsupportedOperationException();
	}
	
	static double parseVersion(String ver)
	{
		throw new UnsupportedOperationException();
	}
}
