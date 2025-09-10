public class Student extends Person{
 private double gpa;

 public Student(){
     gpa = 4.0;
 }

 public Student(String name, char gender, long number, String address, double gpa){
     super(name, gender, number, address);
     this.gpa = gpa;
 }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public boolean equals(Object o){
     Student other = (Student) o;
     return super.equals(o) && other.getGpa() == this.getGpa();
    }

    @Override
    public String toString(){
     return super.toString() + String.format(",gpa=%.1f", gpa);
    }
}

