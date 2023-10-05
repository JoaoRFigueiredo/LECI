import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// GradingSystem class
public class GradingSystem {
    private List<StudentAdm> studentsAdm = new ArrayList<>();
    private List<Director> directors = new ArrayList<>();
    private List<Professor> professors = new ArrayList<>();

    // Add a student to the system
    // The director of student's course is added as Monitor
    public StudentAdm addStudent(Student student) {
        StudentAdm studentAdm = new StudentAdm(student);
        studentsAdm.add(studentAdm);
        return studentAdm;
    }   

    // Add a director to the system
    // The director is added as monitor of the students in the same course
    public void addDirector(Course course) throws Exception {
        Director director;
        for (StudentAdm st : studentsAdm){
            if (course == st.getStudent().getCourse()){
                director = new Director(st, course);
                directors.add(director);
            }

        }

       // directors.add(director);
    } 

    public void addProfessor(Professor professor) {
        Professor p1 = new Professor (professor.getStudentAdm(), professor.getName() ,professor.getClassName());
        //p1.getStudentAdm().addProfessor(p1.getClassName(), p1); // duno why it isn't working
        professors.add(p1);
    }

    // List the students of a specific course using an iterator
    public void listStudentsOfCourse(Course course) {
        System.out.println("Students of " + course + " course:");
        for (StudentAdm studentAdm : studentsAdm) {
            if (studentAdm.getStudent().getCourse() == course) {
                System.out.println(studentAdm.getStudent());
            }
        }
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public List<Professor> getProfessors() {
        return professors;
    }
}
