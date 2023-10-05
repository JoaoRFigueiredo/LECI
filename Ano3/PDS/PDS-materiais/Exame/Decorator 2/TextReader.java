package v2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextReader implements Filter {

  public Scanner sc;

  public TextReader(String fileName) throws FileNotFoundException {
    sc = new Scanner(new File(fileName));
  }

  @Override
  public boolean hasNext() {
    // TODO Auto-generated method stub
    return sc.hasNext();
  }

  @Override
  public String next() {
    // TODO Auto-generated method stub
    return sc.nextLine();
  }

}