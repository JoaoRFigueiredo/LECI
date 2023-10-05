package aula11.Ex2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Ex2 {

    public static void main(String[] args) throws IOException{
        List<String> companhias = Files.readAllLines(Paths.get("companhias.txt"));
        List<String> lista = Files.readAllLines(Paths.get("voos.txt"));


        HashMap<String, String> airlines = new HashMap<>();
        ArrayList<Voo> voos = new ArrayList<>();
        



        //Percorrer lista das companhias e guardár os pares (siglas, nome) num hashmap

            for (int i = 0; i<companhias.size(); i++){
                if(i == 0){continue;}
                String par = companhias.get(i);
                String[] arr = par.split("\t");
                airlines.put(arr[0], arr[1]);
            }
            
        
        
        
        //percorrer ficheiros dos voos e criar todos os objetos voos necessários
            for (int i = 0; i<lista.size(); i++){
                if(i == 0){continue;}
                String par = lista.get(i);
                String[] arr = par.split("\t");
                Tempo hora = new Tempo(arr[0]);
                String id = arr[1];
                String companhia = airlines.get(id.substring(0, 2));
                String origem = arr[2];
                Tempo atraso = new Tempo();
                if(arr.length > 3){
                    atraso = new Tempo(arr[3]);
                }
                Voo v = new Voo(hora, id, companhia, origem, atraso);
                voos.add(v);
            }

        
        


        System.out.println(airlines.size());
        System.out.println(voos.size());
        printFlights(voos);
        writeToFile("InfoPublico.txt", voos);
        showDelaysAverage(voos, airlines,  "Atrasos.txt");
        ShowCities(voos, "cidades.txt");
        
    }

    


   public static void writeToFile(String name, ArrayList<Voo> lst){
       File fin = new File(name);
       try {
        fin.createNewFile();
        FileWriter fw = new FileWriter(name);
        fw.write(String.format("%-8s%-10s%-19s%-24s%-9s%-15s\n","Hora", "voo", "Companhia", "Origem", "Atraso", "Obs" ));
        for (Voo v : lst){
            fw.write(v.toString()+"\n");
        }
        fw.close();
    } catch (IOException e) {
        
        System.out.println("Houve um erro!");
        e.printStackTrace();
    }
   }


    public static void printFlights(ArrayList<Voo> lst){
        System.out.printf("%-8s%-10s%-19s%-24s%-9s%-15s \n","Hora", "voo", "Companhia", "Origem", "Atraso", "Obs" );
        for (Voo v : lst){
            System.out.println(v);
        }
    }

    public static void showDelaysAverage(ArrayList<Voo> lst,HashMap<String, String> airlines, String name){ // imprimir as medias de atraso por companhia e escrever essa informação num ficheiro

        HashMap<String, Integer> delays = new HashMap<>();


        for(String str : airlines.values()){
            //System.out.println();
            int count = 0;
            int sum = 0;
            for(Voo v : lst){
                String nome = v.getCompanhia();
                if(nome.equalsIgnoreCase(str)){
                   if(v.getAtraso().Minutos() > 0){
                       count++;
                       sum += v.getAtraso().Minutos();
                   }
                }
                
            }
            //System.out.println(str+"/"+sum+"/"+count);
            if(count != 0){
                delays.put(str, sum/count);
            }
            else{
                delays.put(str, 0);
            }


        }
        ArrayList<Atraso> sortedDelays = new ArrayList<>();
        for(String k : delays.keySet()){
            Atraso at = new Atraso(k, delays.get(k));
            sortedDelays.add(at);
        }

        sortedDelays.sort((a1, a2) -> a1.compareTo(a2));
        
        
        File fin = new File(name);
        try {
         fin.createNewFile();
         FileWriter fw = new FileWriter(name);
         fw.write(String.format("%-20s%-20s\n", "Companhia", "Atraso médio(hh:mm)" ));
         for (Atraso at : sortedDelays){
            Tempo t = new Tempo(at.getMin());
            fw.write(String.format("%-20s%-20s\n", at.getCompanhia(), t.toString()));
        }
         fw.close();
     } catch (IOException e) {
         
         System.out.println("Houve um erro!");
         e.printStackTrace();
     }
        
        
        System.out.printf("%-20s%-20s\n", "Companhia", "Atraso médio(hh:mm)");
        for (Atraso at : sortedDelays){
            Tempo t = new Tempo(at.getMin());
            System.out.printf("%-20s%-20s\n", at.getCompanhia(), t.toString());
        }


       
    }

    public static void ShowCities(ArrayList<Voo> voos, String name){
        ArrayList<Cidade> cidades = new ArrayList<>();

        //1º loop para guardar cidades
        for (Voo v : voos){
            String nome = v.getOrigem();
            Cidade ct = new Cidade(nome);
            if(!cidades.contains(ct)){
                cidades.add(ct);
            }
            //System.out.println();
          
        }

        //2º loop para contar o numero de vezes para cada cidade
        for(Cidade c : cidades){
            for (Voo v : voos){
                if(c.getName().equals(v.getOrigem())){
                    c.increment();
                }
            }
        }

        //System.out.println(cidades);
        cidades.sort((a1, a2)-> a1.compareTo(a2));
        //System.out.println(cidades);

        File fin = new File(name);
        try {
         fin.createNewFile();
         FileWriter fw = new FileWriter(name);
         fw.write(String.format("%-20s%-20s\n", "Cidade", "Nº de vezes" ));
         for (Cidade at : cidades){
            
            fw.write(String.format("%-20s%-20d\n", at.getName(), at.getSum()));
        }
         fw.close();
     } catch (IOException e) {
         
         System.out.println("Houve um erro!");
         e.printStackTrace();
     }
      




    }




    
}
