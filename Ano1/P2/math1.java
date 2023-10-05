
public class math1 {
    public static void main(String[] args) {
  int n = Integer.parseInt(args[0]);
  
System.out.printf("(recursiva) O termo "+n+" e o seguinte %d", s(n) );
System.out.printf("\n(iterativa) O termo "+n+" e o seguinte %d", f(n) );
        
    }

    // metodo recursivo
    public static int s(int n) {
            assert n>= 0 : "Tem de ser maior que 0 oh seu merdas";
            int result;
            /*if (n==0) result = 1;
            else if (n ==1) result = 2;
            else result = s(n-1)*s(n-2);
            return result;*/

            if ( n== 0 || n ==1) result = n+1;
            else result = s(n-1)*s(n-2);
            return result;
    
    
          }
    



    //metodo iterativo
    public static int f(int n){

        assert n>=0 :"fds";
        
       


        int previouspreviousNumber, previousNumber = 1, currentNumber = 2;

        for (int i = 1; i < n ; i++) {

            previouspreviousNumber = previousNumber;

            previousNumber = currentNumber;

            currentNumber = previouspreviousNumber * previousNumber;

        }
        return currentNumber;
    }
}