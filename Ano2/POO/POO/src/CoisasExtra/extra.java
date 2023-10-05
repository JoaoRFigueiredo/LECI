package CoisasExtra;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class extra {

    public static void main(String[] args) throws IOException{
   
        List<Integer> lst = new ArrayList<>();
        // Código que adiciona 1000 elementos na lista
        // Acrescente aqui o código que permita ordenar a lista lst
        for (int i = 0; i<1000; i++){
            lst.add((int)(Math.random() * 100) * i);
        }

        lst.sort((a1, a2)->Integer.compare(a1, a2));
        
        lst.forEach(System.out::println);
        
        String[] vec = new String[] { "once", "upon", "a", "time", "in", "Aveiro" };
        // Acrescente aqui o código que permita ordenar o vetor vec
        Arrays.sort(vec);
        
        for (String s : vec) System.out.println(s);
        



    }
    
}
