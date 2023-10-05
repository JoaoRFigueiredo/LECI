package aula05;

public class Ex53 {

    public static void main(String[] args){
        Ponto p1 = new Ponto(1.3, 5.2);
        Ponto p2 = new Ponto(0, 0);
        Retangulo r1 = new Retangulo(6, 4);
        Circulo c1 = new Circulo(p2, 5);
        Circulo c2 = new Circulo(p1, 10);
        Triangulo t1 = new Triangulo(3, 4, 5);
        //Pontos
        System.out.println("-------------------------Pontos-----------------------");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println("Distance between points 1 and 2: "+p1.distanceTo(p2));
        System.out.println("\n----------------------------Circulos--------------------------");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println("Do the circles intersact each other? "+c1.intersect(c2));
        System.out.println("\n------------------------Retangulos----------------------");
        System.out.println(r1.toString());
        System.out.println("\n-------------------------Triangulos-------------------------");
        System.out.println(t1.toString());
        

    }
    
}
