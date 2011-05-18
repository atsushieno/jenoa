package nativeandroid.jenoa;

public interface ToNativeConverter {
	Object toNative(Object value, ToNativeContext context);
	
	Class nativeType();
}
