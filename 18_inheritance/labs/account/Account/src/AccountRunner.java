public class AccountRunner {

    public static void main(String[] args) {
        // test classes showing polymorphism, early/late binding
        Account[] ary = new Account[4];
        ary[0] = new CheckingAccount();
        ary[1] = new CheckingAccount();
        ary[2] = new SavingsAccount();
        ary[3] = new SavingsAccount();

        //----------------------------------------------------------------------
        String dash = "----------------------------------------------------------------------------------------------------";
        System.out.println(dash);
        System.out.println("Testing No-Arg Constructors and toString()\n");
        for (Account account : ary) {
            System.out.println(account);
        }

        System.out.println(dash);
        //----------------------------------------------------------------------
        System.out.println("Making deposits of 300, 400, 1000, 2000 respectively\n");
        double[] dep = {300, 400, 1000, 2000};
        for (int i = 0; i < ary.length; i++) {
            try {
                ary[i].deposit(dep[i]);
            } catch (IllegalAmountException ex) {
                System.out.println(ex.getMessage());
            }
        }
        for (Account account : ary) {
            System.out.println(account);
        }
        System.out.println(dash);
        //----------------------------------------------------------------------
        System.out.println("Making withdraws of 400(can't), 400, 500, 2500.01(can't)\n");
        double[] withD = {400, 400, 500, 2500.01};
        for (int i = 0; i < ary.length; i++) {
            try {
                ary[i].withdraw(withD[i]);
            } catch (NoSufficientFundsException | IllegalAmountException ex) {
                System.out.println(ex.getMessage() + "\n");
            }
        }
        for (Account account : ary) {
            System.out.println(account);
        }

        System.out.println(dash);
        //----------------------------------------------------------------------
        System.out.println("Making withdraws of negatives\n");
        for (int i = 0; i < ary.length; i++) {
            try {
                ary[i].withdraw(-5 * i -.01);
            } catch (NoSufficientFundsException | IllegalAmountException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("\nMaking a negative deposit\n");
        try {
            ary[0].deposit(-10);
        } catch (IllegalAmountException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(dash);
        //----------------------------------------------------------------------
        System.out.println("Setting Interest w/ 10% and 6.25% rates\n");
        SavingsAccount one = (SavingsAccount) ary[2];
        SavingsAccount two = (SavingsAccount) ary[3];
        one.setInterestRate(.1);
        two.setInterestRate(.0625);
        System.out.println(one + "\n" + two);

        System.out.println("\nAdd Interest(Expecting $1,100.00 and $2,656.25)\n");
        one.addInterest();
        two.addInterest();
        System.out.println(one + "\n" + two);

    }
}
