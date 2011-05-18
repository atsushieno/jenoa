package nativeandroid.jenoa;

import java.lang.reflect.Field;

public class StructureWriteContext extends ToNativeContext {
	StructureWriteContext(Structure struct, Field field)
	{
		this.struct = struct;
		this.field = field;
	}
	
	Structure struct;
	Field field;
	
	public Structure getStructure()
	{
		return struct;
	}
	
	public Field getField()
	{
		return field;
	}
}
