package aula12.Ex1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Ex1 {

     public static void main(String[] args) throws FileNotFoundException {
        
        countWords("words.txt");
        
    }

    public static void countWords(String fname) throws FileNotFoundException{
        Set<String> set = new HashSet<>();
        int total = 0;
        

        Scanner sc = new Scanner(new FileReader(fname));
        sc.useDelimiter("[\\p{Punct}\\s]+");
        while(sc.hasNext()){
            total++;
            String word = sc.next();
            set.add(word);

        }

        sc.close();
        System.out.println("Número total de palavras: "+total);
        System.out.println("Número palavras diferentes: "+set.size());
    }
    
}
