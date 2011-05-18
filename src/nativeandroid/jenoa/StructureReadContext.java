package nativeandroid.jenoa;

import java.lang.reflect.Field;

public class StructureReadContext extends FromNativeContext {
	StructureReadContext(Structure struct, Field field)
	{
		super(struct.getClass());
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
