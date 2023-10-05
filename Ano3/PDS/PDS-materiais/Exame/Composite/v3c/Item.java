package v3.v3c;


public abstract class Item {
	protected static StringBuffer indent = new StringBuffer();
	public abstract String print();
	public abstract float getweight();
}