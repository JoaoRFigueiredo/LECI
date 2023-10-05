package aula05;

public class Utilizador {
    private String nome;
    private int nmec;
    private String curso;
    private int[] books;
    
    public Utilizador(String nome, int nmec, String curso){
        this.nome = nome;
        this.nmec = nmec;
        this.curso = curso;
        this.books =new int[] {0, 0, 0};
    }

    //getter and setters
    public String getNome(){
        return nome;
    }

    public String getCurso(){
        return curso;
    }

    public int getNmec(){
        return nmec;
    }

    public int[] getBooks(){
        return books;
    }

    public void setnMec(int newnMec){
        this.nmec = newnMec;
    }

    public void setNome(String newNome){
        this.nome = newNome;

    }

    public void setCurso(String newCurso){
        this.curso = newCurso;
    }

    public boolean adicionarLivro(int bookID){
        for (int i = 0; i<3; i++){
            if(books[i] == 0){
                books[i] = bookID;
                return true;
            }
        }
        return false;
    }

    public boolean removerLivro(int bookID){
        for (int i = 0; i<3; i++){
            if(books[i] == bookID){
                books[i] = 0;
                return true;
            }
        }
        return false;
    }

    public String toString(){
        return String.format("Aluno: %d; %s; %s", this.nmec, this.nome, this.curso);
    }
}
