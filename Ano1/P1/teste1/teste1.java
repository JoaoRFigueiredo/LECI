import java.util.Scanner;


public class teste1{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        
        double[] a = {1, 2, 3, 40, 10, 7};
        int pos = xMaximo(a);
        System.out.println(pos);
        
        
    }


    public static double lerNumero(String mensagem){
        System.out.println(mensagem);
        double num = sc.nextDouble();
        return num;
    }

    public static int lerFuncao(double[] funcao) {
        System.out.println("Insira numeros: ");
        
        int pontos = 1;
        double num = sc.nextDouble();
        funcao[0] = num;

        for ( int i = 1; i<funcao.length; i++){
            double n = sc.nextDouble();
            funcao[i] = n;
            pontos++;
            if (funcao[i] == 0 && funcao[i-1] == 0){
               
                pontos = pontos-2;
                 break; 
            }

        }

    
        if (pontos < 0){
            pontos = 0;
        }

        return pontos; // numero de pontos
            
        }



        public static double[] f(double xI, double xF, int np) {// calcula np pontos de funçao num dado intervalo
            double deltaX = xF-xI;
            double[] p = new double[np]; // array para armazenar os vários x para dps calcular o seu sen
            double x = deltaX/np;
            p[0] = xI;
            double xSeguinte = xI + x;
            for (int i = 1; i< np; i++){
                
                p[i] = xSeguinte;
                xSeguinte += x;
            }

            double[] resultado = new double[np];
            for (int i = 0; i<np; i++){
                resultado[i] = Math.sin(p[i]);
            }
            return resultado;
        }

        public static int xMaximo(double[] arr){
            double max = arr[0];
            int pos = 0;
            for (int i = 0; i<arr.length; i++){
                if (arr[i] > max ){
                    max = arr[i];
                    pos = i;
                }
            }

             return pos;
        }




 }
