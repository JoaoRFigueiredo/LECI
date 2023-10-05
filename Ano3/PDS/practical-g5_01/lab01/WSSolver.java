import java.util.*;
import java.io.*;




public class WSSolver {
    
    public static void main(String[] args) throws FileNotFoundException{
        Sopa s1 = new Sopa(args[0]);
        
       
        
        ArrayList<String> rows = s1.getRows();
        ArrayList<String> collumns = s1.getCollumns();
        ArrayList<String> targetWords = s1.getTargetWords();
        ArrayList<Word> answers = findWords(rows, collumns, targetWords);
        System.out.println("");
        // for (Word w : answers){
        //     System.out.println(w.getWord());
        // }
        //System.out.println(answers); 
        
        printSolvedGrid(answers, s1.getSize(), args[0]+"_solved");
    }



    public static void printSolvedGrid(ArrayList<Word> w, int size, String outFile){
        char[][] grid = new char[size][size];
        for (char[] row : grid){
            Arrays.fill(row, '.');
        }


        for (Word wd : w){
            System.out.println(wd);
        }

        for (Word wd : w){
            //System.out.println(wd.getWord());
            int len = wd.getSize();
            Coordinates coord = wd.getInitCoord();
            String direction = wd.getDirection();
            String wordString = wd.getWord();
            int r = coord.getX();
            int c = coord.getY();

            for (int i = 0; i<len; i++){
                
                grid[r][c] = Character.toUpperCase(wordString.charAt(i));
                switch (direction){
                    case "Up":
                    r--;
                    break;

                    case "Down":
                    r++;
                    break;

                    case "Right":
                    c++;
                    break;

                    case "Left":
                    c--;
                    break;

                    case "Up-left":
                    r--;
                    c--;
                    break;

                    case "Up-right":
                    r--;
                    c++;
                    break;

                    case "Down-left":
                    r++;
                    c--;
                    break;

                    case "Down-right":
                    r++;
                    c++;
                    break;

                }


            }
        }

        System.out.println("");

        //Imprimir a grid só com as palavras encontradas
        for (char[] row : grid){
            System.out.println(row);

        }


        //Write the list of words and solved grid to a txt file
        try{
            if (!outFile.endsWith(".txt")){
                outFile = outFile + ".txt";
            }
            File f = new File(outFile);
            if(!f.exists()){
            f.createNewFile();
            }

            PrintWriter pw = new PrintWriter(f);
            for (Word wd : w){
                pw.println(wd.toString());
            }
            pw.println();
            for (char[] row : grid){
                pw.println(row);
    
            }
    
            pw.close();
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }




        System.out.println("Chegámos ao fim!");
    }

    


