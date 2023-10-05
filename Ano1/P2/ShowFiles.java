/*Elementos do grupo:
Filipe Freixo, nº mec 98471
Joao Figueiredo, nº mec 98506
Luiz Figueiredo, nº 
*/


import static java.lang.System.*;
import java.io.*;

public class ShowFiles{
    public static void main(String[] args) {
        if(args.length != 1){
			out.println("Argumento inválido");
			exit(1);
		}
		File dir = new File(args[0]);
		printListOfDirectories(dir);
	}
	
	static void printListOfDirectories(File file){
		
		out.println(file.getPath()); // devolve a path do ficheiro com o nome introduzido como argumento
		if(file.isDirectory()){
			File[] dir = file.listFiles();// Se o ficheiro for um diretorio, listará todos os ficheiros no mesmo diretório de forma recursivas
			for(File f : dir){
				printListOfDirectories(f);
			}
		}
	}
    }
