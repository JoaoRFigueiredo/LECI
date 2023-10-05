import java.io.*;
import java.util.*;



public class Sopa {

    private ArrayList<String> rows = new ArrayList<>();
    private ArrayList<String> collumns = new ArrayList<>();
    private ArrayList<String> targetWords = new ArrayList<>();
    private int size;

    public Sopa(String name){
        try{
            if (!name.endsWith(".txt")){
                name = name + ".txt";
            }

            this.rows = puzzleToList(name);
            this.targetWords = wordsToBeFound(name);
            this.collumns = collumnsToList(name);
            this.size = rows.size();
            
        }catch(Exception e){
            System.err.format("Exception occurred trying to read '%s'.", name);
			e.printStackTrace();
			return;
        }
    }


    public ArrayList<String> wordsToBeFound(String fname) throws FileNotFoundException {
        Scanner fsc = new Scanner(new File(fname));
        ArrayList<String> words = new ArrayList<>();
    
        while (fsc.hasNextLine()) {
            String line = fsc.nextLine();
            if (line.isEmpty()) {
                throw new IllegalArgumentException("File contains empty lines.");
            }
            if (line.matches(".*[a-z].*")) {
                String[] pal = line.split("[,;\\s]+");
                for (String w : pal) {
                    if (w.matches("^[a-z]{3,}$") || w.matches("^[a-zA-Z]{2,}$")) {
                        boolean isDuplicate = false;
                        for (int i = 0; i < words.size(); i++) {
                            String word = words.get(i);
                            if (w.contains(word) && w.length() > word.length()) {
                                words.set(i, w);
                                isDuplicate = true;
                                break;
                            } else if (word.contains(w) && w.length() < word.length()) {
                                isDuplicate = true;
                                break;
                            }
                        }
                        if (!isDuplicate) {
                            words.add(w.toLowerCase());
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid word format: " + w +
                            "\nWords must contain at least 3 alphabetic characters.");
                    }
                }
            }
        }
        fsc.close();
        return words;
    }
    
    



    //Função que, dado um ficheiro (o nome), devolve as linhas da sopa/grid
    //já verifica se representa uma matriz quadrada e de carateres alfabéticos
    public ArrayList<String> puzzleToList(String fname) throws FileNotFoundException{
        Scanner fsc = new Scanner(new File(fname));
        ArrayList<String> puzzle = new ArrayList<>();
        while(fsc.hasNextLine()){
            //System.out.println(fsc.nextLine());
            String line = fsc.nextLine().trim();
            if (line.matches("[A-Z]+")){
                //System.out.print(line);
                puzzle.add(line);
            }
        }
        //System.out.println(puzzle);
        //System.out.println(puzzle.size());
        int height = puzzle.size();
        for (int i = 0; i<puzzle.size(); i++){
            if (puzzle.get(i).length() != height){
                throw new IllegalArgumentException("The puzzle is not square."+
                "\nThe row "+i+" has a length of "+puzzle.get(i).length()+" and the height is "+height+"!");
            }

            if (puzzle.get(i).matches(".*[a-z].*")) {
                throw new IllegalArgumentException("The puzzle contains lowercase letters." +
            "\nLowercase letter(s) found in row " + i + ".");
    }
            //System.out.println(puzzle.get(i).length());
        }
        fsc.close();
        return puzzle;
    }

    public ArrayList<String> collumnsToList(String name){
        ArrayList<String> collumns = new ArrayList<>();
        int width = this.rows.get(0).length();
        for (int col = 0; col < width; col++) {
            // initialize a new string for each column
            StringBuilder sb = new StringBuilder();
            // append the character from each row in the column to the string
            for (int row = 0; row < width; row++) {
                sb.append(this.rows.get(row).charAt(col));
            }
            collumns.add(sb.toString());
        }
        return collumns;
    }


    public ArrayList<String> getRows(){
        return rows;
    }

    public ArrayList<String> getTargetWords(){
        return targetWords;
    }

    public ArrayList<String> getCollumns(){
        return collumns;
    }

    public int getSize(){
        return size;
    }

    
}
