package BankingSystem.src;


public abstract class Account {

    protected long accountNo;
    protected String name;
    protected double balance;

    public Account(long accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amt) {
        balance += amt;
    }

    public abstract void withdraw(double amt) throws Exception;

    public double getBalance() {
        return balance;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }
}
