

#include "jenoa.h"
#include <locale.h>
#include <dlfcn.h>

char *last_error = NULL;

char * update_last_error ()
{
	if (last_error)
		free (last_error);
	char *err = dlerror ();
	last_error = err == NULL ? NULL : strdup (err);
	return last_error;
}

JNIEXPORT void JNICALL Java_nativeandroid_jenoa_LibDL_init_1libdl
  (JNIEnv *env, jclass cls)
{
	setlocale (LC_ALL, "C");
}

JNIEXPORT void JNICALL Java_nativeandroid_jenoa_LibDL_cleanup_1libdl
  (JNIEnv *env, jclass cls)
{
	if (last_error != NULL)
		free (last_error);
}

JNIEXPORT jlong JNICALL Java_nativeandroid_jenoa_LibDL_dlopen
  (JNIEnv *env, jobject instance, jstring name, jint mode)
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
  (JNIEnv *env, jobject instance)
{
	return last_error ? (*env)->NewStringUTF (env, last_error) : NULL;
}

JNIEXPORT jint JNICALL Java_nativeandroid_jenoa_LibDL_dlclose
  (JNIEnv *env, jobject instance, jlong ptr)
{
	jint ret = (jint) dlclose ((void*) ptr);
	last_error = update_last_error ();
	return ret;
}

JNIEXPORT jlong JNICALL Java_nativeandroid_jenoa_LibDL_dlsym
  (JNIEnv *env, jobject instance, jlong handle, jstring name)
{
	jboolean isCopy;
	const char *nameChars = (*env)->GetStringUTFChars (env, name, &isCopy);
	jlong ret = (jlong) dlsym ((void*) handle, nameChars);
	last_error = update_last_error ();
	if (isCopy)
		(*env)->ReleaseStringUTFChars (env, name, nameChars);
	return ret;
}
