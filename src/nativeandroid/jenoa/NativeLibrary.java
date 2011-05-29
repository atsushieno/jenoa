package nativeandroid.jenoa;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Vector;

public class NativeLibrary {
	
	static HashMap<String,List<String>> lookup_paths;
	static Vector<NativeLibrary> instances;
	
	static {
		lookup_paths = new HashMap<String,List<String>>();
		instances = new Vector<NativeLibrary>();
	}
	
	public static final NativeLibrary getInstance(String libraryName)
	{
		return getInstance(libraryName, null);
	}
	
	static String canonicalizeLibraryName (String name)
	{
		return "lib" + name;
	}
	
	public static final NativeLibrary getInstance(String libraryName, Map options)
	{
		libraryName = canonicalizeLibraryName (libraryName);
		
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
		List<String> paths = lookup_paths.get(libraryName);
		if (path == null) {
			paths = new Vector<String>();
			lookup_paths.put(libraryName, paths);
		}
		throw new UnsupportedOperationException();
	}

	
	public NativeLibrary (String name)
	{
		this.name = name;
		local_options = new Hashtable ();
		options.putAll(local_options);
		dl_handle = LibDL.getInstance().dlopen(name, LibDL.RTLD_LAZY);
	}
	
	final int callFlags = Function.C_CONVENTION;
	final Map options = new Hashtable ();
	String name;
	File file;
	Map local_options;
	long dl_handle;
	
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
		if (name == null)
			throw new IllegalArgumentException ("null name");
		if (method == null)
			throw new IllegalArgumentException ("null method");
		for (NamedFunction nf : functions)
			if (nf.name.equals (name) && nf.method == method)
				return nf.function;
		NamedFunction nf = new NamedFunction();
		nf.name = name;
		nf.method = method;
		Integer cc = (Integer) local_options.get(Library.OPTION_CALLING_CONVENTION);
		nf.function = new Function(this, name, cc != null ? cc.intValue() : Function.C_CONVENTION);
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
	
	long getSymbolAddress(String name)
	{
		// FIXME: canonicalize name
		return LibDL.getInstance().dlsym(dl_handle, name);
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
		throw new UnsupportedOperationException();
	}
	
	protected void finalize()
	{
		dispose();
	}
	
	public void dispose()
	{
		synchronized (this) {
			if (dl_handle != 0) {
				LibDL.getInstance().dlclose(dl_handle);
				dl_handle = 0;
			}
		}
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
