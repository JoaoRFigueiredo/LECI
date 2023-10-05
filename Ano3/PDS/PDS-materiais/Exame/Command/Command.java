public interface Command<E> {
  public void execute(Originator<E> col);
}