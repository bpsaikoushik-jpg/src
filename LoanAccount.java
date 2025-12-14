package BankingSystem.src;

public class LoanAccount {

    public static double calculateCompoundInterest(double p, double r, int t) {
        return p * Math.pow(1 + r / 100, t);
    }
}

