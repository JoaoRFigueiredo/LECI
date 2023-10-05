package aula06;


public class Pessoa {
private int cc;
private String nome;
private Date dataNascimento;

    public Pessoa(String nome, int cc, Date dataNascimento){
        this.nome = nome;
        this.cc = cc;
        this.dataNascimento = dataNascimento;
    }

    // getters and setters
    public String getName(){ return nome;}
   
    public int getCC(){return cc;}
    
    public Date getData(){return dataNascimento;}

    public void setNome(String n){
        this.nome = n;
    }

    public void setCC(int c){
        this.cc = c;
    }

    public void setData (Date d){
        this.dataNascimento = d;
    }

    public String toString(){
        return "Nome: "+this.nome+
                "\nCC: "+this.cc+
                "\nData de nascimento: "+this.dataNascimento.toString();
    }


    @Override
    public boolean equals(Object obj) {
      if (this == obj){return true;}
      if(obj == null){return false;}
      if(getClass() != obj.getClass()){
          return false;
      }

      Pessoa other = (Pessoa)obj;
      if(dataNascimento == null){
          if (other.dataNascimento != null){
              return false;

          }
      }
      else if(!dataNascimento.equals(other.dataNascimento)){
          return false;
      }
      if (cc != other.cc){
          return false;
      }

      if(nome == null){
          if(other.nome != null){
              return false;
          }
      }
      else if (!nome.equals(other.nome)){
          return false;
      }

      return true;

}
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + cc;
    result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    return result;
}
}
