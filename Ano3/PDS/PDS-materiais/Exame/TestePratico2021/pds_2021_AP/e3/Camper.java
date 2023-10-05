package e3;
import java.util.Objects;

public class Camper{

    private int lugares;
    private String descricao;
    private Estado estado;


    public Camper(int lugares, String descricao) {
        this.lugares = lugares;
        this.descricao = descricao;
        this.estado = new Disponivel();
    }


    public void setEstado(Estado e) {
        this.estado = e;
        
    }

    public void registaCamper(Camper c) {
        estado.registaCamper(c);
    }

    public void pedidoCliente(Cliente u, Camper c) {
        estado.pedidoCliente(u, c);
    }

    public void rejeitaPedido(Cliente u, Camper c) {
        estado.rejeitaPedido(u, c);
    }

    public void aceitaPedido(Cliente u, Camper c) {
        estado.aceitaPedido(u, c);
    }

    public void devolveCamper(Cliente u, Camper c) {
        estado.devolveCamper(u, c);
    }

    public Estado getEstado() {
        return this.estado;
    }


    public int getLugares() {
        return this.lugares;
    }


    public String getDescricao() {
        //get description of camper
        return this.descricao;
    }


    public String toString() {
        //print descricao
        return this.descricao;

    }

    //equals
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camper camper = (Camper) o;
        return lugares == camper.lugares && Objects.equals(descricao, camper.descricao);
    }
}

