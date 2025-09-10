public class CreditCards {

    // this method calculates the balance of a cc after only paying the min payment for a yea

    public static double minMonthlyPayment(double balance, double annualInterestRate, double monthlyPaymentRate) {
        return Double.parseDouble(String.format("%.2f",calculateBalance(balance, annualInterestRate, monthlyPaymentRate, 12)));
    }

    public static double calculateBalance(double balance, double annualInterestRate, double monthlyPaymentRate, int months) {
        if (months == 0) {
            return balance;
        }
        double monthlyInterestRate = annualInterestRate / 12.0;
        double minimumMonthlyPayment = monthlyPaymentRate * balance;
        double monthlyUnpaidBalance = balance - minimumMonthlyPayment;
        double updatedBalance = monthlyUnpaidBalance + (monthlyInterestRate * monthlyUnpaidBalance);
        return calculateBalance(updatedBalance, annualInterestRate, monthlyPaymentRate, months - 1);
    }

    public static int minFixedMonthlyPayment(double balance, double annualInterestRate) {
        return minFixedMonthlyPaymentHelper(balance, annualInterestRate, 10);
    }

    private static int minFixedMonthlyPaymentHelper(double balance, double annualInterestRate, int payment) {
        if (calculateBalanceWithFixedPayment(balance, annualInterestRate, payment, 12) <= 0) {
            return payment;
        }
        return minFixedMonthlyPaymentHelper(balance, annualInterestRate, payment + 10);
    }

    private static double calculateBalanceWithFixedPayment(double balance, double annualInterestRate, double payment, int months) {
        if (months == 0) {
            return balance;
        }
        double monthlyInterestRate = annualInterestRate / 12.0;
        double updatedBalance = (balance - payment) + monthlyInterestRate * (balance - payment);
        return calculateBalanceWithFixedPayment(updatedBalance, annualInterestRate, payment, months - 1);
    }

    public static double bisectionMonthlyAmount(double balance, double annualInterestRate) {
        double lower = balance / 12.0;
        double upper = (balance * Math.pow(1 + (annualInterestRate / 12.0), 12)) / 12.0;
        return Double.parseDouble(String.format("%.2f", bisectionMonthlyAmount(balance, annualInterestRate / 12.0, lower, upper)));
    }

    private static double bisectionMonthlyAmount(double balance, double monthlyIR, double lower, double upper) {
        double mid = (lower + upper) / 2.0;
        double remainingBalance = calculateBalanceWithFixedPayment(balance, monthlyIR * 12, mid, 12);
        if (Math.abs(remainingBalance) < 0.01) {
            return mid;
        } else if (remainingBalance > 0) {
            return bisectionMonthlyAmount(balance, monthlyIR, mid, upper);
        } else {
            return bisectionMonthlyAmount(balance, monthlyIR, lower, mid);
        }
    }

    public static void main(String[] args) {
        // testing part A
        System.out.println(minMonthlyPayment(42,.2,.04));
        System.out.println(minMonthlyPayment(484,.2,.04));
        System.out.println(minMonthlyPayment(151,.2,.06));
        System.out.println(minMonthlyPayment(412,.18,.08));
        System.out.println(minMonthlyPayment(416,.18,.06));
        System.out.println(minMonthlyPayment(430,.15,.04));
        System.out.println();

        // testing part B
        System.out.println(minFixedMonthlyPayment(3329,.2));
        System.out.println(minFixedMonthlyPayment(4773,.2));
        System.out.println(minFixedMonthlyPayment(3926,.2));
        System.out.println(minFixedMonthlyPayment(70,.25));
        System.out.println(minFixedMonthlyPayment(938,.2));
        System.out.println(minFixedMonthlyPayment(793,.2));
        System.out.println(minFixedMonthlyPayment(835,.18));
        System.out.println(minFixedMonthlyPayment(4778,.15));
        System.out.println(minFixedMonthlyPayment(4510,.04));
        System.out.println(minFixedMonthlyPayment(4919,.04));
        System.out.println(minFixedMonthlyPayment(3603,.18));
        System.out.println(minFixedMonthlyPayment(4800,.2));
        System.out.println(minFixedMonthlyPayment(4053,.15));
        System.out.println(minFixedMonthlyPayment(4019,.15));
        System.out.println(minFixedMonthlyPayment(3618,.15));
        System.out.println();

        // testing part C - add test cases


    }
}
