import java.util.Collection;

public class Originator<E> {
  private Collection<E> state;
  private CareTaker<E> careTaker;

  public Originator(Collection<E> state) {
    this.state = state;
    this.careTaker = new CareTaker<>();
  }

  public boolean add(E elem) {
    saveState();
    return state.add(elem);
  }

  public boolean remove(E elem) {
    saveState();
    return state.remove(elem);
  }

  public boolean undoState() {
    if (!careTaker.hasMemento())
      return false;

    setState(careTaker.getMemento().getState());
    return true;
  }

  public Collection<E> getState() {
    return state;
  }

  public void setState(Collection<E> state) {
    this.state = state;
  }

  private void saveState() {
    careTaker.addMemento(new Memento<>(state));
  }
}
