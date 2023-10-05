public class DeleteCommand<E> implements Command<E> {

  private E element;

  public DeleteCommand(E element) {
    this.element = element;
  }

  @Override
  public void execute(Originator<E> col) {
    // TODO Auto-generated method stub
    col.remove(element);
  }

}
