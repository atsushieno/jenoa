package nativeandroid.jenoa.ptr;

public class FloatByReference extends ByReference {
	
	float value;

	public FloatByReference()
	{
		this((float) 0);
	}
	
	public FloatByReference(float value)
	{
		super(4);
		setValue (value);
	}
	
	public void setValue(float value)
	{
		this.value = value;
	}
	
	public float getValue()
	{
		return value;
	}
}
