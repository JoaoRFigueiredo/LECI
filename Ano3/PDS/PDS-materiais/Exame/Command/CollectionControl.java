import java.util.Collection;

public class CollectionControl<E> {
  private Originator<E> originator;

  public CollectionControl(Originator<E> originator) {
    this.originator = originator;
  }

  public void execute(Command<E> c) {
    c.execute(originator);
  }

  public Collection<E> getOriginator() {
    return this.originator.getState();
  }

}
