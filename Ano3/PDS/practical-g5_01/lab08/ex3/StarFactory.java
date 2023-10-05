import java.util.*;

public class StarFactory {
    private static Map<Character, StarType2> starTypes = new HashMap<>();

    public static StarType2 getStarType(char c, int x, int y){
        StarType2 starType = starTypes.get(c);

        if(starType == null){
            switch(c){
                case 'A':
                    starType = new AStar2();
                case 'B':
                    starType = new BStar2();
                case 'F':
                    starType = new FStar2();
                case 'G':
                    starType = new GStar2();
                case 'K':
                    starType = new KStar2();
                case 'M':
                    starType = new MStar2();
                case 'O':
                    starType = new OStar2();
            }
            starTypes.put(c, starType);
        }
        return starType;
    }
}
