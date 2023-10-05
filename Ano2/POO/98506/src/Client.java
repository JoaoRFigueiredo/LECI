public class Client implements Comparable<Client>{
    private String nome, localidade;

    public Client(String nome, String localidade){
        this.nome = nome;
        this.localidade = localidade;
    }

    public String getName(){
        return nome;
    }

    public void setName(String n){
        this.nome = n;
    }
    public String getLocalidade(){
        return localidade;
    }

    public void setLocalidade(String n){
        this.localidade = n;
    }

    public String toString(){
        return this.getName()+" ["+this.getLocalidade()+"]";
    }

    @Override
    public int compareTo(Client o) {
        if(this.getName().equalsIgnoreCase(o.getName())){
            if(this.getLocalidade().equalsIgnoreCase(o.getLocalidade())){
                return 1;
            }
        }
        else{
            return -1;
        }
        return 0;
        
    }


    
}
