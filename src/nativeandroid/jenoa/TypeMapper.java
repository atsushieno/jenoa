package nativeandroid.jenoa;

public interface TypeMapper {
	FromNativeConverter getFromNativeConverter(Class javaType);
	ToNativeConverter getToNativeConverter(Class javaType);
}
