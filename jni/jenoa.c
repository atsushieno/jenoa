

#include "jenoa.h"
#include <string.h>
#include <locale.h>
#include <dlfcn.h>
#include "dyncall/dyncall/dyncall.h"

char *last_error = NULL;

char * update_last_error ()
{
	if (last_error)
		free (last_error);
	const char *err = dlerror ();
	last_error = err == NULL ? NULL : strdup (err);
	return last_error;
}

const dc_vm_size = 4096;

jmethodID get_class, boolean_value, byte_value, short_value, int_value, long_value, float_value, double_value;
jclass boolean_class, byte_class, char_class, short_class, int_class, long_class, float_class, double_class, void_class, object_class, exception_class;
const char
	*boolean_class_name ="java/lang/Boolean",
	*byte_class_name ="java/lang/Byte",
	*short_class_name ="java/lang/Short",
	*int_class_name ="java/lang/Integer",
	*long_class_name ="java/lang/Long",
	*float_class_name ="java/lang/Float",
	*double_class_name ="java/lang/Double",
	*void_class_name ="java/lang/Void",
	*object_class_name ="java/lang/Object",
	*exception_class_name ="java/lang/Exception";

JNIEXPORT void JNICALL Java_nativeandroid_jenoa_LibDL_init_1libdl
  (JNIEnv *env, jclass cls)
{
	setlocale (LC_ALL, "C");
	boolean_class = (*env)->FindClass (env, boolean_class_name);
	byte_class = (*env)->FindClass (env, byte_class_name);
	short_class = (*env)->FindClass (env, short_class_name);
	int_class = (*env)->FindClass (env, int_class_name);
	long_class = (*env)->FindClass (env, long_class_name);
	float_class = (*env)->FindClass (env, float_class_name);
	double_class = (*env)->FindClass (env, double_class_name);
	void_class = (*env)->FindClass (env, void_class_name);
	object_class = (*env)->FindClass (env, object_class_name);
	exception_class = (*env)->FindClass (env, exception_class_name);

	get_class = (*env)->GetMethodID (env, object_class, "getClass", "()Ljava/lang/Class;");
	boolean_value = (*env)->GetMethodID (env, boolean_class, "booleanValue", "()Z");
	byte_value = (*env)->GetMethodID (env, byte_class, "byteValue", "()B");
	short_value = (*env)->GetMethodID (env, short_class, "shortValue", "()S");
	int_value = (*env)->GetMethodID (env, int_class, "intValue", "()I");
	long_value = (*env)->GetMethodID (env, long_class, "longValue", "()J");
	float_value = (*env)->GetMethodID (env, float_class, "floatValue", "()F");
	double_value = (*env)->GetMethodID (env, double_class, "doubleValue", "()D");
}

JNIEXPORT long JNICALL Java_nativeandroid_jenoa_LibDL_init_1dyncall (JNIEnv *env, jobject instance)
{
	return (long) dcNewCallVM (dc_vm_size);
}

JNIEXPORT void JNICALL Java_nativeandroid_jenoa_LibDL_cleanup_1dyncall (JNIEnv *env, jobject instance, long handle)
{
	dcFree ((DCCallVM*) handle);
}

JNIEXPORT void JNICALL Java_nativeandroid_jenoa_LibDL_cleanup_1libdl
  (JNIEnv *env, jclass cls)
{
	if (last_error != NULL)
		free (last_error);
}

JNIEXPORT jlong JNICALL Java_nativeandroid_jenoa_LibDL_dlopen
  (JNIEnv * env, jclass cls, jstring name, jint mode)
{
	jboolean isCopy;
	const char *nameChars = (*env)->GetStringUTFChars (env, name, &isCopy);
	jlong ret = (jlong) dlopen (nameChars, mode);
	last_error = update_last_error ();
	if (isCopy)
		(*env)->ReleaseStringUTFChars (env, name, nameChars);
	return ret;
}

JNIEXPORT jstring JNICALL Java_nativeandroid_jenoa_LibDL_dlerror
  (JNIEnv *env, jclass cls)
{
	return last_error ? (*env)->NewStringUTF (env, last_error) : NULL;
}

JNIEXPORT jint JNICALL Java_nativeandroid_jenoa_LibDL_dlclose
  (JNIEnv * env, jclass cls, jlong ptr)
{
	jint ret = (jint) dlclose ((void*) ptr);
	last_error = update_last_error ();
	return ret;
}

JNIEXPORT jlong JNICALL Java_nativeandroid_jenoa_LibDL_dlsym
  (JNIEnv * env, jclass cls, jlong handle, jstring name)
{
	jboolean isCopy;
	const char *nameChars = (*env)->GetStringUTFChars (env, name, &isCopy);
	jlong ret = (jlong) dlsym ((void*) handle, nameChars);
	last_error = update_last_error ();
	if (isCopy)
		(*env)->ReleaseStringUTFChars (env, name, nameChars);
	return ret;
}

