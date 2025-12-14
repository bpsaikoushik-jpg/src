package BankingSystem.src;

import BankingSystem.src.Exception.InsufficientFundsException;

public class CurrentAccount extends Account {

    private final double overdraftLimit = 5000;

    public CurrentAccount(long acc, String name, double bal) {
        super(acc, name, bal);
    }

    @Override
    public void withdraw(double amt) throws InsufficientFundsException {
        if (amt > balance + overdraftLimit)
            throw new InsufficientFundsException("Overdraft limit exceeded");
        balance -= amt;
    }
}
