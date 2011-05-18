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
		// FIXME: return null or throw?
		return null;
	}
	
	public static final NativeLibrary getProcess()
	{
		throw new UnsupportedOperationException();
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
	
	Function getFunction(String name, Method method)
	{
		throw new UnsupportedOperationException();
	}
	
	public Map getOptions()
	{
		return local_options;
	}
	
	public Pointer getGlobalVariableAddress(String symbolName)
	{
		throw new UnsupportedOperationException();
	}
	
	long getSymbolAddress(String name)
	{
		throw new UnsupportedOperationException();
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
