package nativeandroid.jenoa.ptr;

public class LongByReference extends ByReference {

	long value;

	public LongByReference() {
		this((long) 0);
	}

	public LongByReference(long value) {
		super(8);
		setValue(value);
	}

	public void setValue(long value) {
		this.value = value;
	}

	public long getValue() {
		return value;
	}
}
