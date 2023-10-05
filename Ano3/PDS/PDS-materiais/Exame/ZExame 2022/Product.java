
public interface Product {
	String code();
	String description();
	double points();
    void setState(State s);
	State getState();
}
