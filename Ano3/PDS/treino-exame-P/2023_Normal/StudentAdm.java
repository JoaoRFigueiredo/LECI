import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentAdm {
    private Student student;
    private List<Monitor> directorMonitors;
    private List<Monitor> professorMonitors;
    private Map<Professor, Boolean> professorsGraded; // professores que já deram uma nota



    public StudentAdm(Student stud) {
        this.student = stud;
        directorMonitors = new ArrayList<>();
        professorMonitors = new ArrayList<>();
        professorsGraded = new LinkedHashMap<>();
    }

    //sempre que se faz uma addscore, temos de dar update nos observadores
    public void addScore(String className, double score) {

        //System.out.println(directorMonitors.size() + "||" + professorMonitors.size());
        student.addScore(className, (Double) score);
        // ...
        // primeiro o direcotr dá update
        for (Monitor  x : directorMonitors){
            Director m = (Director)x;
            m.update(this.getStudent().getOverallGrade());
            break;
        }

        for (Professor k : professorsGraded.keySet()){
                if (professorsGraded.get(k)){
                    // System.out.println(this.getStudent().getScores());
                    // System.out.println(this.getStudent().getScore(className)+"-->"+className);
                    Map<String, Double> mapa = this.getStudent().getScores();
                    k.update(mapa.get(k.getClassName()));
                }
            }
        

        //dps os professores
        for (Monitor x : professorMonitors){
            //primeiro dar updates de professores que já tenham dado notas (se já houveram)
            

            //dps o que está a dar a nota
            Professor m = (Professor)x;
            //System.out.println(m.toString());
            if (m.getClassName() == className){
                m.update(score);
                professorsGraded.put(m, true);
            }
        }


         

    }
    public Student getStudent() {
        return student;
    }

    public void subscribe(Monitor m){
        if (m instanceof Professor){
            Professor x = (Professor)m;
            professorsGraded.put(x, false);
            professorMonitors.add(m);

        }

        if (m instanceof Director){
            directorMonitors.add(m);
        }
    }
    
}








