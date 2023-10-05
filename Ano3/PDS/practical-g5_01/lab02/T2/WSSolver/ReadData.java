// package lab01.WSSolver;
import java.util.*;
import java.io.*;

public class ReadData {
    
    String filename;
    static String word;
    static ArrayList<String> ws = new ArrayList<String>();
    static ArrayList<String> wordsToFind = new ArrayList<String>();
    
    public static void read(String filename) throws FileNotFoundException {
        
        try {
            
            
            Scanner scanner = new Scanner(new FileReader(filename)).useDelimiter("\n|\\s|,|;");
            while (scanner.hasNext()) {
                word = scanner.next();
                boolean upCase = true;
                
                if (word == null || word.isEmpty()) {
                    System.err.println("ERRO: empty file");
                    System.exit(0);
                }
 
                for (int a = 0; a < word.length(); a++) {
                    Character character = word.charAt(a);
                    
                    if (!Character.isUpperCase(character)) {
                        upCase = false;
                    }
                }

                
                if (upCase == true){
                    ws.add(word); 
                } 
                else if (upCase == false) {
                    wordsToFind.add(word);
                }
            }
            scanner.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("ERROR: file not found!");
            System.exit(0);
        }  
    }

    public static ArrayList<String> getWs() {
        return ws;
    }

    public static ArrayList<String> getWordsToFind() {
        return wordsToFind;
    }
}