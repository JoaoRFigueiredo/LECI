public class Camper implements ICamper {

    private int lugares;
    private String descricao;
    private Estado estado;

    public Camper(int lugares, String descricao){
        this.lugares = lugares;
        this.descricao = descricao;
        this.estado = Estado.DISPONIVEL;
    }

    @Override
    public void setEstado(Estado e){
        this.estado = e;
    }

    @Override
    public Estado getEstado(){
        return estado;
    }

    @Override
    public int getLugares(){
        return lugares;
    }

    @Override
    public String getDescricao(){
        return descricao;
    }

    @Override
    public String toString(){
        return descricao;
    }





    



    
    
}
