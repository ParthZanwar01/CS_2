import java.time.LocalDate;

public class Teacher extends Employee{
 private int room;
 private String conference;
 private int years;

 public Teacher(){
     room = 1560;
     conference = "6th";
     years = 12;
 }

 public Teacher(String name, char gender, long number, String address, int salary, LocalDate dateHired, int room, String conference, int years){
     super(name, gender, number, address, salary, dateHired);
     this.room = room;
     this.conference = conference;
     this.years = years;
 }

 public boolean equals(Object o){
     Teacher other = (Teacher) o;
     return super.equals(o) && room == other.room && conference.equals(other.conference) && years == other.years;
 }

 public String toString(){
     return super.toString() + String.format(",rooms=%d,conference='%s',years=%d", room, conference, years);
 }
}
