// package lab01.WSSolver;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class Show {

    public static FileWriter result;

    public static void print(String number, char[][] WS, Hashtable<Directions, ArrayList<Word>> words, ArrayList<String> wordsToFind) throws IOException {

        char[][] solution = new char[WS.length][WS.length];
        
        File file  = new File("sopa" + number + "_result.txt");
        file.createNewFile();
        result = new FileWriter(file);

        for(int i = 0; i < solution.length; i++) {
            for(int j = 0; j < solution.length; j++) {
                solution[i][j] = '.';
            }
        }
        
        for(Directions d: words.keySet()) {
            for(Word w: words.get(d)) {
                
                int movex=0;
                int movey=0;
                
                switch(w.getDirections()) {
                    case RIGHT:
                        movex = 0;
                        movey = 1;
                        break;
    
                    case LEFT:
                        movex = 0;
                        movey = -1;
                        break;
                    
                    case DOWN:
                        movex = 1;
                        movey = 0;
                        break;

                    case UP:
                        movex = -1;
                        movey = 0; 
                        break;
    
                    case DOWNRIGHT:
                        movex = 1;
                        movey = 1;
                        break; 
    
                    case UPLEFT:
                        movex = -1;
                        movey = -1;
                        break;
                        
                    case DOWNLEFT:
                        movex = 1;
                        movey = -1;
                        break;
    
                    case UPRIGHT:
                        movex = -1;
                        movey = 1;
                        break;
                    
                    default:
                        break;
                }

                int posX = (w.getInitPos())[0][0]-1;
                int posY = (w.getInitPos())[0][1]-1;
                
                String word = w.getWord();
                for(int o = 0; o < word.length(); o++) {
                    
                    if (posX < 0 || posX >= WS.length || posY< 0 || posY >= WS.length) {
                        break;
                    }
                            
                    solution[posX][posY] = word.toUpperCase().charAt(o);
                    posX += movex;
                    posY += movey; 
                }
            }
        }
        
        for(String s:wordsToFind){
            for(Directions d: words.keySet()) {
                for(Word w: words.get(d)) {
                    if(s.equals(w.getWord())){
                        result.write(String.format("%-11s \t %-3d \t %2d,%-2d \t %-10s %n", w.getWord(), w.getSize(), w.getInitPos()[0][0],w.getInitPos()[0][1], w.getDirections()));
                        System.out.format("%-11s \t %-3d \t %2d,%-2d \t %-10s %n", w.getWord(), w.getSize(), w.getInitPos()[0][0],w.getInitPos()[0][1], w.getDirections());
                    }
                }
            }
        }

        for(char[] linha : solution) {
            for (char a:linha) {
                result.write(a + " ");
                System.out.print(a + " ");
            }
            result.write("\n");
            System.out.println();
        } 

        result.close();
    }
}