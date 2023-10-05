public class PontoVerde extends pontoDecorator{
    PontoVerde(Geometria g){
        super();
    }
    @Override public void draw(){g.draw(); System.out.println("ponto verde");}
}
