package nativeandroid.jenoa;

public final class WString implements CharSequence, Comparable {

	String s;
	
	public WString(String s)
	{
		this.s = s;
	}
	
	public String toString()
	{
		return s;
	}
	
	public boolean equals(Object o)
	{
		if (!(o instanceof WString))
			return false;
		WString w = (WString) o;
		return s.equals (w.s);
	}
	
	public int hashCode()
	{
		return s.hashCode();
	}
	
	public int compareTo(Object o)
	{
		WString w = (WString) o;
		return s.compareTo(w.s);
	}
	
	public int length()
	{
		return s.length();
	}
	
	public char charAt(int index)
	{
		return s.charAt(index);
	}
	
	public CharSequence subSequence(int start, int end)
	{
		return s.subSequence(start, end);
	}
}
