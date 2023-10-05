// package lab02.WSSolver;
import java.io.*;
import java.util.*;


public class WSSolver {

    public static FileWriter result;
    public static void main(String[] args) throws IOException {
        
        if(args.length == 0) {
            System.err.println("ERROR: Must input an argumment!");
            System.exit(0);
        }

        ArrayList<String> ws = new ArrayList<String>();
        ArrayList<String> wordsToFind = new ArrayList<String>();

        ReadData.read(args[0]);
        String number = (args[0]).replaceAll("[^0-9]", "");//extrate number from input file to use it in the output
        ws = ReadData.getWs();
        wordsToFind = ReadData.getWordsToFind();
        Validate validate = new Validate(ws, wordsToFind);
        char[][] puzzle = validate.getPuzzle();
        Solve.solve(wordsToFind,puzzle);
        Show.print(number,puzzle, Solve.getWords(),wordsToFind);
    }
}