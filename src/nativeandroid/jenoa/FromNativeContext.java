package nativeandroid.jenoa;


public class FromNativeContext {
	
	Class java_type;
	
	FromNativeContext(Class javaType)
	{
		java_type = javaType;
	}
	
	public Class getTargetType()
	{
		return java_type;
	}
}
