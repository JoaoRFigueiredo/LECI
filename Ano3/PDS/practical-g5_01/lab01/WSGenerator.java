import java.util.*;
import java.io.*;

public class WSGenerator {

    static ArrayList<String> wordsPlaced = new ArrayList<>();
    
    public static void main(String[] args){
        String fileName = "";
        int size = 0;
        String fout = "";

        for (int i = 0; i<args.length; i++){
            if (args[i].equals("-i")){
                fileName = args[i+1];
            }
            else if (args[i].equals("-s")){
                size = Integer.parseInt(args[i+1]);
            }
            else if(args[i].equals("-o")){
                fout = args[i+1];
            }
        }

        

        char[][] grid = new char[size][size];
        ArrayList<String> wordsToBePlaced = getWordsToBePlaced(fileName);//target words
        grid = placeWords(grid, wordsToBePlaced); //sopa de letras
        //System.out.println("List of words: "+wordsToBePlaced);
        printSopaWithWords(grid, wordsToBePlaced);
        if (args.length == 6){
            solutionToFile(fout, wordsPlaced, grid);
        }
        

    }












    public static void solutionToFile(String fout, ArrayList<String> words, char[][] grid){
        try{
            if (!fout.endsWith("txt")){
                fout += ".txt";
            }
            File f = new File(fout);
            PrintWriter pw = new PrintWriter(f);

            for (char[] row : grid){
                pw.println(row);
            }

            pw.println();

            for (String w : words){
                pw.println(w);
            }


            pw.close();
        }
        catch(Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void printSopa(char[][] grid){
        for (char[] row : grid){
            System.out.println(row);
        }
    }
    public static void printSopaWithWords(char[][] grid, ArrayList<String> words){
        Random rand = new Random();
        //as palavras já foram colocadas, agora falta popular o resto do array para parecer uma sopa de letras
        char randomLetter = (char)(rand.nextInt(26) + 'A');
        for(int i = 0; i<grid.length; i++){
            for(int y = 0; y<grid.length; y++){
                if(grid[i][y] == '\u0000' || grid[i][y] == '.'){
                    grid[i][y] = randomLetter;
                }
                randomLetter = (char)(rand.nextInt(26) + 'A');
            }
        }


        printSopa(grid);
        for(String w : words){
            System.out.println(w);
        }
    }

    public static ArrayList<String> getWordsToBePlaced(String fname){
        ArrayList<String> words = new ArrayList<>();
        try{
            if (!fname.endsWith(".txt")){
                fname = fname + ".txt";
            }
            File f = new File(fname);
            Scanner fsc = new Scanner(f);
            while(fsc.hasNextLine()){
                String line = fsc.nextLine();
                //System.out.println(line);
                if (line.matches(".*[a-z].*")){
                    //System.out.println(line);
                    String[] pal = line.split("[,;\\s]+");
                    for (String w : pal){
                        //System.out.println(w);
                        words.add(w);
                    }
                } 
            }
            fsc.close();;
        }catch(Exception e){
            System.err.format("Exception occurred trying to read '%s'.", fname);
			e.printStackTrace();
        }

        return words;

    }

    //Para um dada lista de palavras, vai posicioná-las na grid de forma aleatória, quanto à/ao direção/sentido
    public static char[][]placeWords(char[][] grid,  ArrayList<String> words){
        Random rand = new Random();
        for (String w : words){

            int row, col, direction;
            boolean placed = false;


            while(!placed){
                row = rand.nextInt(grid.length);
                col = rand.nextInt(grid[0].length);
                int r = row, c = col;
                direction = rand.nextInt(8);//0->down, 1->up, 2->left, 3->right, 4->up-right, 5->up-left, 6->down-right, 7->down-left


                boolean fits = false;
                boolean clear = true;

                switch (direction){

                    case 0://down

                        if (row + w.length() <= grid.length){
                            fits = true;
                            //verificar se a palavra pode ser escrita(verificar se já não há outra)
                            for (int i = 0; i<w.length(); i++){
                                if(grid[row+i][col] != '\u0000' && grid[row+i][col] != w.charAt(i)) { 
                                        fits = false;
                                        clear = false;
                                        break;    
                                }
                                else if (grid[row+i][col] != '\u0000'){
                                    clear = false;
                                    break;
                                }
                            }

                            //se chegarmos aqui, é porque é possível por a palavra
                            if(fits && clear){
                            for (int i = 0; i<w.length(); i++){
                                grid[row+i][col] = Character.toUpperCase(w.charAt(i));
                            }
                            placed = true;
                            // Word wd = new Word(w, w.length(), "Down", new Coordinates(r, c));
                            wordsPlaced.add(w);
                        }
                        }

                    break;

                    case 1://up
                        if (row - w.length() >= -1){
                            fits = true;
                            //verificar se a palavra pode ser escrita(verificar se já não há outra)
                            for (int i = 0; i<w.length(); i++){
                                if(grid[row-i][col] != '\u0000' && grid[row-i][col] != w.charAt(i)) { 
                                        fits = false;
                                        clear = false;
                                        break;    
                                }
                                else if (grid[row-i][col] != '\u0000'){
                                    clear = false;
                                    break;
                                }
                            }

                            //se chegarmos aqui, é porque é possível por a palavra
                            if(fits && clear){
                            for (int i = 0; i<w.length(); i++){
                                grid[row-i][col] = Character.toUpperCase(w.charAt(i));
                            }
                        }
                        placed = true;
                        // Word wd = new Word(w, w.length(), "Up", new Coordinates(r, c));
                        wordsPlaced.add(w);
                    }

                    break;

                    case 2://left
                        if (col - w.length() >= -1){
                            fits = true;
                            //verificar se a palavra pode ser escrita(verificar se já não há outra)
                            for (int i = 0; i<w.length(); i++){
                                if(grid[row][col-i] != '\u0000' && grid[row][col-i] != w.charAt(i)) { 
                                        fits = false;
                                        clear = false;
                                        break;    
                                }
                                else if (grid[row][col-i] != '\u0000'){
                                    clear = false;
                                    break;
                                }
                            }

                            //se chegarmos aqui, é porque é possível por a palavra
                            if(fits && clear){
                            for (int i = 0; i<w.length(); i++){
                                grid[row][col-i] = Character.toUpperCase(w.charAt(i));
                            }
                            placed = true;
                            // Word wd = new Word(w, w.length(), "Left", new Coordinates(r, c));
                            wordsPlaced.add(w);
                        }
                        }   

                    break;

                    case 3://right
                        if (col + w.length() <=grid.length){
                            fits = true;
                            //verificar se a palavra pode ser escrita(verificar se já não há outra)
                            for (int i = 0; i<w.length(); i++){
                                if(grid[row][col+i] != '\u0000' && grid[row][col+i] != w.charAt(i)) { 
                                        fits = false;
                                        clear = false;
                                        break;    
                                }
                                else if (grid[row][col+i] != '\u0000'){
                                    clear = false;
                                    break;
                                }
                            }

                            //se chegarmos aqui, é porque é possível por a palavra
                            if(fits && clear){
                            for (int i = 0; i<w.length(); i++){
                                grid[row][col+i] = Character.toUpperCase(w.charAt(i));
                            }
                            placed = true;
                            // Word wd = new Word(w, w.length(), "Right", new Coordinates(r, c));
                        wordsPlaced.add(w);
                        }
                        }  


                    break;

                    case 4://up-right
                    if (row - w.length() >= 0 && col + w.length() <= grid.length){
                        fits = true;
                        //verificar se a palavra pode ser escrita(verificar se já não há outra)
                        for (int i = 0; i<w.length(); i++){
                            if(grid[row-i][col+i] != '\u0000' && grid[row-i][col+i] != w.charAt(i)) { 
                                    fits = false;
                                    clear = false;
                                    break;    
                            }
                            else if (grid[row-i][col+i] != '\u0000'){
                                clear = false;
                                break;
                            }
                        }

                        //se chegarmos aqui, é porque é possível por a palavra
                        if(fits && clear){
                        for (int i = 0; i<w.length(); i++){
                            grid[row-i][col+i] = Character.toUpperCase(w.charAt(i));
                        }
                        placed = true;
                        // Word wd = new Word(w, w.length(), "Up-right", new Coordinates(r, c));
                        wordsPlaced.add(w);
                    }
                    }  


                    break;

                    case 5://up-left
                    if (row - w.length() >= 0 && col - w.length() >= -1){
                        fits = true;
                        //verificar se a palavra pode ser escrita(verificar se já não há outra)
                        for (int i = 0; i<w.length(); i++){
                            if(grid[row-i][col-i] != '\u0000' && grid[row-i][col-i] != w.charAt(i)) { 
                                    fits = false;
                                    clear = false;
                                    break;    
                            }
                            else if (grid[row-i][col-i] != '\u0000'){
                                clear = false;
                                break;
                            }
                        }

                        //se chegarmos aqui, é porque é possível por a palavra
                        if(fits && clear){
                        for (int i = 0; i<w.length(); i++){
                            grid[row-i][col-i] = Character.toUpperCase(w.charAt(i));
                        }
                        placed = true;
                        // Word wd = new Word(w, w.length(), "Up-left", new Coordinates(r, c));
                        wordsPlaced.add(w);
                    }
                    }

                    break;

                    case 6://down-right

                    if (row + w.length() <= grid.length && col + w.length() <= grid.length){
                        fits = true;
                        //verificar se a palavra pode ser escrita(verificar se já não há outra)
                        for (int i = 0; i<w.length(); i++){
                            if(grid[row+i][col+i] != '\u0000' && grid[row+i][col+i] != w.charAt(i)) { 
                                    fits = false;
                                    clear = false;
                                    break;    
                            }
                            else if (grid[row+i][col+i] != '\u0000'){
                                clear = false;
                                break;
                            }
                        }

                        //se chegarmos aqui, é porque é possível por a palavra
                        if(fits && clear){
                        for (int i = 0; i<w.length(); i++){
                            grid[row+i][col+i] = Character.toUpperCase(w.charAt(i));
                        }
                        placed = true;
                        // Word wd = new Word(w, w.length(), "Down-right", new Coordinates(r, c));
                        wordsPlaced.add(w);
                    }
                    }

                    break;

                    case 7://down-left

                    if (row + w.length() <= grid.length && col - w.length() >= -1){
                        fits = true;
                        //verificar se a palavra pode ser escrita(verificar se já não há outra)
                        for (int i = 0; i<w.length(); i++){
                            if(grid[row+i][col-i] != '.' && grid[row+i][col-i] != w.charAt(i)) { 
                                    fits = false;
                                    clear = false;
                                    break;    
                            }
                            else if (grid[row+i][col-i] != '.'){
                                clear = false;
                                break;
                            }
                        }

                        //se chegarmos aqui, é porque é possível por a palavra
                        if(fits && clear){
                        for (int i = 0; i<w.length(); i++){
                            grid[row+i][col-i] = Character.toUpperCase(w.charAt(i));
                        }
                        placed = true;
                        // Word wd = new Word(w, w.length(), "Down-left", new Coordinates(r, c));
                        wordsPlaced.add(w);
                    }
                    }

                    break;
                }
            }


        }


        //as palavras já foram colocadas, agora só falta colocar pontos para podermos "ver" a sopa de letras

        for (char[] row : grid){
            for (int i = 0; i<row.length; i++){
                if(row[i] == '\u0000'){
                row[i] = '.';
                }
            }
        }

        // printSopa(grid);
        


        return grid;
    }



    
}
