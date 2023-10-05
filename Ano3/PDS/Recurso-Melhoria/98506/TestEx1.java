import java.util.ArrayList;

public class TestEx1 {

    public static void main(String[] args){
        ArrayList<Ponto> pontos = new ArrayList<>();
        ArrayList<Poligono> poligonos = new ArrayList<>();

        Geometrias2D g2d = new Geometrias2D();

        Ponto p1 = g2d.createPonto(0, 0);
        Ponto p2 = g2d.createPonto(0, 4);
        Ponto p3 = g2d.createPonto(4, 4);
        Ponto p4 = g2d.createPonto(4, 0);
        Ponto p5 = g2d.createPonto(2, 6);

       
        pontos.add(p1);pontos.add(p2);pontos.add(p3);pontos.add(p4);pontos.add(p5);

        ArrayList<Ponto> lst1 = new ArrayList<>();
        lst1.add(p2);lst1.add(p3);lst1.add(p4);lst1.add(p1);lst1.add(p2);

        ArrayList<Ponto> lst2 = new ArrayList<>();
        lst2.add(p1);lst2.add(p3);lst2.add(p5);lst2.add(p4);


        Poligono pol1 = g2d.createPoligono(lst1);
        Poligono pol2 = g2d.createPoligono(lst2);
        poligonos.add(pol1);
        poligonos.add(pol2);
        
        System.out.println("Alínea a)-------------------------------------------");
        for (Ponto x : pontos){
            //if (x.isValid()){
                x.draw();
            //}
        }

        for (Poligono pol : poligonos){
            
            
            if (pol.isValid()){
                pol.draw();
            }
            else{
                System.out.println("Polygon"+(poligonos.indexOf(pol)+1)+" is null");
            }
            
        }


        System.out.println("Alínea b)----------------------------------");

        GeometriaComposta gc1 = new GeometriaComposta(1,1);
        GeometriaComposta gc2 = new GeometriaComposta(1, 2);

        gc1.add(p1);
        gc1.add(p2);
        gc1.add(p3);
        
        gc2.add(pol1);
        gc2.add(gc1);
       

        gc1.traverse();
        gc2.traverse();
        
        
    }
    
}
