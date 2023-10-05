// package lab01.WSGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadData {
    
    String filename;
    static String word;
    static ArrayList<String> wordsToFind = new ArrayList<String>();
    
    static ArrayList<String> original = new ArrayList<String>();

    public static void read(String filename) throws IOException {
        
        try {
            Scanner scanner = new Scanner(new FileReader(filename)).useDelimiter("\n|\\s|,|;");
            while (scanner.hasNext()) {
                String word =scanner.next();

                if(word.length()<3){
                    System.err.println("ERROR: word size not vallid!");
                    System.exit(0);
                }
                if (word == null || word.isEmpty()) {
                    System.err.println("ERRO: empty file");
                    System.exit(0);
                }
                wordsToFind.add(word);
            }
            scanner.close();
            Scanner scanner2 = new Scanner(new FileReader(filename));
            while (scanner2.hasNext()) {
                String red = scanner2.nextLine();
                original.add(red);
            }
            scanner2.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("ERROR: file not found!");
            System.exit(0);
        }  
    }

    public static ArrayList<String> getWordsToFind() {
        return wordsToFind;
    }    
    
    public static ArrayList<String> original() {
        return original;
    }
}