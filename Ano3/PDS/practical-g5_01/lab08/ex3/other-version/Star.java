import java.awt.*;
import startypes.*;

public class Star {
    private int x;
    private int y;
    private StarType type;

    public Star(int x, int y, StarType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics g) {
        this.type.draw(g, x, y);
    }
}
