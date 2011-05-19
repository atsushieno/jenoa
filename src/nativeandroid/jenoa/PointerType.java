package nativeandroid.jenoa;

import java.util.Map;

public abstract class PointerType implements NativeMapped {
	protected PointerType()
	{
		this(Pointer.NULL);
	}
	
	Pointer p;
	
	protected PointerType(Pointer p)
	{
		this.p = p;
	}
	
	static final IntegerType pointer_integer_type = new IntegerType(Pointer.SIZE);
	
	public Class nativeType()
	{
		return pointer_integer_type.nativeType();
	}
	
	public Object toNative()
	{
		return p.peer;
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
		return new Pointer ((Long) pointer_integer_type.fromNative(nativeValue, context));
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
