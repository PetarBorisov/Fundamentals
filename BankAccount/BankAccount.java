package BankAccount;

public class BankAccount {

    private static int currentId = 1;

    private static double interestRate = 0.02;
    private int id;
    private double balance;

    public BankAccount() {
        this.id = currentId++;
}


    public double getInterestRate(int years) {
        return (this.balance * interestRate) * years;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }
    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return id;
    }


    }
