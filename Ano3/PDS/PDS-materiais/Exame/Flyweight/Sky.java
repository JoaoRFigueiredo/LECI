import javax.swing.*;

import startypes.StarType;
import startypes.StarTypeEnum;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sky extends JFrame {
    private Map<StarTypeEnum, Map<Integer, List<Integer>>> stars = new HashMap<>();

    public void placeStar(StarTypeEnum starType, int x, int y) {
        if (!stars.containsKey(starType))
            stars.put(starType, new HashMap<>());

        if (!stars.get(starType).containsKey(x))
            stars.get(starType).put(x, new ArrayList<>());

        stars.get(starType).get(x).add(y);
    }

    @Override
    public void paint(Graphics graphics) {
        for (StarTypeEnum starType : stars.keySet()) {
            StarType starT = starType.getStarBody();

            for (int starx : stars.get(starType).keySet()) {
                for (int stary : stars.get(starType).get(starx)) {
                    starT.setStarPosition(starx, stary);
                    starT.draw(graphics);
                }
            }
        }
    }
}