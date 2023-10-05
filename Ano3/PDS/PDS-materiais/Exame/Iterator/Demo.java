import java.util.Iterator;
import java.util.ListIterator;

public class Demo {
  public static void main(String[] args) {
    VectorGeneric<Integer> vec = new VectorGeneric<>();

    for (int i = 0; i < 10; i++)
      vec.addElem(i);

    Iterator<Integer> it1 = vec.Iterator();
    Iterator<Integer> it2 = vec.Iterator();
    Iterator<Integer> it3 = vec.Iterator();
    ListIterator<Integer> it4 = vec.listIterator();
    ListIterator<Integer> it5 = vec.listIterator(4);

    while (true) {
      printNext("it1", it1);
      printNext("it2", it2);
      printNext("it3", it3);
      printNext("it4", it4);
      printNext("it5", it5);

      if (!it1.hasNext() && !it2.hasNext() && !it3.hasNext() && !it4.hasNext() && !it5.hasNext())
        break;
    }
  }

  private static void printNext(String itName, Iterator<Integer> it) {
    if (it.hasNext())
      System.out.println(String.format("Iterator '%s' tem o valor '%d'", itName, it.next()));
    else
      System.out.println(String.format("Iterator '%s' já chegou ao fim", itName));
  }

}
