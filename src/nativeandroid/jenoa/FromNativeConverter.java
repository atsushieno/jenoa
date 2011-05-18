package nativeandroid.jenoa;

public interface FromNativeConverter {
	Object fromNative(Object nativeValue, FromNativeContext context);
	Class nativeType();
}
