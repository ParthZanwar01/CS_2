 class Whale{

    private int x, y;

    public static int c;

    public Whale() {  c++;  }

    public void fun() {  x = 6;  }

    public int back() {  return 1;  }

    public String toString() {  return x + " " + y + " " + c;  }

}

 class Beluga extends Whale{

    public void fun() {  System.out.println(back());  }

    public int back() {  return 2;  }

    public String toString() {  return "class Beluga " + super.toString();  }

}

class Main{
    public static void main(String[] args) {


//code in the main of another class

        Whale flipper = new Beluga();

        flipper = new Whale();

        flipper = new Beluga();

        flipper = new Whale();

        flipper.fun();

        flipper = new Beluga();

        flipper.fun();

        System.out.println(flipper); //line 1
    }}