void prepareDynCall (JNIEnv *env, DCCallVM* vm, jobjectArray params)
{
	int i;
	dcReset (vm);
	jsize len = (*env)->GetArrayLength (env, params);
	for (i = 0; i < len; i++) {
		jobject obj = (*env)->GetObjectArrayElement (env, params, i);
		jclass cls = (jclass) (*env)->CallObjectMethod (env, obj, get_class);
		if ((*env)->IsSameObject (env, cls, boolean_class))
			dcArgBool (vm, (DCbool) (*env)->CallBooleanMethod (env, obj, boolean_value));
		else if ((*env)->IsSameObject (env, cls, byte_class))
			dcArgChar (vm, (DCchar) (*env)->CallCharMethod (env, obj, byte_value));
		else if ((*env)->IsSameObject (env, cls, short_class))
			dcArgShort (vm, (DCchar) (*env)->CallShortMethod (env, obj, short_value));
		else if ((*env)->IsSameObject (env, cls, int_class))
			dcArgInt (vm, (DCchar) (*env)->CallIntMethod (env, obj, int_value));
		else if ((*env)->IsSameObject (env, cls, long_class))
			dcArgLong (vm, (DCchar) (*env)->CallLongMethod (env, obj, long_value));
		else if ((*env)->IsSameObject (env, cls, float_class))
			dcArgFloat (vm, (DCchar) (*env)->CallFloatMethod (env, obj, float_value));
		else if ((*env)->IsSameObject (env, cls, double_class))
			dcArgDouble (vm, (DCchar) (*env)->CallDoubleMethod (env, obj, double_value));
		else
			ThrowNew (env, exception_class, "Invalid parameter type");
	}
}

JNIEXPORT jboolean JNICALL Java_nativeandroid_jenoa_LibDL_invokeBoolean
  (JNIEnv *env, jobject instance, jlong handle, jlong dcHandle, jobjectArray params)
{
	DCpointer fp = (DCpointer) handle;
	DCCallVM *vm = (DCCallVM*) dcHandle;
	prepareDynCall (env, vm, params);
	return dcCallBool (vm, fp);
}

JNIEXPORT jbyte JNICALL Java_nativeandroid_jenoa_LibDL_invokeByte
  (JNIEnv *env, jobject instance, jlong handle, jlong dcHandle, jobjectArray params)
{
	DCpointer fp = (DCpointer) handle;
	DCCallVM *vm = (DCCallVM*) dcHandle;
	prepareDynCall (env, vm, params);
	return dcCallChar (vm, fp);
}

JNIEXPORT jshort JNICALL Java_nativeandroid_jenoa_LibDL_invokeShort
  (JNIEnv *env, jobject instance, jlong handle, jlong dcHandle, jobjectArray params)
{
	DCpointer fp = (DCpointer) handle;
	DCCallVM *vm = (DCCallVM*) dcHandle;
	prepareDynCall (env, vm, params);
	return dcCallShort (vm, fp);
}

JNIEXPORT jint JNICALL Java_nativeandroid_jenoa_LibDL_invokeInt
  (JNIEnv *env, jobject instance, jlong handle, jlong dcHandle, jobjectArray params)
{
	DCpointer fp = (DCpointer) handle;
	DCCallVM *vm = (DCCallVM*) dcHandle;
	prepareDynCall (env, vm, params);
	return dcCallInt (vm, fp);
}

JNIEXPORT jlong JNICALL Java_nativeandroid_jenoa_LibDL_invokeLong
  (JNIEnv *env, jobject instance, jlong handle, jlong dcHandle, jobjectArray params)
{
	DCpointer fp = (DCpointer) handle;
	DCCallVM *vm = (DCCallVM*) dcHandle;
	prepareDynCall (env, vm, params);
	return dcCallLong (vm, fp);
}

JNIEXPORT jfloat JNICALL Java_nativeandroid_jenoa_LibDL_invokeFloat
  (JNIEnv *env, jobject instance, jlong handle, jlong dcHandle, jobjectArray params)
{
	DCpointer fp = (DCpointer) handle;
	DCCallVM *vm = (DCCallVM*) dcHandle;
	prepareDynCall (env, vm, params);
	return dcCallFloat (vm, fp);
}

JNIEXPORT jdouble JNICALL Java_nativeandroid_jenoa_LibDL_invokeDouble
  (JNIEnv *env, jobject instance, jlong handle, jlong dcHandle, jobjectArray params)
{
	DCpointer fp = (DCpointer) handle;
	DCCallVM *vm = (DCCallVM*) dcHandle;
	prepareDynCall (env, vm, params);
	return dcCallDouble (vm, fp);
}

JNIEXPORT void JNICALL Java_nativeandroid_jenoa_LibDL_invokeVoid
  (JNIEnv *env, jobject instance, jlong handle, jlong dcHandle, jobjectArray params)
{
	DCpointer fp = (DCpointer) handle;
	DCCallVM *vm = (DCCallVM*) dcHandle;
	prepareDynCall (env, vm, params);
	return dcCallVoid (vm, fp);
}

JNIEXPORT jlong JNICALL Java_nativeandroid_jenoa_LibDL_invokePointer
  (JNIEnv *env, jobject instance, jlong handle, jlong dcHandle, jobjectArray params)
{
	DCpointer fp = (DCpointer) handle;
	DCCallVM *vm = (DCCallVM*) dcHandle;
	prepareDynCall (env, vm, params);
	return (jlong) dcCallPointer (vm, fp);
}

JNIEXPORT jint JNICALL Java_nativeandroid_jenoa_Native_getPointerSize
  (JNIEnv *env, jclass cls)
{
	return (jint) sizeof (void*);
}

JNIEXPORT jint JNICALL Java_nativeandroid_jenoa_Native_getLongSize
  (JNIEnv *env, jclass cls)
{
	return (jint) sizeof (long);
}

JNIEXPORT jint JNICALL Java_nativeandroid_jenoa_Native_getWCharSize
  (JNIEnv *env, jclass cls)
{
	return (jint) sizeof (wchar_t);
}

JNIEXPORT jint JNICALL Java_nativeandroid_jenoa_Native_getSizeTSize
  (JNIEnv *env, jclass cls)
{
	return (jint) sizeof (size_t);
}

JNIEXPORT jlong JNICALL Java_nativeandroid_jenoa_Native_valueOfNullPointer
  (JNIEnv *env, jclass cls)
{
	return (jlong) NULL;
}
