import static java.lang.System.*;

public class Fibonacci {

  public static void main(String[] args) {
    if (args.length < 1) {
      out.println("USO: java -ea Fibonacci N [N ...]");
      exit(1);
    }
   int n = Integer.parseInt(args[0]);
    // Alguns testes:
    assert fibonacci(0) == 0;
    assert fibonacci(1) == 1;
    assert fibonacci(2) == 1;
    assert fibonacci(5) == 5;
    
    for(int i = 0; i<= n; i++){//Mostras todos os resultados da funçai fibonacci de 0 ate o numero n
      System.out.printf("fibonacci(%d) = %d \n", i, fib(i));
    }


    for(int i = 0; i < args.length; i++) {
       long time = nanoTime();  // System.nanoTime() gives the time in ns.
      int f = fibonacci(n);
      time = nanoTime() - time;
      out.printf("fibonacci(%d) = %d (%d ns)\n", n, f, time);
    }
     
     
    

  }

  public static int fibonacci(int n) {
    assert n >= 0 : "O <n> tem de pertencer ao conjunto dos numeros inteiros de (0 --- +infinito) ";
    //...
    int resultado = 0;
    if (n == 0) return 0;
    if(n == 1) return 1;
    if (n >= 2) 
    resultado = (fibonacci(n -2) + fibonacci(n -1));
    return resultado;
     
    


  }
  
  static int fib(int n) 
    { 
    int f[] = new int[n+2];
    f[0] = 0;
    f[1] = 1;
    for (int i = 2; i<=n; i++){
      f[i] = f[i-2] + f[i-1];
    }
    return f[n];


    }

}
