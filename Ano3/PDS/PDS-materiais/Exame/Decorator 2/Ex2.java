package v2;
import java.io.FileNotFoundException;

public class Ex2 {
  public static void main(String[] args) throws FileNotFoundException {
    Filter reader = new NormalizationFilter(new TextReader("text.txt"));
    reader = new CapitalizationFilter(new VowelFilter(new TermFilter(new TextReader("text.txt"))));
    System.out.println(reader.next());
  }
}
