import java.util.ArrayList;

public class Poligono extends Entity implements Geometria {
    private ArrayList<Ponto> pontos;

    public Poligono(ArrayList<Ponto> pontos){
        this.pontos = pontos;
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub
        
        String out = "Drawing a polygon wih points: ";
        for (Ponto x : pontos){
            out += x.toString()+" ";
        }
        System.out.println(out);
    
    
    }
   
    

    @Override
    public boolean isValid() {
        // TODO Auto-generated method stub
        //poligono é válido se o primeiro e ultimo ponto forem iguais
        // e têm de ter um nº de pontos >=4
        if (pontos.size() > 3){
            //System.out.println("passou!");
            Ponto p0 = pontos.get(0);
            Ponto pN = pontos.get(pontos.size()-1);
            //System.out.println(p0.toString()+"||"+pN.toString());
            
            if (p0.getX() == pN.getX() && p0.getY() == pN.getY()){
                
                return true;
            }
        }
        return false;
    }

    @Override
    public void traverse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'traverse'");
    }
    
}
