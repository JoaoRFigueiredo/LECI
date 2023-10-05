package v3;

public class mainf {
     public static void main(String[] args) {
          biblioteca Bert=new biblioteca();
		
		Livro l1=new Livro("Livro generico de culinaria", "Gajo do Masterchef", 111111111, 1000);
		Livro l2=new Livro("A biblia", "josue de nazare", 222222222, 0000);
		Livro l3=new Livro("Monarquia e o pq da rainha isabel ser incrivel", "rainha isabel", 333333333, 1920);
		Livro l4=new Livro("of the bored", "eu", 192345678, 2021);
		
		Bert.addLivro(l1);
		Bert.addLivro(l2);
		Bert.addLivro(l3);
		Bert.addLivro(l4);
		
		Bert.operacoes();
     }
}
