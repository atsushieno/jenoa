package nativeandroid.jenoa.ptr;

import nativeandroid.jenoa.*;

public class NativeLongByReference extends ByReference {

	NativeLong value;

	public NativeLongByReference() {
		this(new NativeLong(0));
	}

	public NativeLongByReference(NativeLong value) {
		super(NativeLong.SIZE);
		setValue(value);
	}

	public void setValue(NativeLong value) {
		this.value = value;
	}

	public NativeLong getValue() {
		return value;
	}
}
