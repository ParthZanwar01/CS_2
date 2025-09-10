import java.util.Objects;

public class Person {

    private String name;
    private char gender;
    private long number;
    private String address;

    public Person(){
        name  = "John Doe";
        gender = 'M';
        number = 8321234567L;
        address = "Cypress";
    }

    public Person(String name, char gender, long number, String address){
        this.name = name;
        this.gender = gender;
        this.number = number;
        this.address = address;
    }

    public void setNumber(long number){
        this.number = number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        Person other = (Person) o;
        return name.equals(other.name) && number == other.number && address.equals(other.address) && gender == other.gender;
    }

    public String toString(){
        return String.format("name='%s',gender=%c,number=%d,address='%s'", name, gender, number, address);
    }
}


