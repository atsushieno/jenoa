default:
	ls dyncall/*/build_out/*/*.a > dyncalllibs.lst
	gcc -fPIC -I/usr/lib/jvm/default-java/include/ -I . -L /usr/lib/jvm/default-java/lib -c jenoa.c -ldl
	gcc -shared -o libjenoa.so jenoa.o @dyncalllibs.lst

update-jni-headers:
	CLASSPATH=../bin javah -o jenoa.h nativeandroid.jenoa.LibDL

