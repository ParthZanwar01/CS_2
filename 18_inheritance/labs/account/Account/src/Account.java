public abstract class Account{
    private static long nextId = 10_000_000_000L; // Static counter for unique IDs
    private long id;
    private double balance;

    public Account(){
        id=nextId++;
        balance = 0;
    }

    public Account(double balance){
        this.balance = balance;
        id=nextId++;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amt) throws IllegalAmountException{
        if (amt < 0) throw new IllegalAmountException();
        balance+=amt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public abstract void withdraw(double amt) throws NoSufficientFundsException, IllegalAmountException;

    public String toString(){
        return String.format("Parent: Account{id=%d; balance=$%.2f}", id, balance);
    }
}


