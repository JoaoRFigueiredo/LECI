import java.util.ArrayList;

public class Geometrias2D {
    //aplicar factory aqui
    Ponto createPonto(double x, double y){
        return new Ponto(x, y);
    }

    Poligono createPoligono(ArrayList<Ponto> pontos){
        return new Poligono(pontos);
    }
    
}
