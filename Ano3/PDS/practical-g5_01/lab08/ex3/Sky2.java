import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Sky2 extends JFrame {
    private List<Star> stars = new ArrayList<>();

    public void placeStar(char c, int x, int y) {
        StarType2 starType = StarFactory.getStarType(c, x, y);
        Star star = new Star(x, y, starType);
        stars.add(star);
    }

    @Override
    public void paint(Graphics graphics) {
        for (Star star : stars) {
            star.draw(graphics);
        }
    }
}