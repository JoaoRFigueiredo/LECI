public class Director {
    private Course degreeName;
    private StudentAdm stud;

    public Director(StudentAdm stud, Course course) throws Exception {
        this.degreeName = course;
        this.stud = stud;
        stud.setDirector(this);
        if (stud.getStudent().getCourse() != course){
            throw new Exception("Director's course must be the same as the student's course!");
        }
    }

    public Course getCourseName() {
        return degreeName;
    }

    public void reportOverallGrade() {
        System.out.println(degreeName + " director reports that student " + stud.getStudent() + " has changed the overall grade: " + stud.getStudent().getOverallGrade());
        ;
    }

}
