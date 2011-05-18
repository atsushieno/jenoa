package nativeandroid.jenoa;

import java.nio.ByteBuffer;

public class Memory extends Pointer {
	protected long size;
	
	public Memory(long size)
	{
		this.size = size;
	}
	
	protected Memory()
	{
	}
	
	public static void purge()
	{
		throw new UnsupportedOperationException();
	}
	
	public Pointer share(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	public Pointer share(long offset, long sz)
	{
		throw new UnsupportedOperationException();
	}
	
	public Memory align(int byteBoundary)
	{
		throw new UnsupportedOperationException();
	}
	
	protected void finalize()
	{
		throw new UnsupportedOperationException();
	}
	
	public void clear()
	{
		throw new UnsupportedOperationException();
	}
	
	public boolean isValid()
	{
		throw new UnsupportedOperationException();
	}
	
	public boolean valid()
	{
		throw new UnsupportedOperationException();
	}
	
	public long size()
	{
		throw new UnsupportedOperationException();
	}
	
	@Deprecated
	public long getSize()
	{
		return size();
	}
	
	protected void boundsCheck(long off, long sz)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void read(long bOff, byte[] buf, int index, int length)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void read(long bOff, short[] buf, int index, int length)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void read(long bOff, char[] buf, int index, int length)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void read(long bOff, int[] buf, int index, int length)
	{
		throw new UnsupportedOperationException();
    }
	
	@Override
	public void read(long bOff, long[] buf, int index, int length)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void read(long bOff, float[] buf, int index, int length)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void read(long bOff, double[] buf, int index, int length)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void write(long bOff, byte[] buf, int index, int length)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void write(long bOff, short[] buf, int index, int length)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void write(long bOff, char[] buf, int index, int length)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void write(long bOff, int[] buf, int index, int length)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void write(long bOff, long[] buf, int index, int length)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void write(long bOff, float[] buf, int index, int length)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void write(long bOff, double[] buf, int index, int length)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public byte getByte(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public char getChar(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public short getShort(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public int getInt(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public long getLong(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public float getFloat(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public double getDouble(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Pointer getPointer(long offset)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public ByteBuffer getByteBuffer(long offset, long length)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String getString(long offset, boolean wide)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void setByte(long offset, byte value)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void setChar(long offset, char value)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void setShort(long offset, short value)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void setInt(long offset, int value)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void setLong(long offset, long value)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void setFloat(long offset, float value)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void setDouble(long offset, double value)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void setPointer(long offset, Pointer value)
	{
		throw new UnsupportedOperationException();
	}
	
	public void setString(long offset, String value, boolean wide)
	{
		throw new UnsupportedOperationException();
	}
	
	protected static long malloc(long size)
	{
		throw new UnsupportedOperationException();
	}
	
	protected static void free(long ptr)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String toString()
	{
		throw new UnsupportedOperationException();
	}
}
