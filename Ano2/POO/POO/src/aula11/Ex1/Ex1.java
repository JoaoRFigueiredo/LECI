package aula11.Ex1;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class Ex1{

    public static void main(String[] args) throws IOException{
        String rgex = "[\\t\\n\\.\\,\\:\\'\\‘\\’\\;\\?\\!\\-\\*\\{\\}\\=\\+\\&\\/\\(\\)\\[\\]\\”\\“\\\"\\']";
        ArrayList<String> lst;
        lst =loadwords(rgex, "major.txt");

        HashMap<String, HashMap<String, Integer>> mapa = new HashMap<>();

        for (int i = 0; i<lst.size()-1; i++){
            String current = lst.get(i);
            String next = lst.get(i+1);
            if(!mapa.containsKey(current)){
               HashMap<String, Integer> h = new HashMap<>();
               h.put(next, 1);
               mapa.put(current, h);
            }
            else{
                if(mapa.get(current).containsKey(next)){
                    int number = mapa.get(current).get(next);
                    mapa.get(current).replace(next, number, number+1);
                }
                else{
                    mapa.get(current).put(next, 1);
                }


            }
        }
        for(int i = 0; i < mapa.size(); i++) {
			System.out.println(mapa.entrySet().toArray()[i].toString());
			
		}     

        
    }

    public static ArrayList<String> loadwords( String rgx, String fname) throws IOException{
        ArrayList<String> lst = new ArrayList<>();
        Scanner sc = new Scanner(new FileReader(fname));
        String words ="";
        while(sc.hasNext()){
            words += sc.next();
        }

        words.replaceAll("\\s+", "");
        words = words.trim();

        String[] arr = words.split(rgx);
        for(String word : arr){
            if(word.length() > 2){
                lst.add(word);
            }
        }
        sc.close();
        return lst;
    }
}
