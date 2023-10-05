package aula10.Ex1;

import java.util.Map;
import java.util.HashMap;

public class Ex1 {

    public static void main(String[] args){
        Map<String, String> mapa = new HashMap<>();

        mapa.put("Branco", "Que tem a cor da neve.");
        mapa.put("Vermelho", "Que tem a cor do sangue");
        mapa.put("c++", "Linguagem de programação");
        mapa.put("byte", "8 bits");
        mapa.put("Gato", "Animal");
        mapa.put("random", "aleatório");
        mapa.put("Aveiro", "Not Porto");
        mapa.replace("Aveiro", "Not Porto", "Distrito");
        mapa.remove("random");

        System.out.println(mapa.entrySet());

        System.out.println(mapa.keySet());

        System.out.println(mapa.values());




    }
}
