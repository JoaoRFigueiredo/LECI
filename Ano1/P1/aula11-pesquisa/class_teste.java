import java.util.Scanner;
import java.io.*;


public class class_teste {

    public static void main(String[] args) throws IOException {

        File fin = new File("Alunos.txt");
        Scanner fich = new Scanner(fin);
        ola[] arr = new ola[9];

        int i = 0;
        while(fich.hasNextLine()){

            String[] s = fich.nextLine().split(" ");
            arr[i] = new ola();
            arr[i].numero = Integer.parseInt(s[0]);
            arr[i].nome = s[1];
            i++;
        }
        int l = arr.length;
        for ( int j =0; j<l; j++){
            System.out.println(arr[j].numero +" " +arr[j].nome);
        }
    }
    
}

class ola{
    int numero;
    String nome;
}
