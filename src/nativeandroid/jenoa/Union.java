package nativeandroid.jenoa;

public abstract class Union extends Structure {
	Structure.StructField biggestField;
	
	protected Union()
	{
		throw new UnsupportedOperationException();
	}
	
	protected Union(Pointer p)
	{
		throw new UnsupportedOperationException();
	}
	
	protected Union(Pointer p, int alignType)
	{
		throw new UnsupportedOperationException();
	}
	
	protected Union(TypeMapper mapper)
	{
		throw new UnsupportedOperationException();
	}
	
	protected Union(Pointer p, int alignType, TypeMapper mapper)
	{
		throw new UnsupportedOperationException();
	}
	
	public void setType(Class type)
	{
		throw new UnsupportedOperationException();
	}
	
	public Object readField(String name)
	{
		throw new UnsupportedOperationException();
	}
	
	public void writeField(String name)
	{
		throw new UnsupportedOperationException();
	}
	
	public void writeField(String name, Object value)
	{
		throw new UnsupportedOperationException();
	}
	
	public Object getTypedValue(Class type)
	{
		throw new UnsupportedOperationException();
	}
	
	public Object setTypedValue(Object object)
	{
		throw new UnsupportedOperationException();
	}
	
	void writeField(Structure.StructField field)
	{
		throw new UnsupportedOperationException();
	}
	
	Object readField(Structure.StructField field)
	{
		throw new UnsupportedOperationException();
	}
	
	int calculateSize(boolean force)
	{
		throw new UnsupportedOperationException();
	}
	
	protected int getNativeAlignment(Class type, Object value, boolean isFirstElement)
	{
		throw new UnsupportedOperationException();
	}
	
	Pointer getTypeInfo()
	{
		throw new UnsupportedOperationException();
	}
}
