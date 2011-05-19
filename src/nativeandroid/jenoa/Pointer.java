package nativeandroid.jenoa;


import java.nio.ByteBuffer;

//
// Pointer
//  - Memory
//	  - StringArray
//  - Function

public class Pointer {
	
	static native int sizeof();
	static native int valueOfNullPointer();
	
	public static final int SIZE = sizeof ();
	public static final Pointer NULL = createConstant(valueOfNullPointer());
	
	public static final Pointer createConstant(long peer)
	{
		return new Pointer(peer);
	}
	
	public static final Pointer createConstant(int peer)
	{
		return new Pointer(peer);
	}
	
	public static long nativeValue(Pointer p)
	{
		throw new UnsupportedOperationException();
	}
	
	public static void nativeValue(Pointer p, long value)
	{
		throw new UnsupportedOperationException();
	}
	
	protected long peer;
	
	Pointer()
	{
	}
	
	public Pointer(long peer)
	{
		this.peer = peer;
	}
	
	public Pointer share(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	public Pointer share(long offset, long sz)
	{
		throw new UnsupportedOperationException();
	}
	
	public void clear(long size)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Pointer))
			return false;
		Pointer p = (Pointer) o;
		return peer == p.peer;
	}
	
	@Override
	public int hashCode()
	{
		return toString().hashCode();
	}
	
	public long indexOf(long offset, byte value)
	{
		throw new UnsupportedOperationException();
	}
	
	public void read(long offset,
            byte[] buf,
            int index,
            int length)
	{
		throw new UnsupportedOperationException();
	}
	
	public void read(long offset,
            short[] buf,
            int index,
            int length)
	{
		throw new UnsupportedOperationException();
	}
	
	public void read(long offset,
            char[] buf,
            int index,
            int length)
	{
		throw new UnsupportedOperationException();
	}
	
	public void read(long offset,
            int[] buf,
            int index,
            int length)
	{
		throw new UnsupportedOperationException();
	}
	
	public void read(long offset,
            long[] buf,
            int index,
            int length)
	{
		throw new UnsupportedOperationException();
	}
	
	public void read(long offset,
            float[] buf,
            int index,
            int length)
	{
		throw new UnsupportedOperationException();
	}
	
	public void read(long offset,
            double[] buf,
            int index,
            int length)
	{
		throw new UnsupportedOperationException();
	}
	
	public void read(long offset,
            Pointer[] buf,
            int index,
            int length)
	{
		throw new UnsupportedOperationException();
	}
	
	public void write(long offset,
            byte[] buf,
            int index,
            int length)
	{
		throw new UnsupportedOperationException();
	}
	
	public void write(long offset,
            short[] buf,
            int index,
            int length)
	{
		throw new UnsupportedOperationException();
	}
	
	public void write(long offset,
            char[] buf,
            int index,
            int length)
	{
		throw new UnsupportedOperationException();
	}
	
	public void write(long offset,
            int[] buf,
            int index,
            int length)
	{
		throw new UnsupportedOperationException();
	}
	
	public void write(long offset,
            long[] buf,
            int index,
            int length)
	{
		throw new UnsupportedOperationException();
	}
	
	public void write(long offset,
            float[] buf,
            int index,
            int length)
	{
		throw new UnsupportedOperationException();
	}
	
	public void write(long offset,
            double[] buf,
            int index,
            int length)
	{
		throw new UnsupportedOperationException();
	}
	
	public void write(long bOff,
            Pointer[] buf,
            int index,
            int length)
	{
		throw new UnsupportedOperationException();
	}
	
	Object getValue(long offset, Class type, Object currentValue)
	{
		throw new UnsupportedOperationException();
	}
	
	public byte getByte(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	public char getChar(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	public short getShort(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	public int getInt(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	public long getLong(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	public NativeLong getNativeLong(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	public float getFloat(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	public double getDouble(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	public Pointer getPointer(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	public ByteBuffer getByteBuffer(long offset, long length)
	{
		throw new UnsupportedOperationException();
	}
	
	public String getString(long offset, boolean wide)
	{
		throw new UnsupportedOperationException();
	}
	
	public String getString(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	public byte[] getByteArray(long offset, int arraySize)
	{
		throw new UnsupportedOperationException();
	}
	
	public char[] getCharArray(long offset, int arraySize)
	{
		throw new UnsupportedOperationException();
	}
	
	public short[] getShortArray(long offset, int arraySize)
	{
		throw new UnsupportedOperationException();
	}
	
	public int[] getIntArray(long offset, int arraySize)
	{
		throw new UnsupportedOperationException();
	}
	
	public long[] getLongArray(long offset, int arraySize)
	{
		throw new UnsupportedOperationException();
	}
	
	public float[] getFloatArray(long offset, int arraySize)
	{
		throw new UnsupportedOperationException();
	}
	
	public double[] getDoubleArray(long offset, int arraySize)
	{
		throw new UnsupportedOperationException();
	}
	
	public Pointer[] getPointerArray(long base)
	{
		throw new UnsupportedOperationException();
	}
	
	public Pointer[] getPointerArray(long offset, int arraySize)
	{
		throw new UnsupportedOperationException();
	}
	
	public String[] getStringArray(long base)
	{
		throw new UnsupportedOperationException();
	}
	
	public String[] getStringArray(long base, int length)
	{
		throw new UnsupportedOperationException();
	}
	
	public String[] getStringArray(long base, boolean wide)
	{
		throw new UnsupportedOperationException();
	}
	
	public String[] getStringArray(long base, int length, boolean wide)
	{
		throw new UnsupportedOperationException();
	}
	
	void setValue(long offset, Object value, Class type)
	{
		throw new UnsupportedOperationException();
	}
	
	public void setMemory(long offset, long length, byte value)
	{
		throw new UnsupportedOperationException();
	}
	
	static void _setMemory(long addr, long length, byte value)
	{
		throw new UnsupportedOperationException();
	}
	
	public void setByte(long offset, byte value)
	{
		throw new UnsupportedOperationException();
	}
	
	public void setShort(long offset, short value)
	{
		throw new UnsupportedOperationException();
	}
	
	public void setChar(long offset, char value)
	{
		throw new UnsupportedOperationException();
	}
	
	public void setInt(long offset, int value)
	{
		throw new UnsupportedOperationException();
	}
	
	public void setLong(long offset, long value)
	{
		throw new UnsupportedOperationException();
	}
	
	public void setNativeLong(long offset, NativeLong value)
	{
		throw new UnsupportedOperationException();
	}
	
	public void setFloat(long offset, float value)
	{
		throw new UnsupportedOperationException();
	}
	
	public void setDouble(long offset, double value)
	{
		throw new UnsupportedOperationException();
	}
	
	public void setPointer(long offset, Pointer value)
	{
		throw new UnsupportedOperationException();
	}
	
	public void setString(long offset, String value, boolean wide)
	{
		throw new UnsupportedOperationException();
	}
	
	public void setString(long offset, String value)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String toString()
	{
		return new Long(peer).toString();
	}
}
