import java.io.*;
import java.util.Scanner;

import java.util.HashMap;


public class ex4 {

    private static HashMap<String, Integer> mapa;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //passar as associações (num, num por extenso)
        mapa = new HashMap<>();
        mapa = getNumbers(mapa, "numbers.txt");

        //obter a frase traduzida 
        String result = translate(sc);
        System.out.println(result);
        
    }


    public static String translate(Scanner sc){
        String translated = "";

        while(sc.hasNext()){
            String word = sc.next();
            String[] arr = word.split("[-\\s]");

            if (arr.length > 1){
                for(String w : arr){
                    if (mapa.containsKey(w)){
                        translated += mapa.get(w)+" ";
                    }
                    else{
                        translated += w+" ";
                    }
                }
            }

            else{
            if (mapa.containsKey(arr[0])){
                translated += mapa.get(arr[0])+" ";
            }
            else{
                translated += arr[0]+" ";
            }
            }
        }
        

        return translated;
    }



    public static HashMap<String, Integer> getNumbers(HashMap<String, Integer> mapa, String filename){
        Scanner fsc;
        try{
            File fin = new File(filename);
            fsc = new Scanner(fin);
            while(fsc.hasNext()){

                String[] elements = fsc.nextLine().split(" - ");
                mapa.put(elements[1], Integer.parseInt(elements[0]));
            }

            fsc.close();

        }
        catch(Exception e){
            e.printStackTrace();

        }



        return mapa;
    }
    
}
