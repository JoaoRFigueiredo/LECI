import java.util.ArrayList;
import java.util.List;


public class GeometriaComposta extends Entity implements Geometria{

    private List<Entity> children = new ArrayList<>();
    private int value;
    private int id;

    public GeometriaComposta(int value, int id){
        this.value = value;
        this.id = id;
    }

    public void add(Entity c){
        children.add(c);
    }

    public int getValue(){
        return value;
    }

    public void setValue(int newValue){
        this.value = newValue;
    }


    @Override
    public void draw() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    @Override
    public boolean isValid() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValid'");
    }

    @Override
    public void traverse() {
        // TODO Auto-generated method stub
        System.out.println("Drawing Multi-polygon"+id);
        //percorrer os children
        for (Entity x : children){
            if (!(x instanceof GeometriaComposta)){
                for (int i = 0; i<value*2; i++){
                    System.out.print(" ");
                }
                //x é um poigono ou ponto
                if (x instanceof Ponto){
                    Ponto p = (Ponto)x;
                    p.draw();
                }
                 if (x instanceof Poligono){
                    Poligono p = (Poligono)x;
                    p.draw();
                }
                
            }
            if (x instanceof GeometriaComposta){
                GeometriaComposta gc = (GeometriaComposta)x;
                for (int i = 0; i<gc.getValue()*2; i++){
                    System.out.print(" ");
                }
                gc.setValue(gc.getValue()+1);
                gc.traverse();
            }

            
            
        }
    }

    
    
}