    public static ArrayList<Word> findWords(ArrayList<String> puzzle, ArrayList<String> collumns , ArrayList<String> targetWords){

        ArrayList<Word> wordsFound = new ArrayList<>();
        
        int width = puzzle.get(0).length();
        // System.out.println("\n----------------------------");
        // System.out.println("Finding words horizontally!");
        // System.out.println("----------------------------");

        for (String word : targetWords) {
            // Loop over the rows in the puzzle grid
            int r = 0;
            for (String row : puzzle) {
                // Search for the word in the row, ignoring case

                if (row.toLowerCase().contains(word.toLowerCase())) {
                    //System.out.println("Found word " + word + " in row: " + row+", "+puzzle.indexOf(row));
                    int startingIndex = row.toLowerCase().indexOf(word.toLowerCase());
                    Coordinates coord = new Coordinates(r, startingIndex);
                    Word w = new Word(word, word.length(), "Right", coord);
                    wordsFound.add(w);
                    break; // stop searching this row once the word is found
                }
                else if (new StringBuilder(row).reverse().toString().toLowerCase().contains(word.toLowerCase())){
                    //System.out.println("Found word " + word + " in row: " + row+", "+puzzle.indexOf(row));
                    int startingIndex = (width-1) -new StringBuilder(row).reverse().toString().toLowerCase().indexOf(word.toLowerCase());
                    Coordinates coord = new Coordinates(r, startingIndex);
                    Word w = new Word(word, word.length(), "Left", coord);
                    wordsFound.add(w);
                    break; // stop searching this row once the word is found
                }
                r++;
            }
        

        // System.out.println("\n----------------------------");
        // System.out.println("Finding words vertically!");
        // System.out.println("----------------------------");


            int c = 0;
            for (String row : collumns) {
                // Search for the word in the row, ignoring case
                
                if (row.toLowerCase().contains(word.toLowerCase())) {
                    //System.out.println("Found word " + word + " in row: " + row +", "+collumns.indexOf(row));
                    int startingIndex = row.toLowerCase().indexOf(word.toLowerCase());
                    Coordinates coord = new Coordinates(startingIndex, c);
                    Word w = new Word(word, word.length(), "Down", coord);
                    wordsFound.add(w);
                    break; // stop searching this row once the word is found
                }
                else if (new StringBuilder(row).reverse().toString().toLowerCase().contains(word.toLowerCase())){
                    //System.out.println("Found word " + word + " in row: " + row+", "+collumns.indexOf(row));
                    int startingIndex = (width-1) -new StringBuilder(row).reverse().toString().toLowerCase().indexOf(word.toLowerCase());
                    Coordinates coord = new Coordinates(startingIndex, c);
                    Word w = new Word(word, word.length(), "Up", coord);
                    wordsFound.add(w);
                    break; // stop searching this row once the word is found
                }
                c++;
            }
        
        // System.out.println("\n----------------------------");
        // System.out.println("Finding words diagonally!");
        // System.out.println("----------------------------");
    
    
        // Find words diagonally
            for (int row = 0; row < width; row++) {
                for (int col = 0; col < width; col++) {
                    // Check diagonal down-right
                    StringBuilder sb1 = new StringBuilder();
                    r = row;
                    c = col;
                    while (r < width && c < width) {
                        sb1.append(puzzle.get(r).charAt(c));
                        if (sb1.toString().toLowerCase().equals(word.toLowerCase())) {
                            //System.out.println("Found word " + word + " in diagonal down-right: " + sb1 + ", starting at (" + row + "," + col + ")");
                            Coordinates coord = new Coordinates(row, col);
                            Word w = new Word(word, word.length(), "Down-right", coord);
                            wordsFound.add(w);
                        }
                        r++;
                        c++;
                    }
        
                    // Check diagonal up-right
                    StringBuilder sb2 = new StringBuilder();
                    r = row;
                    c = col;
                    while (r >= 0 && c < width) {
                        sb2.append(puzzle.get(r).charAt(c));
                        if (sb2.toString().toLowerCase().equals(word.toLowerCase())) {
                            //System.out.println("Found word " + word + " in diagonal up-right: " + sb2 + ", starting at (" + row + "," + col + ")");
                            Coordinates coord = new Coordinates(row, col);
                            Word w = new Word(word, word.length(), "Up-right", coord);
                            wordsFound.add(w);
                        }
                        r--;
                        c++;
                    }
                    
                    // Check diagonal down-left
                    StringBuilder sb3 = new StringBuilder();
                    r = row;
                    c = col;
                    while (r < width && c >= 0) {
                        sb3.append(puzzle.get(r).charAt(c));
                        if (sb3.toString().toLowerCase().equals(word.toLowerCase())) {
                            //System.out.println("Found word " + word + " in diagonal down-left: " + sb3 + ", starting at (" + row + "," + col + ")");
                            Coordinates coord = new Coordinates(row, col);
                            Word w = new Word(word, word.length(), "Down-left", coord);
                            wordsFound.add(w);
                        }
                        r++;
                        c--;
                    }
        
                    // Check diagonal up-left
                    StringBuilder sb4 = new StringBuilder();
                    r = row;
                    c = col;
                    while (r >= 0 && c >= 0) {
                        sb4.append(puzzle.get(r).charAt(c));
                        if (sb4.toString().toLowerCase().equals(word.toLowerCase())) {
                            //System.out.println("Found word " + word + " in diagonal up-left: " + sb4 + ", starting at (" + row + "," + col + ")");
                            Coordinates coord = new Coordinates(row, col);
                            Word w = new Word(word, word.length(), "Up-left", coord);
                            wordsFound.add(w);
                        }
                        r--;
                        c--;
                    }
                }
            }
        }

        return wordsFound;
    }
}
    

