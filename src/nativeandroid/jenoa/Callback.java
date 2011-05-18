package nativeandroid.jenoa;

import java.util.*;

public interface Callback {
	
	public static interface UncaughtExceptionHandler {
		void uncaughtException(Callback c, Throwable e);
	}
	
	static final String METHOD_NAME = "callback";
	static final Collection FORBIDDEN_NAMES = new ArrayList();
}
