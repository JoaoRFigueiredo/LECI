package aula12.Ex2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class Ex2 {

    public static void main(String[] args) throws IOException{
    List<String> lst = Files.readAllLines(Paths.get("movies.txt"));
    ArrayList<Movie> filmes = new ArrayList<>();
    Set<String> set = new HashSet<>();
    

    for (int i = 0; i<lst.size(); i++){
        if(i == 0){
            continue;
        }
        String str = lst.get(i);
        String[] arr = str.split("\t");
        
        Movie m = new Movie(arr[0], Double.parseDouble(arr[1]), arr[2], arr[3], Integer.parseInt(arr[4]));
        filmes.add(m);
        set.add(arr[3]);
    }

    //sorted by name
    //ordem decrescente de score
    System.out.println("------------------------------------------------------------------------------------");
    System.out.println("-----------------------Ordenado por nome-------------------------------------------");
    System.out.println("------------------------------------------------------------------------------------");
    

    filmes.sort((a1 ,a2) -> a1.getName().compareToIgnoreCase(a2.getName()));
    System.out.printf("%-40s%-20s%-20s%-20s%-20s\n", "Name", "Score","Rating", "Genre", "Running Time");
    for (Movie m : filmes){
        System.out.println(m);
    }

    //ordem decrescente de score
    System.out.println("------------------------------------------------------------------------------------");
    System.out.println("-----------------------Ordem Decrescente de score-----------------------------------");
    System.out.println("------------------------------------------------------------------------------------");
    
    filmes.sort((a1, a2)-> Double.compare(a2.getScore(), a1.getScore()));
    System.out.printf("%-40s%-20s%-20s%-20s%-20s\n", "Name", "Score","Rating", "Genre", "Running Time");
    for (Movie m : filmes){
        System.out.println(m);
    }

    //ordem decrescente de score
    System.out.println("------------------------------------------------------------------------------------");
    System.out.println("-----------------------Ordem crescente de running time-----------------------------------");
    System.out.println("------------------------------------------------------------------------------------");
    
    filmes.sort((a1, a2)-> Integer.compare(a1.getTime(), a2.getTime()));
    System.out.printf("%-40s%-20s%-20s%-20s%-20s\n", "Name", "Score","Rating", "Genre", "Running Time");
    for (Movie m : filmes){
        System.out.println(m);
    }


    System.out.println("\nGéneros existentes:");
    System.out.println(set);


    //filmes com um score superior a 60 e que pertençamao género comedy para um ficheiro

    File f = new File("myselection.txt");
    f.createNewFile();
    PrintWriter pw = new PrintWriter(f);
    pw.write(String.format("%-40s%-20s%-20s%-20s%-20s\n", "Name", "Score","Rating", "Genre", "Running Time"));
    for (Movie m : filmes){
        if(m.getScore() > 60 && m.getGenre().equalsIgnoreCase("Comedy")){
            pw.write(m.toString()+"\n");
        }
    }
    pw.close();

}
}
