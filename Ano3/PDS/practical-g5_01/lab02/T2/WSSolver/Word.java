// package lab02.WSSolver;

public class Word {
    
    private String word;
    private int size;
    private int[][] initPos = new int[1][2];
    private Directions direction;

    public Word(String word, int size, int[][] posicaoInicial, Directions direcao) {
        this.word = word;
        this.size = size;
        this.initPos = posicaoInicial;
        this.direction = direcao;
    }

    public String getWord() {
        return word;
    }

    public int getSize() {
        return size;
    }

    public Directions getDirections() {
        return direction;
    }

    public int[][] getInitPos() {
        return initPos;
    }
}