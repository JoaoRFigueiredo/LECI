public class UndoCommand<E> implements Command<E> {

  @Override
  public void execute(Originator<E> col) {
    // TODO Auto-generated method stub
    col.undoState();
  }

}
