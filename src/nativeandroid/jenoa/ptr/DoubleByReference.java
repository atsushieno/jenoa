package nativeandroid.jenoa.ptr;

public class DoubleByReference extends ByReference {
	
	double value;

	public DoubleByReference()
	{
		this((short) 0);
	}
	
	public DoubleByReference(double value)
	{
		super(8);
		setValue (value);
	}
	
	public void setValue(double value)
	{
		this.value = value;
	}
	
	public double getValue()
	{
		return value;
	}
}
