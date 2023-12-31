
public class Pessoa implements Comparable<Pessoa>
{
  private String name;
  private Data birth;



  public Pessoa(String name, Data birth){
    this.name = name;
    this.birth = birth;
  }

  public String getName(){
    return this.name;

  }

  public Data getBirth(){
    return this.birth;
  }


  public String toString(){
    return "(" + this.name +""+this.birth+")";
  }


  public int compareTo(Pessoa p){
    if (this.birth.compareTo(p.getBirth()) > 0){
    return 1;} // aniversário depois do outro

    else if (this.birth.compareTo(p.getBirth()) < 0){
      return -1; // aniversário antes do outro
    }

    else return 0; // anversário no mesmo dia
      
      
      
      


    }
  }



