import java.util.Objects;

public class Camper implements ICamper {

    private int lugares;
    private String descricao;
    private Estado estado;

    public Camper(int lugares, String descricao) {
        this.lugares = lugares;
        this.descricao = descricao;
        this.estado = Estado.Disponivel;
    }

    @Override
    public void setEstado(Estado e) {
        this.estado = e;
        
    }

    @Override
    public Estado getEstado() {
        return this.estado;
    }

    @Override
    public int getLugares() {
        return this.lugares;
    }

    @Override
    public String getDescricao() {
        //get description of camper
        return this.descricao;
    }

    @Override
    public String toString() {
        //print descricao
        return this.descricao;

    }

    //equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Camper other = (Camper) obj;
        if (this.lugares != other.lugares) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

}

