package labs.recursion_euclid;

public class Euclid {

    public static int gcd(int a, int b){
        if (b==0) return a;
        return gcd(b, a%b);
    }

    public static double geometric(int num){
        if (num <= 0) return 0;
        if (num == 1) return 1;
        return geometric(num-1) + (1.0/Math.pow(2, num-1));
    }

    public static double basel(int num){
        if (num <= 0) return 0;
        if (num == 1) return 1;
        return basel(num-1) + (1.0/(num*num));
    }

    public static String scrambler(String s){
        if (s.isEmpty()) return "";
        if (s.length() == 1) return s;
        if (s.length() == 2) return "" + s.charAt(1) + s.charAt(0);
        return s.charAt(s.length()-1) + scrambler(s.substring(1, s.length()/2)) + scrambler(s.substring(s.length()/2, s.length()-1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(scrambler("computers"));
        System.out.println(scrambler("spmorteuc"));
        System.out.println(scrambler("rpmoetuc"));
        System.out.println(scrambler("computer"));
        System.out.println(gcd(42, 3));
        System.out.println(geometric(2));
        System.out.println(basel(3));
    }
}