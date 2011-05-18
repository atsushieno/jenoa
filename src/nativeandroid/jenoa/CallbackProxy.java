package nativeandroid.jenoa;

public interface CallbackProxy extends Callback {
	public static interface UncaughtExceptionHandler {
		void uncaughtException(Callback c, Throwable e);
	}
	
	Object callback(Object[] args);
	Class[] getParameterTypes();
	Class getReturnType();
}
