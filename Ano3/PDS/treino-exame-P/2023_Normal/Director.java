public class Director extends Monitor{
    private Course degreeName;
    private StudentAdm adm;
    public Director (StudentAdm stud, Course course) throws Exception {
        this.degreeName = course;
        this.adm = stud;
        stud.subscribe(this);

        if (stud.getStudent().getCourse() != course){
            throw new Exception("Error: Director's course must be the same as student's course");
        }
    }

    public Course getCourseName() {
        return degreeName;
    }

    

    @Override
    public void update(double score) {
        // TODO Auto-generated method stub
        System.out.printf("%s director reports that student %s (%d) has changed the overall grade: %.1f\n", degreeName, this.adm.getStudent().getName(), this.adm.getStudent().getId(), score );
    }


}
