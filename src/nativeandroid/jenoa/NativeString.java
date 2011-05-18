package nativeandroid.jenoa;

public class NativeString implements CharSequence, Comparable {
	public NativeString(String string)
	{
		this(string, false);
	}
	
	public NativeString(String string, boolean wide)
	{
		this.string = string;
		this.wide = wide;
	}
	
	String string;
	boolean wide;
	
	public int hashCode()
	{
		return string.hashCode() * (wide ? -1 : 1);
	}
	
	public boolean equals(Object other)
	{
		if (!(other instanceof NativeString))
			return false;
		NativeString n = (NativeString) other;
		return wide == n.wide && string.equals(n.string);
	}
	
	public String toString()
	{
		return string;
	}
	
	public Pointer getPointer()
	{
		throw new UnsupportedOperationException();
	}
	
	public char charAt(int index)
	{
		return string.charAt(index);
	}
	
	public int length()
	{
		return string.length();
	}
	
	public CharSequence subSequence(int start, int end)
	{
		return string.subSequence(start, end);
	}
	
	public int compareTo(Object other)
	{
		NativeString n = (NativeString) other;
		return string.compareTo(n.string);
	}
}
