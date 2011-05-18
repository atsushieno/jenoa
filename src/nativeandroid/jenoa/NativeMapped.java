package nativeandroid.jenoa;


public interface NativeMapped {
	Object fromNative(Object nativeValue,
            FromNativeContext context);
	
	Object toNative();
	
	Class nativeType();
}
