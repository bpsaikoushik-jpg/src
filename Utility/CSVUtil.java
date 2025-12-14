package Utility;

import java.io.*;
import java.util.*;
import Banking.*;

public class CSVUtil {

    public static List<Account> loadAccounts() throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("input.csv"));
        String line;
        br.readLine();

        List<Account> accounts = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            String[] p = line.split(",");
            long no = Long.parseLong(p[0]);
            String name = p[1];
            String type = p[2];
            double bal = Double.parseDouble(p[3]);

            if (type.equalsIgnoreCase("Savings"))
                accounts.add(new SavingsAccount(no, name, bal));
            else
                accounts.add(new CurrentAccount(no, name, bal));
        }

        br.close();
        return accounts;
    }

    public static void writeOutput(List<Account> accounts) throws Exception {

        BufferedWriter bw = new BufferedWriter(new FileWriter("output.csv"));
        bw.write("AccountNo,Name,FinalBalance");
        bw.newLine();

        for (Account acc : accounts) {
            bw.write(acc.getAccountNo() + "," + acc.getName() + "," + acc.getBalance());
            bw.newLine();
        }

        bw.close();
    }
}
