public class HighSchoolStudent extends Student{
    private String grade;
    private String school;

    public HighSchoolStudent(){
        grade = "senior";
        school = "Cy Ranch";
    }

    public HighSchoolStudent(String name, char gender, long number, String address, double gpa, String grade, String school){
        super(name, gender, number, address, gpa);
        this.grade = grade;
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        HighSchoolStudent other = (HighSchoolStudent) o;
        return super.equals(o) && other.school.equals(school) && other.grade.equals(grade);
    }

    public String toString(){
        return super.toString() + String.format(",grade='%s',school='%s'", grade, school);
    }
}

