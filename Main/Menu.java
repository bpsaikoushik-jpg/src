package Main;

import java.util.*;
import Banking.*;
import Utility.CSVUtil;
import Exception.*;
import Utility.PDFUtil;

public class Menu {

    List<Account> accounts;

    public Menu() throws Exception {
        accounts = CSVUtil.loadAccounts();
    }

    private Account getAccount(long no) {
        for (Account acc : accounts)
            if (acc.getAccountNo() == no)
                return acc;
        return null;
    }

    public void deposit(long no, double amt) throws Exception {
        if (amt < 0) throw new NegativeAmountException("Negative amount");
        Account acc = getAccount(no);
        if (acc == null) throw new Exception("Invalid account");
        acc.deposit(amt);
        System.out.println("Balance: " + acc.getBalance());
    }

    public void withdraw(long no, double amt) throws Exception {
        Account acc = getAccount(no);
        if (acc == null) throw new Exception("Invalid account");
        acc.withdraw(amt);
        System.out.println("Balance: " + acc.getBalance());
    }

    public void transfer(long from, long to, double amt) throws Exception {
        Account f = getAccount(from);
        Account t = getAccount(to);
        f.withdraw(amt);
        t.deposit(amt);
        System.out.println("Transfer successful");
    }

    public void saveCSV() throws Exception {
        CSVUtil.writeOutput(accounts);
        System.out.println("Output CSV saved");
    }
    public void generatePDF() {
    PDFUtil.generatePDF(accounts);
}
}

