package nativeandroid.jenoa.ptr;

public class IntByReference extends ByReference {

	int value;

	public IntByReference() {
		this((int) 0);
	}

	public IntByReference(int value) {
		super(4);
		setValue(value);
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
