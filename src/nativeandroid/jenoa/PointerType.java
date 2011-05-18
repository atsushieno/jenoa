package nativeandroid.jenoa;

public abstract class PointerType extends Object implements NativeMapped {
	protected PointerType()
	{
		this(Pointer.NULL);
	}
	
	Pointer p;
	
	protected PointerType(Pointer p)
	{
		this.p = p;
	}
	
	public Class nativeType()
	{
		throw new UnsupportedOperationException();
	}
	
	public Object toNative()
	{
		throw new UnsupportedOperationException();
	}
	
	public Pointer getPointer()
	{
		return p;
	}
	
	public void setPointer(Pointer p)
	{
		this.p = p;
	}
	
	public Object fromNative(Object nativeValue, FromNativeContext context)
	{
		throw new UnsupportedOperationException();
	}
	
	public int hashCode()
	{
		return p.hashCode();
	}
	
	public boolean equals(Object o)
	{
		if (!(o instanceof PointerType))
			return false;
		PointerType pp = (PointerType) o;
		return p.equals(pp.p);
	}
	
	public String toString()
	{
		return p.toString();
	}
}
