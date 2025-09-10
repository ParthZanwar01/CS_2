import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person defaultPerson = new Person();
        System.out.println(defaultPerson);
        Person chuckNorris = new Person("Chuck Norris", 'M', 111_111_1111, "Navasota" );
        System.out.println(chuckNorris);
        Student defaultStudent = new Student();
        System.out.println(defaultStudent);
        Student cb = new Student("Capybara", 'F', 222_222_2222L, "SouthAmerica", 7.0);
        System.out.println(cb);
        HighSchoolStudent defaultHighSchoolStudent = new HighSchoolStudent();
        System.out.println(defaultHighSchoolStudent);
        HighSchoolStudent fo = new HighSchoolStudent("Fred O'Bannion", 'M', 999_999_9999L,
                "Austin", 1.2,"Senior", "Lee High");
        System.out.println(fo);
        Employee defaultEmployee = new Employee();
        System.out.println(defaultEmployee);
        Employee pg = new Employee("Peter Gibbons", 'M', 888_888_8888L, "Austin", 75_000,
                LocalDate.parse("1999-02-19"));
        System.out.println(pg);
        Teacher defaultTeacher = new Teacher();
        System.out.println(defaultTeacher);
        Teacher eh = new Teacher("Elizabeth Halsey", 'F', 555_555_5555L, "Chicago", 50_000,
                LocalDate.parse("2011-06-11"), 1, "1st", 1);
        System.out.println(eh);

    }
}