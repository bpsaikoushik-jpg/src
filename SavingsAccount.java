package BankingSystem.src;

import BankingSystem.src.Exception.InsufficientFundsException;

public class SavingsAccount extends Account {

    public SavingsAccount(long acc, String name, double bal) {
        super(acc, name, bal);
    }

    @Override
    public void withdraw(double amt) throws InsufficientFundsException {
        if (amt > balance)
            throw new InsufficientFundsException("Insufficient balance in Savings Account");
        balance -= amt;
    }
}
 