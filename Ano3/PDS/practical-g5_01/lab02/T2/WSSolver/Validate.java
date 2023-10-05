// package lab01.WSSolver;
import java.util.*;

public class Validate {
    
    ArrayList<String> ws = new ArrayList<String>();
    ArrayList<String> wordsToFind = new ArrayList<String>();

    char[][] puzzle;

    public Validate(ArrayList<String> ws, ArrayList<String> wordsToFind) {
        this.ws = ws;
        this.wordsToFind = wordsToFind;
        validateWS(ws);
        validateWordsToFind(wordsToFind);
        OrganizePuzzle(ws);
    }

    public void validateWS(ArrayList<String> ws) {

        boolean control = true;
        int size = ws.size()-1;
        int lenght1 = 0;
        int lenght2 = 0;
        
        while (control) {
            lenght1 = ws.get(size).length();
            lenght2 = ws.get(--size).length();
            if (lenght1 != lenght2) {
                System.err.println("ERROR: the puzzle must be a square!");
                System.exit(1);
            }
            
            if (size == 0) {
                control = false;
            }
        } 

        if ((ws.size() != lenght1 || lenght1 > 40)) {
            System.err.println("ERROR: the puzzle's size must be <=40 and only letters!");
            System.exit(1);
        }

        puzzle = new char[lenght1][lenght1];
    }

    public void OrganizePuzzle(ArrayList<String> ws) {
        for (int i = 0; i < ws.size(); i++) {
            String word = ws.get(i);
            for (int j = 0; j < word.length(); j++) {
                puzzle[i][j] = ws.get(i).charAt(j);
            }
        }
    }

    public void validateWordsToFind(ArrayList<String> wordsToFind) {

        for (String word : wordsToFind) {
            if (word.length() < 3) {
                System.err.println("ERROR: the word's size must >=3!");
                System.exit(1);
            }
        } 
    }

    public char[][] getPuzzle() {
        return puzzle;
    }
}