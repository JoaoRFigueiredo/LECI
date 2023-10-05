import java.util.ArrayList;
import java.util.List;

public class Registos {
    // Data elements
    private ArrayList<Empregado> empregados; // Stores the employees
    public Registos() {
    empregados = new ArrayList<>();
    }

    
    public void insere(Empregado emp) {
    // Code to insert employee
        if (!empregados.contains(emp)) empregados.add(emp);
    }

    public void remove(int codigo) {
    // Code to remove employee
        for (Empregado e : empregados){
            if (e.codigo() == codigo){
                empregados.remove(e);
                break;
            }
        }
    }

    public boolean isEmpregado(int codigo) {
    // Code to find employee
    boolean is = false;
    for (Empregado e : empregados){
        if (e.codigo() == codigo){
            is = true;
            break;
        }
    }
    return is;
}
    


    public List<Empregado> listaDeEmpregados() {
    // Code to retrieve collection
        return empregados;
    }
    }