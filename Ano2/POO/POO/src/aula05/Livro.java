package aula05;

public class Livro {
    private int id;
    private String titulo, regimeEmprestimo;
    private static int counter = 100;
    private String disp;

    public Livro(String titulo, String regimeEmprestimo){
        this.titulo = titulo;
        this.regimeEmprestimo = regimeEmprestimo;
        this.id = counter++;
        this.disp = "DISPONÍVEL";
        
    }

    public Livro(String titulo){
        this.id = counter++;
        this.titulo = titulo;
        this.regimeEmprestimo = "NORMAL";
        this.disp = "DISPONÍVEL";
        
    }

    //getter and setters

    public String getRegime(){
        return regimeEmprestimo;
    }

    public String getTitulo(){
        return titulo;
    }

    public int getId(){
        return id;
    }

    public String getDisp(){
        return disp;
    }

    public void setTitulo(String newTitle){
        this.titulo = newTitle;
    }

    public void setRegime(String newRegime){
        this.regimeEmprestimo = newRegime;
    }
    
    public void setId(int newId){
        this.id = newId;
    }

    public void setDisp(String newDisp){
        this.disp = newDisp;
    }

    public String toString(){
        return String.format("Livro %d; %s; %s", this.id, this.titulo, this.regimeEmprestimo);
    }
    
    
}
