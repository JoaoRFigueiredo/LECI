import java.util.ArrayList;
import java.util.List;

public class Professor extends Monitor {
    private String className;
    private String name;
    private StudentAdm adm;
    //private List<Monitor> monitors = new ArrayList<>();


    public Professor(StudentAdm adm, String name, String className) {
        this.name = name;
        this.adm = adm;
        this.className = className;
        adm.subscribe(this);
        
        // ...
    }

    public StudentAdm getStudentAdm(){
        return adm;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    

    public String toString(){
        return className;
    }

    @Override
    public void update(double score) {
        // TODO Auto-generated method stub
        System.out.printf("Professor %s of %s class evaluated student %s (%d) with score: %.1f\n", name, className, adm.getStudent().getName(), adm.getStudent().getId(), score);
    }

}
