package v3;

import java.util.ArrayList;
import java.util.Scanner;

public class biblioteca {
	ArrayList<Livro> catalogo = new ArrayList<>();
	public biblioteca() {
	}
	
	public void addLivro(Livro l) {
		catalogo.add(l);
	}
	
	public void showCatalog() {
		int maxSizeTitulo=0;
		int maxSizeAutor=0;
		int maxSizeEstado=0;
		
		for(Livro l : catalogo) {
			if(l.titulo().length()>maxSizeTitulo)
				maxSizeTitulo=l.titulo().length();
			
			if(l.autor().length()>maxSizeAutor)
				maxSizeAutor=l.autor().length();
			
			if(l.estado().length()>maxSizeEstado)
				maxSizeEstado=l.estado().length();
		}
		
		int counter=0;
		System.out.println("*** Biblioteca ***");
		for(Livro l:catalogo) {
			counter++;
               //alinhar 
			System.out.printf("%"+String.valueOf(Math.floor(catalogo.size()/10)).length()+"d\t%-"+maxSizeTitulo+"s\t%-"+maxSizeAutor+"s\t%-"+maxSizeEstado+"s\n", counter, l.titulo, l.autor(), l.estado());
		}
		System.out.println("<livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela");
		System.out.println("");
	}
	
	public ArrayList<Livro> getCatalogo(){
		return catalogo;
	}
	
	public void operacoes() {
		while(true) {
			showCatalog();
			System.out.print(">> ");
			Scanner sc = new Scanner(System.in);
			
			String resposta = sc.nextLine();
			String[] temp=resposta.split(",");
			if(temp.length!=2) {
				System.err.println("intoduza um comando do tipo <livro>,<operação>");
				continue;
			}
			
			Livro l = catalogo.get(Integer.valueOf(temp[0])-1);
			if(temp[1].equals("1")) {
				l.regista();
			}else if(temp[1].equals("2")){
				l.requisita();
			}else if(temp[1].equals("3")){
				l.devolve();
			}else if(temp[1].equals("4")){
				l.reserva();
			}else if(temp[1].equals("5")){
				l.cancelaReserva();
			}else{
				System.err.println("Esta operação não existe!");
				continue;
			}
		}
	}
}