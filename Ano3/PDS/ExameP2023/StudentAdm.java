import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentAdm {
    private Student student;
    private Director dir;
    private Map<String, Professor> professors;
    private List<String> graded;
    //private ArrayList<Professor> lst;

    public StudentAdm(Student stud) {
        this.student = stud;
        this.professors = new HashMap<>();
        this.graded = new ArrayList<>();
        //this.lst = new ArrayList<>();
    }

    public void addScore(String className, double score) {
        student.addScore(className, score);
        graded.add(className);
        //System.out.println(professors);
        notifyDirector();
        notifyProfessor();
        //graded.add(className);
        // for (Professor professor : professors.values()) {
        //     notifyProfessor(className);
        // }
        //dir.reportOverallGrade();
    }

    public Student getStudent() {
        return student;
    }

    public void setDirector(Director dir) {
        this.dir = dir;
    }

    public void addProfessor(String className, Professor professor) {
        professors.put(className, professor);

    }

    private void notifyDirector() {
        if (dir != null) {
            dir.reportOverallGrade();
        }
    }

    private void notifyProfessor() {
        Professor professor;
        for (String n : graded){
        professor = professors.get(n);
            professor.evaluateStudent();
        }
        // Set<String> profs = professors.keySet();
        // System.out.println(profs);
        // for (String cadeira : profs){
        //     //System.out.println(cadeira);
        //     if (professors.containsKey(cadeira)){
        //     Professor p1 = professors.get(cadeira);
        //     if (p1 == null){
        //         p1.evaluateStudent();
        //     }
        //     else{
        //         continue;
        //     }
        // }
        // }

        
        
        //professor.evaluateStudent();
        
    }
}








