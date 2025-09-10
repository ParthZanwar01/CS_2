public class SavingsAccount extends Account{

    private double interestRate;

    public SavingsAccount(){
        super(500);
        interestRate = 0.01;
    }


    public SavingsAccount(long id, double balance, double interestRate){
        super(balance);
        setId(id);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amt) throws NoSufficientFundsException, IllegalAmountException {
        if (amt < 0) throw new IllegalAmountException(String.format("Amount must be positive: $%.2f", amt));
        if (getBalance()-amt<500) throw new NoSufficientFundsException("Insufficient funds. Account must be >= 500\n" + String.format("Balance: $%.2f\nWithdraw Amount: $%.2f\n", getBalance(), amt));
        setBalance(getBalance()-amt);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void addInterest(){
        double interest = getBalance() * interestRate;
        setBalance(getBalance()+interest);
    }

    public String toString(){
        return String.format("%s, Child: SavingsAccount{interestRate=%5.2f%%", super.toString(), interestRate*100);
    }
}
