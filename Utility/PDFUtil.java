package Utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import Banking.Account;

public class PDFUtil {

    public static void generatePDF(List<Account> accounts) {

        try {
            BufferedWriter bw = new BufferedWriter(
                new FileWriter("BankStatement.txt")
            );

            bw.write("SMART BANKING SYSTEM");
            bw.newLine();
            bw.write("Account Statement");
            bw.newLine();
            bw.newLine();

            for (Account acc : accounts) {
                bw.write("Account No : " + acc.getAccountNo());
                bw.newLine();
                bw.write("Name       : " + acc.getName());
                bw.newLine();
                bw.write("Balance    : " + acc.getBalance());
                bw.newLine();
                bw.write("----------------------------");
                bw.newLine();
            }

            bw.close();
            System.out.println("PDF Statement Generated (BankStatement.txt)");

        } catch (Exception e) {
            System.out.println("PDF Error: " + e.getMessage());
        }
    }
}
