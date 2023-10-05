package v2;
public class TermFilter implements Filter {

  private String[] wordList = new String[0];
  private int currentPosition = 0;

  @Override
  public boolean hasNext() {
    // TODO Auto-generated method stub
    return (currentPosition >= wordList.length || this.hasNext());
  }

  @Override
  public String next() {
    // TODO Auto-generated method stub
    currentPosition++;

    if (currentPosition >= wordList.length) {
      if (!base.hasNext())
        return null;

      wordList = base.next().split(" ");
      currentPosition = 0;
    }

    return wordList[currentPosition];
  }

}
