package aula10.Ex2;


import java.util.Map;
import java.util.Random;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<String, HashSet<String>>mapa = new HashMap<>();

        String menu = "1-Adicionar termo\n2-Adiconar significado\n3-Imprimir termos e significados\n4-Imprimir um significado aleatorio de um termo\n5-Exit";

        int op = 0;

        while(op != 5){
            System.out.println(menu);
            
            op = sc.nextInt();

            switch (op){
                case 1:
                System.out.println("Insira um termo");
                sc.nextLine();
                String newtermo = sc.nextLine();


                if(mapa.containsKey(newtermo)){
                    System.out.println("Termo já existe!");
                }
                else{
                    mapa.put(newtermo, new HashSet<String>());
                    System.out.println("Termo adicionado!");
                }

                break;
                case 2:
                System.out.println("A que termo, quer adicionar uma definição?");
                sc.nextLine();
                String termo = sc.nextLine();

                if(mapa.containsKey(termo)){
                    System.out.println("Insira uma definição!");
                    
                    String define = sc.nextLine();
                    mapa.get(termo).add(define);
                }
                else{
                    System.out.println("O termo não existe!");
                }

                break;
                
                case 3:
                System.out.println(mapa.entrySet());
                

                break;

                case 4:

                System.out.println("De que termo deseja imprimir uma definição?");
                sc.nextLine();
                String gettermo = sc.nextLine();

                if(mapa.containsKey(gettermo)){
                   System.out.println(randomDefinition( mapa.get(gettermo)));
                }
                else{
                    System.out.println("Termo não existe!");
                }


                break;

                case 5:
                System.out.println("Programa terminado");
                break;

                

                default:

                System.out.println("Insira uma opção válida!");
                

            }


            


        }

        sc.close();
       




    }

    public static String randomDefinition(HashSet<String> h){
        Random rand = new Random();

        int def = rand.nextInt(h.size());
        int i = 0;
        for (String str : h){
            if(def == i ){
                return str;
                
            }
            i++;
        }

        return "Não existem definições para este termo";

    }

}
