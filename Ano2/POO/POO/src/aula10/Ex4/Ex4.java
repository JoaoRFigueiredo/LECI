package aula10.Ex4;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Ex4 {

    public static void main(String[] args) throws IOException{
        ArrayList<String> palavras = new ArrayList<>(); // arraylist para guardar as palavras
        
        
        Scanner input = new Scanner(new FileReader("words.txt"));
        while (input.hasNext()) {
        String word = input.next();
        palavras.add(word);
        System.out.println(word);
        }
        

        System.out.println("Palavras com mais de 2 carateres:");
        for (String str : palavras){
            if(str.length() > 2){
                System.out.println(str);
            }

        }

        System.out.println("Palavras que terminem em 's':");
        for (String str : palavras){
            if(str.toLowerCase().endsWith("s")){
                System.out.println(str);
            }

        }

        System.out.println("Palavras que só possuam letras:");
        for (String str : palavras){
            if(str.toLowerCase().matches("[a-zA-Z]+")){
                System.out.println(str);
            }

        }


    }
    
}
