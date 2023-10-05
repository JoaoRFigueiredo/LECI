package aula07.ex3;

import java.util.ArrayList;



public class Agencia {
    private ArrayList<Alojamento> alojamentos = new ArrayList<Alojamento>();
    private ArrayList<Viatura> veiculos = new ArrayList<Viatura>();
    private String name, address;

public Agencia(String name, String address){
    this.name = name;
    this.address = address;
}

// setters and getters

public void setNome(String newName){
    this.name = newName;
}

public void setEndereco(String address){
    this.address = address;
}

public String getName(){
    return name;
}

public String getAddress(){
    return address;
}

public void addCar(Viatura v){
    this.veiculos.add(v);
}

public void addHousing(Alojamento a){
    this.alojamentos.add(a);
}

public ArrayList<Alojamento> housing(){
    return alojamentos;
} 

public ArrayList<Viatura> viaturas(){
    return veiculos;
}

public void listVehicles(){
    System.out.println("Lista de viaturas existentes: ");
    System.out.println("-----------------------------------");
    for(Viatura v : veiculos){
        System.out.println(v.toString()+"\n");

    }
}

public void listHousing(){
    System.out.println("Lista de alojamentos existentes: ");
    System.out.println("--------------------------------------");
    for(Alojamento v : alojamentos){
        System.out.println(v.toString()+"\n");

    }
}

public void listVehiclesAvailable(){
    System.out.println("Lista de viaturas disponiveis: ");
    System.out.println("-----------------------------------");
    for(Viatura v : veiculos){
        if(v.getCarTakenState() == false){
        System.out.println(v.toString()+"\n");
        }

    }
}

public void listHousingavailable(){
    System.out.println("Lista de alojamentos disponiveis: ");
    System.out.println("--------------------------------------");
    for(Alojamento v : alojamentos){
        if(v.getAvailable() == true){
        System.out.println(v.toString()+"\n");
        }

    }
}
    
}
