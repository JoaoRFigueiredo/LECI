import java.util.Collection;

public class Memento<E> {
  private Collection<E> state;

  public Memento(Collection<E> state) {
    this.state = state;
  }

  public Collection<E> getState() {
    return this.state;
  }

}
