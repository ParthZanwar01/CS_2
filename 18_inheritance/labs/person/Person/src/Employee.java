import java.time.LocalDate;

public class Employee extends Person{
 private int salary;
 private LocalDate dateHired;

 public Employee(){
     salary = 100000;
     dateHired = LocalDate.of(2022, 11, 15);
 }

 public Employee(String name, char gender, long number, String address, int salary, LocalDate dateHired){
     super(name, gender, number, address);
     this.salary = salary;
     this.dateHired = dateHired;
 }

 public boolean equals(Object o){
     Employee other = (Employee) o;
     return super.equals(o) && other.salary == salary && other.dateHired.equals(dateHired);
 }

 public String toString(){
     return super.toString() + String.format(",salary=%d, date hired=%s", salary, dateHired.toString());
 }

}

