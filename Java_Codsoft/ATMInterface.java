import java.util.Scanner;

class BankAccount 
	{
		private double balance;
		
		public BankAccount(double initialBalance)
			{
			balance = initialBalance;
            }

        public double getBalance() 
			{
            return balance;
            }

            public void deposit(double amount) 
				{
				if (amount > 0) 
					{
                    balance += amount;
                    System.out.println("Deposit successful. New balance: $" + balance);
                    } 
				else 
					{
                     System.out.println("Invalid deposit amount.");
                    }
                }

    public boolean withdraw(double amount) 
		{
		if (amount > 0 && amount <= balance) 
			{
               balance -= amount;
               System.out.println("Withdrawal successful. New balance: $" + balance);
               return true;
            } 
		else 
			{
               System.out.println("Insufficient funds or invalid withdrawal amount.");
               return false;
            }
        }
    }

class ATM 
	{
		private BankAccount account;
        private Scanner scanner;
		
		public ATM(BankAccount account) 
			{
			   this.account = account;
               scanner = new Scanner(System.in);
            }

        public void displayMenu() 
		    {
               System.out.println("ATM Menu:");
               System.out.println("1. Check Balance");
               System.out.println("2. Deposit");
               System.out.println("3. Withdraw");
               System.out.println("4. Exit");
            }

        public void start()
			{
			int choice;
            do 
				{
				displayMenu();
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) 
					{
					case 1:
                        System.out.println("Your balance: $" + account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                        default:
                        System.out.println("Invalid choice. Please select again.");
                    }
                } 
			while (choice != 4);
            }
    }

public class ATMInterface 
	{
    public static void main(String[] args)
		{
           BankAccount userAccount = new BankAccount(1000.0); // Initialize account balance
           ATM atm = new ATM(userAccount);
           atm.start();
		}
    }

