package aula10.Ex3;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<Character, HashSet<Integer>> mapa = new HashMap<>();

        System.out.println("Insira uma frase para ser processada");

        String frase = sc.nextLine();

        for (int i = 0; i<frase.length();  i++){
            char c = frase.charAt(i);
            if(!mapa.containsKey(c)){
                mapa.put(c, new HashSet<Integer>());
                mapa.get(c).add(i);
            }
            else{
                if(!mapa.get(c).contains(i)){
                    mapa.get(c).add(i);
                }
            }
        }

       System.out.println(mapa.entrySet());
        sc.close();
    }

    
    
}
