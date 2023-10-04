import static java.lang.System.*;

public class PrintArgs {

  public static void main(String[] args) {
    printArray(args, 0);
  }

  /** Imprime as N primeiras strings do array, uma por linha. */
  public static void printArray(String[] array, int N) {
    // Implemente de forma recursiva...
    if(N < array.length){
			out.println(array[N]);
			printArray(array, N+1);
		}

  }

}

