import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


// GradingSystem class
public class GradingSystem {
    List<StudentAdm> studentsAdm = new ArrayList<>();
    List<Director> directs = new ArrayList<>();
    List<Professor> profs = new ArrayList<>();

    // Add a student to the system
    // The director of student's course is added as Monitor
    public StudentAdm addStudent(Student student) {
        StudentAdm studentAdm = new StudentAdm(student);
        studentsAdm.add(studentAdm);
        //... 
        return studentAdm;
    }   

    // Add a director to the system
    // The director is added as monitor of the students in the same course
      public void addDirector(Course course) {
        for (StudentAdm studentAdm : studentsAdm) {
            if (studentAdm.getStudent().getCourse() == course) {
                try {
                    Director director = new Director(studentAdm, course);
                    directs.add(director);
                    //studentAdm.subscribe(director);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public StudentIterator<StudentAdm> getIterator(Course c){
        return new StudentIterator<>(c);
    }

    public void addProfessor(Professor professor) {
        profs.add(professor);
        StudentAdm studentAdm = professor.getStudentAdm();
        //studentAdm.subscribe(professor);
    }
    public List<Director> getDirectors() {
        return directs;
    }

    public List<Professor> getProfessors() {
        return profs;
    }

    //iterador
    private class StudentIterator<K> implements Iterator<K>{
        private int index;
        private List<StudentAdm> students;
        private Iterator<StudentAdm> it;

        public StudentIterator(Course c){
            this.index = 0;
            students = new ArrayList<>();
            for (StudentAdm s: studentsAdm){
                if (s.getStudent().getCourse() == c){
                    students.add(s);
                }
            }
            it = students.iterator();
        }

          @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public K next() {
            return (K) it.next();
        }
    }

}