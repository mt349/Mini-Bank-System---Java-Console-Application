import java.util.Scanner;

class MiniBank{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of Customers :");
        int Customers = scanner.nextInt();
        scanner.nextLine();

        // Array's
        String[] names = new String[Customers];
        int[] accountNumbers = new int[Customers];
        double[]balance = new double[Customers];
        String[][]Transaction = new String[Customers][100];
        int[]TransactionCounts = new int[Customers];

        // Customer info
        for(int i = 0; i < Customers;i++) {
            System.out.println("Enter  name for customer " + (i + 1) + ":");
            names[i]=scanner.nextLine();

            System.out.println("Enter AccountNumber for " + names[i] + ":");
            accountNumbers[i]=scanner.nextInt();

            System.out.println("Enter initial Balance for " + names[i] + ":");
            balance[i] = scanner.nextDouble();
            scanner.nextLine();

            TransactionCounts[i] = 0;

            System.out.println("..............................");


        }

        boolean running = true ;
        while(running) {
            System.out.println("---BANK MENU---");
            System.out.println("1. Select Customer :");
            System.out.println("2. Exit");
            System.out.println("Enter your choice :");
            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch(mainChoice) {
                case 1 :
                    System.out.println("Enter AccountNumber for Customer :");
                    int acc = scanner.nextInt();
                    scanner.nextLine();

                    int CustomerIndex = -1 ;
                    for(int i = 0; i < Customers; i++) {
                        if (accountNumbers[i] == acc) {
                            CustomerIndex=i ;
                            break;
                        }
                    }
                    if (CustomerIndex == -1) {
                        System.out.println("Customer not found!");
                        break;
                    }
                
        boolean CustomerMenu = true;
        while(CustomerMenu) {
            System.out.println("Welcome, " + names[CustomerIndex] + "!");
            System.out.println("1. Check Balance ");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdrawal Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit tp Main Menu");
            System.out.println("Enter your choice :");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1 :
                    System.out.println("Your current balance :" + balance[CustomerIndex]);
                    break;

                    case 2 :
                        System.out.println("Enter amount to deposit :");
                        double deposit = scanner.nextDouble();
                        scanner.nextLine();
                        if ( deposit > 0) {
                            System.out.println("Allow Deposit!");
                            balance[CustomerIndex] += deposit ;
                            System.out.println("Deposit Sucessful! Updated balance :" +balance[CustomerIndex]);
                            Transaction[CustomerIndex]
                            [TransactionCounts[CustomerIndex]] = "deposited" + deposit ;
                            TransactionCounts[CustomerIndex]++;
                        } else {
                            System.out.println("Invalid amount to deposit!Try again");
                        } break;

                        case 3 :
                            System.out.println("Enter amount to Withdrawal :");
                            double Withdrawal = scanner.nextDouble();
                            scanner.nextLine();
                            if (Withdrawal > balance[CustomerIndex]) {
                                System.out.println("Insufficient Funds!");
                            } else if ( Withdrawal <= 0) {
                                System.out.println("Invalid!");
                            } else {
                                System.out.println("Withdrawal Allowed!");
                                balance[CustomerIndex] -= Withdrawal ;
                                System.out.println("Withdrawal Sucessful!Updated Balance :" + balance[CustomerIndex]);
                                Transaction[CustomerIndex]
                                [TransactionCounts[CustomerIndex]] = "Withdrawal" + Withdrawal ;
                                TransactionCounts[CustomerIndex]++;
                            
                            } break;

                            case 4 :
                                System.out.println("Transaction Histor :");

                                if (TransactionCounts[CustomerIndex] == 0) {
                                    System.out.println("No transactions yet");
                                } else {
                                    for(int t = 0 ; t < TransactionCounts[CustomerIndex];t++) {
                                        System.out.println(Transaction[CustomerIndex][t]);
                                    }
                                } break;
                                case 5 :
                                    CustomerMenu = false; // exit to main menu
                                    break;

                                    default :
                                    System.out.println("Invalid choice!Try again");
                                    break;
                                
                        }
            }

            case 2 :
                running = false;
                System.out.println("Thank you for using MiniBank!");
                break;

                default :
                System.out.println("Invalid choice!Try again");
                break;
            
        }
}

}
}