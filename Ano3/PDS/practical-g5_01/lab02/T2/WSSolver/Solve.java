// package lab01.WSSolver;
import java.util.ArrayList;
import java.util.Hashtable;

public class Solve {

    // criar arrays para guardar a palavra encontrada e a direção
    static ArrayList<Word> wordsRIGHT = new ArrayList<Word>();  
    static ArrayList<Word> wordsLEFT = new ArrayList<Word>();
    static ArrayList<Word> wordsDOWN = new ArrayList<Word>();
    static ArrayList<Word> wordsUP = new ArrayList<Word>();
    static ArrayList<Word> wordsDOWNRIGHT = new ArrayList<Word>();
    static ArrayList<Word> wordsUPLEFT = new ArrayList<Word>();
    static ArrayList<Word> wordsDOWNLEFT = new ArrayList<Word>();
    static ArrayList<Word> wordsUPRIGHT = new ArrayList<Word>();
    static Hashtable<Directions, ArrayList<Word>> words = new Hashtable<Directions, ArrayList<Word>>();

    // procura as palavras no puzzle (por isto de forma mais otimizada: por exemplo se ja encontrar a palavra na direção RIGHT nao precisa de procurar mais)
    public static void solve(ArrayList<String> wordsToFind, char[][] WS) {
        for(String s: wordsToFind) {
            findRIGHT(WS, s,0,1);
            findLEFT(WS, s,0,-1);
            findDOWN(WS, s,1,0);
            findUP(WS, s,-1,0);
            findDOWNRIGHT(WS, s,1,1);
            findUPLEFT(WS, s, -1, -1);
            findDOWNLEFT(WS, s, 1, -1);
            findUPRIGHT(WS, s,-1, 1);
        }
    }

    // procura as palavras na direção RIGHT
    public static void findRIGHT(char[][] WS, String wordToFind, int movex, int movey) {
        for (int i=0; i < WS.length; i++){
            for (int j=0; j < WS.length; j++) {
                procura(WS, wordToFind, i, j, movex, movey, wordsRIGHT, Directions.RIGHT);
                
            }
        }
    }

    // procura as palavras na direção LEFT
    public static void findLEFT(char[][] WS, String wordToFind, int movex, int movey) {
        for (int i=0; i < WS.length; i++){
            for (int j=0; j < WS.length; j++) {
                procura(WS, wordToFind, i, j, movex, movey, wordsLEFT, Directions.LEFT);
                
            }
        }
    }

    // procura as palavras na direção DOWN
    public static void findDOWN(char[][] WS, String wordToFind, int movex, int movey) {    
        for (int i=0; i < WS.length; i++){
            for (int j=0; j < WS.length; j++) {
                procura(WS, wordToFind, i, j, movex, movey, wordsDOWN, Directions.DOWN);
                
            }
        }
    }

    // procura as palavras na direção UP
    public static void findUP(char[][] WS, String wordToFind, int movex, int movey) { 
            for (int i=0; i < WS.length; i++){
                for (int j=0; j < WS.length; j++) {
                    procura(WS, wordToFind, i, j, movex, movey, wordsUP, Directions.UP);
                    
                }
            }
        
    }

    // procura as palavras na direção DOWNRIGHT
    public static void findDOWNRIGHT(char[][] WS, String wordToFind, int movex, int movey){
        for (int i=0; i < WS.length; i++){
            for (int j=0; j < WS.length; j++) {
                procura(WS, wordToFind, i, j, movex, movey, wordsDOWNRIGHT, Directions.DOWNRIGHT);
            }
        }
    }

    // procura as palavras na direção UPLEFT
    public static void findUPLEFT(char[][] WS, String wordToFind, int movex, int movey) {
        for (int i=WS.length-1; i >= 0 ; i--){
            for (int j=WS.length-1; j >= 0; j--) {
                procura(WS, wordToFind, i, j, movex, movey, wordsUPLEFT, Directions.UPLEFT);
                
            }
        }
    }

    // procura as palavras na direção DOWNLEFT
    public static void findDOWNLEFT(char[][] WS, String wordToFind,int movex, int movey) {
        for (int i=0; i < WS.length; i++){
            for (int j=0; j < WS.length; j++) {
                procura(WS, wordToFind, i, j, movex, movey, wordsDOWNLEFT, Directions.DOWNLEFT);
            }
        }
    }

    // procura as palavras na direção UPRIGHT
    public static void findUPRIGHT(char[][] WS, String wordToFind,int movex, int movey) {
        for (int i=WS.length-1; i >= 0 ; i--){
            for (int j=WS.length-1; j >= 0; j--) {
                procura(WS, wordToFind, i, j, movex, movey, wordsUPRIGHT, Directions.UPRIGHT);
            }
        }
    }

    static public void procura(char[][] WS, String wordToFind, int i, int j, int movex, int movey, ArrayList<Word> array, Directions direcao){
        if (WS[i][j] == wordToFind.toUpperCase().charAt(0)) {   // se a primeira letra da palavra for igual a primeira letra da palavra a procurar
            int x=i,y=j;
            
            StringBuilder sb = new StringBuilder();
            sb.append(WS[i][j]);                            // adiciona a primeira letra da palavra
            int posX = i+movex;
            int posY = j+movey;
            for(int o = 1; o < wordToFind.length(); o++) {
                if (posX < 0 || posX >= WS.length || posY< 0 || posY >= WS.length) {
                    break;
                }
                if (WS[posX][posY] != wordToFind.toUpperCase().charAt(o)) {
                    break;
                }
                sb.append(WS[posX][posY]);                    // vai adicionando as letras da palavra
                
                if (sb.toString().equals(wordToFind.toUpperCase())) {
                    int[][] pos = new int[1][2];
                    pos[0][0] = x+1;                        // guarda a posição inicial da palavra
                    pos[0][1] = y+1;                        // guarda a posição inicial da palavra
                    Word Word = new Word(wordToFind,wordToFind.length(),pos, direcao);
                    array.add(Word);
                    words.put(direcao, array);
                    break;
                }
                posX += movex;
                posY += movey;
            }
        }
    }

   
    public static Hashtable<Directions, ArrayList<Word>> getWords() {
        return words;
    }
}