import java.util.Locale;
import java.util.Scanner;

public class BankingProgram {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double balance = 0.0;
        boolean isRunning = true;

        // Show the menu until the user exits.
        while (isRunning) {
            System.out.println("**************************");
            System.out.println("       BANKING PROGRAM");
            System.out.println("**************************");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("**************************");
            System.out.print("Enter your choice (1-4): ");

            // Handle nonnumeric choices without terminating the program.
            if (!scanner.hasNext()) {
                break;
            }
            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Invalid choice");
                continue;
            }
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showBalance(balance);
                case 2 -> {
                    double amount = deposit();
                    if (Double.isFinite(balance + amount)) {
                        balance += amount;
                    } else {
                        System.out.println("Amount is too large.");
                    }
                }
                case 3 -> balance -= withdraw(balance);
                case 4 -> isRunning = false;
                default -> System.out.println("Invalid choice");
            }
        }

        System.out.println("**************************");
        System.out.println("Thank you!");
        System.out.println("Have a nice day!");
        System.out.println("**************************");
        scanner.close();
    }

    static void showBalance(double balance) {
        System.out.println("**************************");
        System.out.printf(Locale.US, "Your balance is: $%.2f%n", balance);
        System.out.println("**************************");
    }

    static double deposit() {
        System.out.print("Enter an amount to be deposited: ");

        // Only valid, finite amounts can change the balance.
        if (!scanner.hasNextDouble()) {
            if (scanner.hasNext()) {
                scanner.next();
            }
            System.out.println("Invalid amount");
            return 0;
        }
        double amount = scanner.nextDouble();
        if (!Double.isFinite(amount)) {
            System.out.println("Invalid amount");
            return 0;
        } else if (amount < 0) {
            System.out.println("Amount can't be negative.");
            return 0;
        } else {
            return amount;
        }
    }

    static double withdraw(double balance) {
        System.out.print("Enter an amount to be withdrawn: ");

        // Reject invalid amounts and prevent overdrawing the account.
        if (!scanner.hasNextDouble()) {
            if (scanner.hasNext()) {
                scanner.next();
            }
            System.out.println("Invalid amount");
            return 0;
        }
        double amount = scanner.nextDouble();
        if (!Double.isFinite(amount)) {
            System.out.println("Invalid amount");
            return 0;
        } else if (amount > balance) {
            System.out.println("Insufficient funds");
            return 0;
        } else if (amount < 0) {
            System.out.println("Amount can't be negative.");
            return 0;
        } else {
            return amount;
        }
    }
}
