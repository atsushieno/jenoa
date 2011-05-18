package nativeandroid.jenoa.ptr;

public class ShortByReference extends ByReference {
	
	short value;

	public ShortByReference()
	{
		this((short) 0);
	}
	
	public ShortByReference(short value)
	{
		super(2);
		setValue (value);
	}
	
	public void setValue(short value)
	{
		this.value = value;
	}
	
	public short getValue()
	{
		return value;
	}
}
