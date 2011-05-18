package nativeandroid.jenoa;


public class NativeLong extends IntegerType {
	static native int sizeOfNativeLong();
	public static final int SIZE = sizeOfNativeLong();
	
	public NativeLong()
	{
		super(SIZE);
	}
	public NativeLong(long value)
	{
		super(SIZE, value);
	}
}
