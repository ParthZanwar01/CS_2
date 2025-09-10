import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InterfacesExample {

    public static void main(String[] args) {
        Vehicle ferrari = new Car();  // confined to methods from vehicle (unless you cast)
        Truck tundra = new Truck();  // have access to all methods from Truck

        stopVehicle(ferrari);
        stopVehicle(tundra);

        ArrayList<Vehicle> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        accelerateAll(cars);

        LinkedList<Vehicle> trucks = new LinkedList<>();
        cars.add(new Truck());
        cars.add(new Truck());
        accelerateAll(trucks);

        List<Vehicle> automobiles = new ArrayList<>();
        automobiles.add(ferrari);
        automobiles.add(tundra);
        automobiles.add(new Boat());
        accelerateAll(automobiles);
        for (Vehicle v : automobiles) {
            v.apply_break();
            v.blowHorn();
        }
    }

    static void stopVehicle(Vehicle vehicle) {
        vehicle.apply_break();
        vehicle.turn_off();
    }

    static void accelerateAll(List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            v.accelerate();
        }
    }
}

interface Vehicle {

    int SPEED_LIMIT = 90;   // variables are public static final!

    void accelerate();     // methods are public abstract!

    void apply_break();

    void start();

    void turn_off();

    boolean turn(double degrees);

    default void blowHorn() {           // with Java 8 you can have default methods
        System.out.println("HONK!!");
    }

    // with Java 8 you can have class/static methods
    static void classMethodsNowAllowed(String name) {
        System.out.println(name);
    }
}

interface Radio {

    public static final String FREQUENCY_RANGE = "20 kHz to 300 GHz";

    public abstract void startRadio();  // public abstract is the default

    public void stopRadio();            // this is still public abstract

    abstract boolean maxVolume();       // this is still public abstract 
}

interface GPS extends Radio{
    String getLocation();
}

class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("starting car engine...");
    }

    @Override
    public void accelerate() {
        System.out.println("accelerating car engine...");
    }

    @Override
    public void apply_break() {
        System.out.println("applying car break...");
    }

    @Override
    public boolean turn(double degrees) {
        System.out.println("turning car " + degrees + " ...");
        return true;
    }

    @Override
    public void turn_off() {
        System.out.println("turning off car engine...");
    }
}

class Truck implements Vehicle {

    @Override
    public void start() {
        System.out.println("starting truck engine...");
    }

    @Override
    public void accelerate() {
        System.out.println("accelerating car engine...");
    }

    @Override
    public void apply_break() {
        System.out.println("applying truck break...");
    }

    @Override
    public boolean turn(double degrees) {
        System.out.println("turning truck " + degrees + " ...");
        return true;
    }

    @Override
    public void turn_off() {
        System.out.println("turning off truck engine...");
    }
}

class Boat implements Vehicle, GPS {

    @Override
    public void start() {
        System.out.println("starting boat engine...");
    }

    @Override
    public void accelerate() {
        System.out.println("accelerating boat engine...");
    }

    @Override
    public void apply_break() {
        System.out.println("reversing throttle...");
    }

    @Override
    public boolean turn(double degrees) {
        System.out.println("turning boat " + degrees + " ...");
        return true;
    }

    @Override
    public void turn_off() {
        System.out.println("turning off boat engine...");
    }

    @Override
    public void startRadio() {
        System.out.println("turning on radio...");
    }

    @Override
    public void stopRadio() {
        System.out.println("turning off radio...");
    }

    @Override
    public boolean maxVolume() {
        System.out.println("turning all the way up!!!!");
        
        return true;
    }

    @Override
    public String getLocation() {
        String s = "get Location and return it";
        return s;
      }
}


