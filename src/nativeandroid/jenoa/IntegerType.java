package nativeandroid.jenoa;


public class IntegerType extends Number implements NativeMapped {
	int size;
	long value;
	
	public IntegerType(int size)
	{
		this(size, 0);
	}
	
	public IntegerType(int size, long value)
	{
		this.size = size;
		setValue(value);
	}
	
	public void setValue(long value)
	{
		this.value = value;
	}
	
	public Object toNative()
	{
		switch (size) {
		case 1:
			return new Byte ((byte) value);
		case 2:
			return new Short ((short) value);
		case 4:
			return new Integer ((int) value);
		case 8:
			return new Long (value);
		}
		throw new IllegalStateException();
	}
	
	public Object fromNative(Object nativeValue,
 FromNativeContext context)
	{
		switch (size) {
		case 1:
			return (Byte) nativeValue;
		case 2:
			return (Short) nativeValue;
		case 4:
			return (Integer) nativeValue;
		case 8:
			return (Long) nativeValue;
		}
		throw new IllegalStateException();
	}
	
	public Class nativeType()
	{
		switch (size) {
		case 1:
			return Byte.class;
		case 2:
			return Short.class;
		case 4:
			return Integer.class;
		case 8:
			return Long.class;
		}
		throw new IllegalStateException();
	}
	
	public int intValue()
	{
		return (int) value;
	}
	
	public long longValue()
	{
		return value;
	}
	
	public float floatValue()
	{
		return (float) value;
	}
	
	public double doubleValue()
	{
		return (double) value;
	}
	
	@Override
	public boolean equals(Object rhs)
	{
		if (!(rhs instanceof IntegerType))
			return false;
		IntegerType i = (IntegerType) rhs;
		return size == i.size && value == i.value;
	}
	
	@Override
	public String toString()
	{
		return toNative().toString();
	}
	
	@Override
	public int hashCode()
	{
		return toNative().hashCode();
	}
}
