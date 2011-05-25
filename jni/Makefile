default:
	gcc -fPIC -I/usr/lib/jvm/default-java/include/ -I . -L /usr/lib/jvm/default-java/lib -c jnitest.c -ldl
	gcc -shared -o libjnitest.so jnitest.o

update-jni-headers:
	CLASSPATH=../bin javah -o jenoa.h nativeandroid.jenoa.LibDL
