package aula11.Ex2;

public class Voo {
    private Tempo hora;
    private String id; // id do voo
    private String companhia;
    private String origem;
    private Tempo atraso;
    private Tempo previsto;

    public Voo(Tempo hora, String id, String companhia, String origem, Tempo atraso){
        this.hora = hora;
        this.id = id;
        this.companhia = companhia;
        this.origem = origem;
        this.atraso = atraso;
        this.previsto = new Tempo(this.hora.Minutos() + this.atraso.Minutos());
    }

    public Tempo getHora(){
        return hora;
    }

    public void setHora(Tempo t){
        this.hora = t;
    }

    public String getId(){
        return id;
    }

    public String getCompanhia(){
        return companhia;
    }

    public String getOrigem(){
        return origem;
    }

    public Tempo getAtraso(){
        return atraso;
    }

    public Tempo getPrevisto(){
        return previsto;
    }

    public void setAtraso(Tempo at){
        this.atraso = at;
    }

    public String toString(){

        return String.format("%-8s%-10s%-19s%-24s%-9s%-15s", this.hora, this.id, this.companhia, this.origem, (this.atraso.Minutos() > 0 ? this.atraso : ""), (this.previsto.Minutos() == this.hora.Minutos() ? "" : "Previsto: "+this.previsto));
    

    }
    
}
