package aula08.Ex1;

import java.util.ArrayList;

public class EmpresaAluguer {
    private String nome, codigoPostal, email;
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    
    public EmpresaAluguer(String nome, String codigoPostal, String email){
        this.email = email;
        this.nome =  nome;
        this.codigoPostal = codigoPostal;

    }

public String getNome(){
    return nome;
}

public String getCodigoPostal(){
    return codigoPostal;
}

public String getEmail(){
    return email;
}

public void addVeiculo(Veiculo v){
    this.veiculos.add(v);
}

public Veiculo getVeiculo(String matricula){
    for (Veiculo g : veiculos){
        if(g.getMatricula().equalsIgnoreCase(matricula)){
            return g;
        }
    }
    return null;
}

public ArrayList<Veiculo> getVeiculos(){
    return veiculos;
}

public boolean validateEmail(){// 
    // p = pattern
    String[] patterns = {"@gmail.com", "@hotmail.com", "@outlook.com"};
    for (int i = 0; i<patterns.length; i++){
        if (this.email.contains(patterns[i])){
            return true;
        }
    }
    return false;
}

public void addVeiculos(Veiculo... veiculos) {
    for (Veiculo veiculo : veiculos) {
        this.veiculos.add(veiculo);
    }
}

public String toString() {
    return "Empresa{" + "nome=" + nome + ", código_postal=" + codigoPostal + ", email=" + email + ", veiculos=" + veiculos + '}';
}

}