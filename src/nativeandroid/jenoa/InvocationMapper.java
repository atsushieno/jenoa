package nativeandroid.jenoa;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public interface InvocationMapper {
	InvocationHandler getInvocationHandler(NativeLibrary lib, Method m);
}
