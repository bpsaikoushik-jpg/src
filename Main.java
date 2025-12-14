package BankingSystem.src.Main;


import java.util.Scanner;
import BankingSystem.src.LoanAccount;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();

        while (true) {

            System.out.println("\n=== SMART BANKING SYSTEM ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Loan Calculation");
            System.out.println("5. Save Output CSV");
            System.out.println("6. Exit");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    menu.deposit(sc.nextLong(), sc.nextDouble());
                    break;

                case 2:
                    menu.withdraw(sc.nextLong(), sc.nextDouble());
                    break;

                case 3:
                    menu.transfer(sc.nextLong(), sc.nextLong(), sc.nextDouble());
                    break;

                case 4:
                    System.out.println("Final Amount: " +
                        LoanAccount.calculateCompoundInterest(10000, 5, 2));
                    break;

                case 5:
                    menu.saveCSV();
                    break;

                case 6:
                    return;
            }
        }
    }
}
