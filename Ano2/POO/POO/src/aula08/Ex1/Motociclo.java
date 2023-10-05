package aula08.Ex1;

public class Motociclo extends Veiculo {
        private String tipo;

        public Motociclo(String matr, String marca, String mod, int pot, String tipo) {
            super(matr, marca, mod, pot);
            if(!tipo.equalsIgnoreCase("desportivo") && !tipo.equalsIgnoreCase("estrada")){throw new IllegalArgumentException("Tipo inválido!");}
            this.tipo = tipo;
        }

        public String getTipo(){
            return tipo;
        }

        public String toString() {
            return "Motociclo{" + "matricula"+ getMatricula() + ", marca=" + getMarca() + ", modelo=" + getModelo() + ", potencia=" + getPotencia() + ", tipo=" + tipo + '}';
        }
    
}
