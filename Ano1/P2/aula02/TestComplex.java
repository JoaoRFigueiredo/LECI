import static java.lang.System.*;
import java.util.*;


public class TestComplex {
	private static  double re;
	private static  double im;
  // Exemplo simples de utilização da class Complex
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
	  
	  if (args.length >= 2){
      re = Double.parseDouble(args[0]);
      im = Double.parseDouble(args[1]);
   }
   else if (args.length == 1){// so um argumento, logo so sabemos a parte real e perguntamos pela imaginaria
      re = Double.parseDouble(args[0]);
      System.out.print("Im: ");
      im = sc.nextDouble();
   }
   else {
     System.out.print("re: ");
     re = sc.nextDouble();
     System.out.print("im: ");
     im = sc.nextDouble();
   }

    Complex a = new Complex(re, im);
    

    // Vamos usar métodos do objeto a
    out.printf("(%.2f+%.2fi)\n", a.real(), a.imag());
    out.println("  parte real = " + a.real());
    out.println("  parte imaginaria = " + a.imag());
    out.println("  modulo = " + a.abs());
    out.printf("  argumento = %.2f\n", a.arg());
  }

}

