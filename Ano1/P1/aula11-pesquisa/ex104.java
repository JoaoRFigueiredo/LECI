import java.util.Scanner;
import java.io.*;

public class ex104 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Insira o nome do ficheiro");
        String nome = sc.next();

        File fin = new File(nome);

        int i = 0;
        Aluno[] arr = new Aluno[9];

        Scanner fich = new Scanner(fin);
        
        while(fich.hasNextLine() || i <arr.length){
            String l = fich.nextLine();
            String[] partes = l.split(" ");
            arr[i] = new Aluno();
            arr[i].numero = Integer.parseInt(partes[0]);
            arr[i].nome = partes[1];
            i++;
            
         }

         fich.close();

         int n;

         do{
             System.out.println("Insira um numero: ");
             n = sc.nextInt();
             for (int k = 0; k<arr.length; k++){
                 if (n == arr[k].numero){
                     System.out.println(arr[k].numero + " " + arr[k].nome);
                     break;
                 }
             }
         }while(n != 0);


        // for ( int j = 0; j<arr.length; j++){
            
          //  System.out.println(arr[j].numero +" "+ arr[j].nome);
         //}
         


    }

   

    
    
}

class Aluno{
    int numero;
    String nome;
}
