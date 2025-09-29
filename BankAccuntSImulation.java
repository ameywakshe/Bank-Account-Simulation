import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account{
   
    private String accHolder;
    private double balance;
    private List<String> transactionHistory;

    
    public Account(String accHolder ,double balance){
         
        this.accHolder=accHolder;
        this.balance=balance;
        this.transactionHistory=new ArrayList<>();
        transactionHistory.add("Account created with balance: " + balance);

  }


     public void deposit(double amount){
          
        if(amount>0){
            balance+=amount;
            transactionHistory.add("Deposited: " + amount + " | Balance: " + balance);
            System.out.println("Successfully deposited " + amount);
        } 
        else {
            System.out.println("Deposit amount must be positive!");
             }
        }


        public void withdraw(double amount){
             if(amount>0 && amount<=balance){
                balance-=amount;
                  transactionHistory.add("Withdrawn: " + amount + " | Balance: " + balance);
                  System.out.println("Successfully withdrawn " + amount);
             }
             else if (amount > balance) {
            System.out.println("Insufficient balance!");
        }else {
            System.out.println("Withdraw amount must be positive!");
        }

        }


        public void showBalance(){
              System.out.println("Current Balance: " + balance);
        }

        public void showTransactionHistory(){
             System.out.println("\nTransaction History for " + accHolder + ":");
             for (String transaction : transactionHistory) {
                System.out.println(transaction);
             }
        }

     }
    
public class BankAccuntSImulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an account
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();
        Account acc = new Account(name, initialBalance);

        int choice;
        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    acc.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    acc.withdraw(withdrawAmount);
                    break;
                case 3:
                    acc.showBalance();
                    break;
                case 4:
                    acc.showTransactionHistory();
                    break;
                case 5:
                    System.out.println(" Thank you for using the Bank System!");
                    break;
                default:
                    System.out.println(" Invalid choice. Try again!");
            }
        } while (choice != 5);

        sc.close();
    }
}
