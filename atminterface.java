import java.util.Scanner;

class BankInterface {
    private double balance;

    public BankInterface(double availableBalance) {
        balance = availableBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
            return true;
        } else if (amount <= 0) {
            System.out.println("Invalid amount for withdrawal.");
        } else {
            System.out.println("Insufficient Balance.");
        }
        return false;
    }
}

class ATM {
    private BankInterface account;

    public ATM(BankInterface bankAccount) {
        account = bankAccount;
    }

    public void displayMenu() {
        System.out.println("Menu");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. End Transaction");
        System.out.println("Choose an option:");
    }

    public void work() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            displayMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter amount for withdrawal: ");
                    double amountWithdrawn = scanner.nextDouble();
                    account.withdraw(amountWithdrawn);
                    break;
                case 2:
                    System.out.println("Enter amount to deposit: ");
                    double amountDeposited = scanner.nextDouble();
                    account.deposit(amountDeposited);
                    break;
                case 3:
                    System.out.println("Available Balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank You");
                    break;
                default:
                    System.out.println("Invalid option, please choose again.");
            }
        } while (option != 4);
        scanner.close();
    }
}

public class atminterface {
    public static void main(String[] args) {
        BankInterface userAccount = new BankInterface(1000);
        ATM atmMachine = new ATM(userAccount);
        atmMachine.work();
    }
}
