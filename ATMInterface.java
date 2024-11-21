import java.util.Scanner;

class BankAccount {
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Getter for account holder name
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // Method to check balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf(" Successfully deposited $%.2f.\n", amount);
            System.out.printf(" Total Balance: $%.2f\n", balance); // Show updated balance
        } else {
            System.out.println(" Deposit amount must be greater than zero.");
        }
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf(" Successfully withdrew $%.2f.\n", amount);
            System.out.printf(" Total Balance: $%.2f\n", balance); // Show updated balance
            return true;
        } else if (amount > balance) {
            System.out.println(" Insufficient balance for this withdrawal.");
            return false;
        } else {
            System.out.println(" Withdrawal amount must be greater than zero.");
            return false;
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    // Constructor
    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    // Method to display the menu
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=========== ATM Menu ===========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = getValidatedIntegerInput(scanner);

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        scanner.close();
    }

    // Method to check balance
    private void checkBalance() {
        System.out.printf("\n Current Balance: $%.2f\n", bankAccount.getBalance());
    }

    // Method to deposit money
    private void deposit(Scanner scanner) {
        System.out.print("\nEnter the amount to deposit: ");
        double amount = getValidatedDoubleInput(scanner);
        bankAccount.deposit(amount);
    }

    // Method to withdraw money
    private void withdraw(Scanner scanner) {
        System.out.print("\nEnter the amount to withdraw: ");
        double amount = getValidatedDoubleInput(scanner);
        bankAccount.withdraw(amount);
    }

    // Method to validate integer input
    private int getValidatedIntegerInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print(" Invalid input. Please enter a number: ");
            }
        }
    }

    // Method to validate double input
    private double getValidatedDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid amount: ");
            }
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount userAccount = new BankAccount("Sanjana Kotian", 1000.00);

        // Create an ATM interface linked to the bank account
        ATM atm = new ATM(userAccount);

        // Display a welcome message
        System.out.println("===========================================");
        System.out.println("Welcome, " + userAccount.getAccountHolderName() + "! ");
        System.out.println("===========================================");

        // Start the ATM menu
        atm.showMenu();
    }
}
