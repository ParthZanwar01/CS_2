public class PerfectSquare {
    public static boolean isPerfect(int n) {
        if (n == 1) return true;
        return isPerfect(n, 1, n/2+2);

    }

    public static boolean isPerfect(long n, long left, long right){

        if (left <= right){
            long  mid = left + (right-left)/2;
            if (mid*mid == n) return true;
            else if (mid*mid > n) return isPerfect(n, left, mid - 1);
            else return isPerfect(n, mid+1, right);
        }
        return false;
    }

    public static void main(String[] args) {
        boolean[]ary = new boolean[200_000_000];
        for (int i = 1; i*i < ary.length; i++) {
            ary[i*i] = true;
        }
        boolean correct = true;
        for (int i = 1; i < ary.length && correct; i++) {
            if(isPerfect(i) != ary[i]){
                correct = false;
            }
        }
        System.out.println(correct ? "Code passes :)": "Code fails :(");
    }
}