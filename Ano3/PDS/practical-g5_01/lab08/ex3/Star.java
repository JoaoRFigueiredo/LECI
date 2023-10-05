import java.awt.Graphics;

public class Star {
    private int x;
    private int y;
    private StarType2 type;

    public Star(int x, int y, StarType2 starType){
        this.x = x;
        this.y = y;
        this.type = starType;
    }

    public void draw(Graphics g){
        this.type.draw(g, x, y);
    }
}
