package nativeandroid.jenoa;

import java.util.HashMap;
import java.util.Map;

public class NativeMappedConverter implements TypeConverter {
	
	static Map<Class,NativeMappedConverter> instances = new HashMap<Class,NativeMappedConverter>();
	
	public static NativeMappedConverter getInstance(Class cls)
	{
		NativeMappedConverter c = (NativeMappedConverter) instances.get(cls);
		if (c == null) {
			c = new NativeMappedConverter(cls);
			instances.put(cls, c);
		}
		return c;
	}
	
	Class native_type;
	
	public NativeMappedConverter(Class type)
	{
		native_type = type;
	}
	
	public NativeMapped defaultValue()
	{
		throw new UnsupportedOperationException();
	}
	
	public Object fromNative(Object nativeValue, FromNativeContext context)
	{
		throw new UnsupportedOperationException();
	}
	
	public Class nativeType()
	{
		return native_type;
	}
	
	public Object toNative(Object value, ToNativeContext context)
	{
		throw new UnsupportedOperationException();
	}
}
