package nativeandroid.jenoa;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Structure {
	
	public static interface ByReference {
		
	}
	
	public static interface ByValue {
		
	}
	
	/*
	static class FFIType extends Structure {
		
		public static class size_t extends IntegerType {
			
			long value;
			
			public size_t()
			{
				this(0);
			}
			
			public size_t(long value)
			{
				super((int) value);
				this.value = value;
			}
		}
		
		public size_t size;
		public short alignment;
		public short type;
		public Pointer elements;
		
		static Pointer get(Object obj)
		{
		}
	}
	*/
	
	class StructField {
		public String name;
		public Class type;
		public Field field;
		public int size;
		public int offset;
		public boolean isVolatile;
		public boolean isReadOnly;
		public FromNativeConverter readConverter;
		public ToNativeConverter writeConverter;
		public FromNativeContext context;
		
		StructField()
		{
		}
	}
	
	static native boolean isArchPpc();
	static native boolean isArchSparc();
	
	static final boolean isPPC = isArchPpc();
	static final boolean isSPARC = isArchSparc();
	public static final int ALIGN_DEFAULT = 0;
	public static final int ALIGN_NONE = 1;
	public static final int ALIGN_GNUC = 2;
	public static final int ALIGN_MSVC = 3;
	protected static final int CALCULATE_SIZE = -1;
	
	protected Structure()
	{
	}
	
	protected Structure(TypeMapper mapper)
	{
		setTypeMapper(mapper);
	}
	
	protected Structure(Pointer p)
	{
		this(p, 0);
	}
	
	protected Structure(Pointer p, int alignment)
	{
		this(p, alignment, null);
	}
	
	protected Structure(Pointer p, int alignment, TypeMapper mapper)
	{
		this.p = p;
		this.alignment = alignment;
		this.type_mapper = mapper;
	}
	
	Pointer p;
	int alignment;
	TypeMapper type_mapper;
	
	Map fields()
	{
		throw new UnsupportedOperationException();
	}
	
	protected void setTypeMapper(TypeMapper mapper)
	{
		this.type_mapper = mapper;
	}
	
	protected void setAlignType(int alignType)
	{
		alignment = alignType;
	}
	
	protected Memory autoAllocate(int size)
	{
		throw new UnsupportedOperationException();
	}
	
	protected void useMemory(Pointer m)
	{
		useMemory (m, 0);
	}
	
	protected void useMemory(Pointer m,
            int offset)
	{
		throw new UnsupportedOperationException();
	}
	
	protected void ensureAllocated()
	{
		throw new UnsupportedOperationException();
	}
	
	protected void allocateMemory()
	{
		throw new UnsupportedOperationException();
	}
	
	protected void allocateMemory(int size)
	{
		throw new UnsupportedOperationException();
	}
	
	public int size()
	{
		throw new UnsupportedOperationException();
	}
	
	public void clear()
	{
		throw new UnsupportedOperationException();
	}
	
	public Pointer getPointer()
	{
		throw new UnsupportedOperationException();
	}
	
	static Set busy()
	{
		throw new UnsupportedOperationException();
	}
	
	static Map reading()
	{
		throw new UnsupportedOperationException();
	}
	
	public void read()
	{
		throw new UnsupportedOperationException();
	}
	
	public Object readField(String name)
	{
		throw new UnsupportedOperationException();
	}
	
	Object getField(Structure.StructField structField)
	{
		throw new UnsupportedOperationException();
	}
	
	void setField(Structure.StructField structField, Object value)
	{
		throw new UnsupportedOperationException();
	}
	
	static Structure updateStructureByReference(Class type, Structure s, Pointer address)
	{
		throw new UnsupportedOperationException();
	}
	
	Object readField(Structure.StructField structField)
	{
		throw new UnsupportedOperationException();
	}
	
	public void write()
	{
		throw new UnsupportedOperationException();
	}
	
	public void writeField(String name)
	{
		throw new UnsupportedOperationException();
	}
	
	public void writeField(String name, Object value)
	{
		throw new UnsupportedOperationException();
	}
	
	void writeField(StructField structField)
	{
		throw new UnsupportedOperationException();
	}
	
	protected List getFieldOrder()
	{
		throw new UnsupportedOperationException();
	}
	
	protected void setFieldOrder(String[] fields)
	{
		throw new UnsupportedOperationException();
	}
	
	protected void sortFields(List fields, List names)
	{
		throw new UnsupportedOperationException();
	}
	
	protected List getFields(boolean force)
	{
		throw new UnsupportedOperationException();
	}
	
	int calculateSize(boolean force)
	{
		throw new UnsupportedOperationException();
	}
	
	int calculateAlignedSize(int calculatedSize)
	{
		throw new UnsupportedOperationException();
	}
	
	protected int getStructAlignment()
	{
		throw new UnsupportedOperationException();
	}
	
	protected int getNativeAlignment(Class type, Object value, boolean isFirstElement)
	{
		throw new UnsupportedOperationException();
	}
	
	public String toString()
	{
		throw new UnsupportedOperationException();
	}
	
	public Structure[] toArray(Structure[] array)
	{
		throw new UnsupportedOperationException();
	}
	
	public Structure[] toArray(int size)
	{
		throw new UnsupportedOperationException();
	}
	
	public boolean equals(Object o)
	{
		throw new UnsupportedOperationException();
	}
	
	public int hashCode()
	{
		throw new UnsupportedOperationException();
	}
	
	protected void cacheTypeInfo(Pointer p)
	{
		throw new UnsupportedOperationException();
	}
	
	Pointer getTypeInfo()
	{
		throw new UnsupportedOperationException();
	}
	
	public void setAutoSynch(boolean auto)
	{
		throw new UnsupportedOperationException();
	}
	
	public void setAutoRead(boolean auto)
	{
		throw new UnsupportedOperationException();
	}
	
	public boolean getAutoRead()
	{
		throw new UnsupportedOperationException();
	}
	
	public void setAutoWrite(boolean auto)
	{
		throw new UnsupportedOperationException();
	}
	
	public boolean getAutoWrite()
	{
		throw new UnsupportedOperationException();
	}
	
	static Pointer getTypeInfo(Object obj)
	{
		throw new UnsupportedOperationException();
	}
	
	public static Structure newInstance(Class type)
		throws IllegalArgumentException
    {
		throw new UnsupportedOperationException();
    }
	
	public static void autoRead(Structure[] ss)
	{
		throw new UnsupportedOperationException();
	}
	
	public void autoRead()
	{
		throw new UnsupportedOperationException();
	}
	
	public static void autoWrite(Structure[] ss)
	{
		throw new UnsupportedOperationException();
	}
	
	public void autoWrite()
	{
		throw new UnsupportedOperationException();
	}
}
