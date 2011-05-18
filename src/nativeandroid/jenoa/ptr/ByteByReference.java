package nativeandroid.jenoa.ptr;

public class ByteByReference extends ByReference {
	
	byte value;

	public ByteByReference()
	{
		this((byte) 0);
	}
	
	public ByteByReference(byte value)
	{
		super(1);
		setValue (value);
	}
	
	public void setValue(byte value)
	{
		this.value = value;
	}
	
	public byte getValue()
	{
		return value;
	}
}
