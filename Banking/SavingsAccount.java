package Banking;

import Exception.InsufficientFundsException;

public class SavingsAccount extends Account {

    public SavingsAccount(long acc, String name, double bal) {
        super(acc, name, bal);
    }

    @Override
    public void withdraw(double amt) throws InsufficientFundsException {
        if (amt > balance)
            throw new InsufficientFundsException("Insufficient balance");
        balance -= amt;
    }
}
