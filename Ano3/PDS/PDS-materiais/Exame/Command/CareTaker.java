import java.util.Stack;

public class CareTaker<E> {
  private Stack<Memento<E>> savedStates = new Stack<>();

  public void addMemento(Memento<E> m) {
    savedStates.push(m);
  }

  public boolean hasMemento() {
    return savedStates.isEmpty();
  }

  public Memento<E> getMemento() {
    return savedStates.pop();
  }
}
