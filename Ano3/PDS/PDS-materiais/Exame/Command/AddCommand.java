public class AddCommand<E> implements Command<E> {

  private E element;

  public AddCommand(E element) {
    this.element = element;
  }

  @Override
  public void execute(Originator<E> col) {
    // TODO Auto-generated method stub
    col.add(element);
  }

}
