package BankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        HashMap<Integer, BankAccount> bankAccountMap = new HashMap<>();

        while (!"End".equals(command)) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccountMap.put(bankAccount.getId(), bankAccount);
                    System.out.println("Account ID"+  bankAccount.getId() +" created");
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int currentDeposit = Integer.parseInt(tokens[2]);
                    if (bankAccountMap.containsKey(id)) {
                        bankAccount = bankAccountMap.get(id);
                        bankAccount.deposit(currentDeposit);

                        System.out.println("Deposited "+ currentDeposit +" to ID"+ bankAccount.getId() +"");
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double newInterest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(newInterest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    if (bankAccountMap.containsKey(id)) {
                        bankAccount = bankAccountMap.get(id);
                        System.out.printf("%.2f%n",bankAccount.getInterestRate(Integer.parseInt(tokens[2])));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
