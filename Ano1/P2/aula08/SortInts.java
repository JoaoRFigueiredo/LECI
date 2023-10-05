import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;

public class SortInts
{
  public static void main(String[] args) throws IOException {
    if ( args.length == 0){
      out.println("Usage: java -ea SortInts file .... ");
    }

    SortedListInt numbers = new SortedListInt();


    for (String s : args){
      File fich = new File(s);
      assert fich.isFile();
      numbers = insertNumbers(numbers, new Scanner(fich));
      assert numbers.isSorted();

    }
    printList(numbers);


  }

  static SortedListInt insertNumbers(SortedListInt numbers, Scanner read){
    if (!read.hasNext())
	  {
		  return numbers;
	  }
	  
	  try //se for numero inteiro, insere na lista
	  {
		  int elem = Integer.parseInt(read.nextLine());
		  numbers.insert(elem);
	  }
	  catch (NumberFormatException e) 
	  {
		  // caso contrário, não é inteiro, logo exception
	  }
	  return insertNumbers(numbers, read);
  }
  
  public static void printList(SortedListInt l)
  {
	  if (l.size() > 0)
	  {
		  System.out.println(l.first());
		  l.removeFirst();
		  printList(l);
	  }
	  else
	  {
		  return;
	  }
  }
  static {  // A static block. Cool!
    boolean ea = false;
    assert ea = true; // assert with a side-effect, on purpose!
    if (!ea) 
    {
      err.println("Usage: java -ea SortInts file1 ...");
      exit(1);
    }
}

}


