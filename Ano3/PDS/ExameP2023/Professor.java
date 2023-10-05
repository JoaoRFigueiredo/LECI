class Professor {
    private String className;
    private String name;
    private StudentAdm adm;

    public Professor(StudentAdm adm, String name, String className) {
        this.adm = adm;
        this.name = name;
        this.className = className;
        adm.addProfessor(className, this);
    }

    public void evaluateStudent() {
        Student student = adm.getStudent();
        double score = student.getScore(className);
        System.out.println("Professor " + name + " of " + className + " class evaluated student " + student + " with score: " + score);
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public StudentAdm getStudentAdm(){
        return adm;
    }

}
