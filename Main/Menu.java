package BankingSystem.src.Main;

import java.util.List;
import BankingSystem.src.*;
import BankingSystem.src.Utility.CSVUtil;

public class Menu {

    List<Account> accounts;

    public Menu() throws Exception {
        accounts = CSVUtil.loadAccounts();
    }

    private Account getAcc(long no) {
        for (Account acc : accounts) {
            if (acc.getAccountNo() == no)
                return acc;
        }
        return null;
    }

    public void deposit(long no, double amt) throws Exception {
        if (amt < 0) throw new Exception("Negative amount not allowed");
        Account acc = getAcc(no);
        if (acc == null) throw new Exception("Invalid account");
        acc.deposit(amt);
        System.out.println("Deposit successful. Balance: " + acc.getBalance());
    }

    public void withdraw(long no, double amt) throws Exception {
        if (amt < 0) throw new Exception("Negative amount not allowed");
        Account acc = getAcc(no);
        if (acc == null) throw new Exception("Invalid account");
        acc.withdraw(amt);
        System.out.println("Withdrawal successful. Balance: " + acc.getBalance());
    }

    public void transfer(long from, long to, double amt) throws Exception {
        Account f = getAcc(from);
        Account t = getAcc(to);
        if (f == null || t == null)
            throw new Exception("Invalid account");
        f.withdraw(amt);
        t.deposit(amt);
        System.out.println("Transfer successful");
    }

    public void showBalance(long no) {
        Account acc = getAcc(no);
        if (acc != null)
            System.out.println("Balance: " + acc.getBalance());
    }

    public void saveCSV() throws Exception {
        CSVUtil.writeOutput(accounts);
        System.out.println("Output CSV saved successfully");
    }
}
