package nativeandroid.jenoa;

import java.lang.reflect.Method;

public interface FunctionMapper {
	String getFunctionName(NativeLibrary library, Method method);
}
