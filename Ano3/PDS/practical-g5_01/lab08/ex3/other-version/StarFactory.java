import java.util.Map;
import java.util.HashMap;
import java.awt.*;

import  startypes.*;

public class StarFactory{
    private  static Map<Character, StarType> starMap = new HashMap<>();

    public static StarType getStarType(Character c, int x, int y ){
        StarType st = starMap.get(c);
        if (st == null){
            switch(c){
                case 'A':
                st = new AStar();
               
                break;

                case 'B':
                st = new BStar();
                
                break;


                case 'F':
                st = new FStar();
                
                break;

                case 'G':
                st = new GStar();
                
                break;

                case 'K':
                st = new KStar();
                
                break;

                case 'M':
                st = new MStar();
                
                break;

                case 'O':
                st = new OStar();
                
                break;

                default:
                break;
            }
            starMap.put(c, st);
            
        }
        return st;

    }

    
}