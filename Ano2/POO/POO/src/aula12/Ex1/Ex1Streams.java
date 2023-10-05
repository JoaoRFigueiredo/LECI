package aula12.Ex1;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex1Streams {

    //versão do ex1 com streams
    
    public static void main(String[] args) throws IOException {
        
        countWords("words.txt");
        
    }

    public static void countWords(String fname) throws IOException{
        Path p = Paths.get(fname);
        Set<String> set = new HashSet<>();
        List<String> words = Files.readAllLines(p).stream()
                                                  .flatMap(s -> Arrays.stream(s.split("[\\p{Punct}\\s]+")))
                                                  .collect(Collectors.toList());

         words.stream().forEach(s -> set.add(s));


        System.out.println("Número total de palavras: "+words.size());
        System.out.println("Número palavras diferentes: "+set.size());
    }





}
