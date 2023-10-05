// package lab01.WSGenerator;

import java.io.*;
import java.util.*;

public class WSGenerator {
    public static FileWriter outputFile;
    public static void main(String[] args) throws IOException {

        Boolean position = false;
        int dir = 0, iniPosiX = 0, iniPosiY= 0, movex = 0, movey = 0, a = 0;
        int soupSize = 0;
        String file1 = "", file2 = "";

        ArrayList<String> wordToFind = new ArrayList<String>(); 

        if(args.length == 0) {
            System.err.println("ERROR: Must input an argumment!");
            System.exit(0);
        }

        if(Arrays.stream(args).anyMatch("-i"::equals) == false) {
            System.err.println("ERROR: Must Input a file!");
            System.exit(0);
        }

        if(Arrays.stream(args).anyMatch("-s"::equals) == false) {
            System.err.println("ERROR: Must Input a size for the soup!");
            System.exit(0);
        }

        for (String option : args) {
            switch (option) {
                case "-i":
                    a++;
                    if (args[a] == "-o" || args[a] == "-s"){
                        System.err.println("Error: Enter a valid input file!");
                        System.exit(0);
                    }
                    file1 = args[a];
                    break;

                case "-s": 
                    a++;
                    if (args[a] == "-o" || Integer.parseInt(args[a])> 41){
                        System.err.println("Error: Enter a valid size, should be minor than 41!");
                        System.exit(0);
                    }
                    soupSize = Integer.parseInt(args[a]);
                    break;

                case "-o":
                    a++;
                    file2 = args[a];
                    break;

                default:
                    a++;
                    break;
            }
        }


        char[][] WS = new char[soupSize][soupSize];

        for (int i=0; i < WS.length; i++) {
            for(int j=0; j < WS.length; j++) {
                WS[i][j] = ' ';
            }
        }

        ReadData.read(file1);

        wordToFind = ReadData.getWordsToFind();
        for(String word :wordToFind){
            
            do{
                dir= randomPosition(0, 7);
                iniPosiX= randomPosition(soupSize, 0);
                iniPosiY= randomPosition(soupSize, 0);
                movex = 0;
                movey = 0;

                switch(dir) {
                    
                    case 0:
                        movex = 0;
                        movey = 1;
                        break;

                    case 1:
                        movex = 0;
                        movey = -1;
                        break;
                    
                    case 2:
                        movex = 1;
                        movey = 0;
                        break;

                    case 3:
                        movex = -1;
                        movey = 0; 
                        break;

                    case 4:
                        movex = 1;
                        movey = 1;
                        break; 

                    case 5:
                        movex = -1;
                        movey = -1;
                        break;
                        
                    case 6:
                        movex = 1;
                        movey = -1;
                        break;

                    case 7:
                        movex = -1;
                        movey = 1;
                        break;
                    
                    default:
                        break;
                }
                position= verifPosition(WS,word,iniPosiX,iniPosiY,movex,movey);
            
            }
            while(position == false);

            int posX = iniPosiX;
            int posY = iniPosiY;
            for(int o = 0; o < word.length(); o++) {
                WS[posX][posY] = word.toUpperCase().charAt(o);
                
                posX += movex;
                posY += movey;
            }
        }

        for (int i=0; i < WS.length; i++) {
            for(int j=0; j < WS.length; j++) {
                if(WS[i][j] == ' '){
                        WS[i][j] = randomChar();
                }
            }
        }


        if(file2.equals("")) {
            for (char[] line : WS) {
                for(char letter:line) {
                    System.out.print(letter);
                }
                System.out.println();
                
            } 
            for(String s : ReadData.original()) {
                    System.out.print(s);
                    System.out.print("\n");
            }
        }
        else {
            File file  = new File(file2);
            file.createNewFile();
            outputFile = new FileWriter(file);
            for (char[] line : WS) {
                for(char letter:line) {
                    outputFile.write(letter);
                }
                outputFile.write("\n");
            } 

            for(String s : ReadData.original()) {
                outputFile.write(s);
                outputFile.write("\n");
            }
            outputFile.close();
        }
    }


    private static char randomChar() {
        Random r = new Random();
        return (char)(r.nextInt(26) + 'A');
    }
    private static int randomPosition(int max, int min) {
       
        int num = (int)Math.floor(Math.random() * (max - min + 1) + min);
        return num;
    }

    private static boolean verifPosition(char[][] WS, String word, int iniPosiX, int iniPosiY, int movex, int movey){
        int posX = iniPosiX;
        int posY = iniPosiY;
        for(int o = 0; o < word.length(); o++) {
            if (posX < 0 || posX >= WS.length || posY< 0 || posY >= WS.length) {
                return false;
            }
            if (WS[posX][posY] != ' ' && WS[posX][posY] != word.toUpperCase().charAt(o)) {
                return false;
            }
            posX += movex;
            posY += movey;
        }
        return true;
    }
    
}
