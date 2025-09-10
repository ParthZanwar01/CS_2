public class CheckingAccount extends Account{

    public CheckingAccount(){
        super();
    }

    public CheckingAccount(double balance){
        super(balance);
    }

    @Override
    public void withdraw(double amt) throws NoSufficientFundsException, IllegalAmountException {
        if (amt < 0) throw new IllegalAmountException(String.format("Amount must be positive: $%.2f", amt));
        if (getBalance()-amt<0) throw new NoSufficientFundsException("Insufficient funds");
        setBalance(getBalance()-amt);
    }

    public String toString(){
        return String.format("%s, Child: Checking Account", super.toString());
    }
}

