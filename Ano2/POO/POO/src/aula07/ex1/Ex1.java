package aula07.ex1;

public class Ex1 {
    
    public static void main(String[] args){
        Circulo c1 = new Circulo(new Ponto(1, 4), 5, "Vermelho");
        Circulo c2 = new Circulo(new Ponto(1, 4), 5, "Preto");
        
        Retangulo r1 = new Retangulo(5, 2, "Verde");
        Retangulo r2 = new Retangulo(5, 2, "Amarelo");
        
        Triangulo t1 = new Triangulo(2, 4, 3, "Roxo");
        Triangulo t2 = new Triangulo(5, 3, 4, "Rosa");


        System.out.println("Triangulos");
        System.out.println(t1.toString());
        System.out.println("---------------------");
        System.out.println(t2.toString());

        System.out.println("|||||||||||||||||||||||||||||||||||||");
        
        System.out.println("Retangulos");
        System.out.println(r1.toString());
        System.out.println("---------------------");
        System.out.println(r2.toString());

        System.out.println("||||||||||||||||||||||||||||||||||||||||||||");

        
        System.out.println("Circulos");
        System.out.println(c1.toString());
        System.out.println("---------------------");
        System.out.println(c2.toString());
    }
}
