import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static void main(){
        //Simple BANKING PROGRAM

        //Declare Variables
        double balance = 0;
        boolean isRunning = true;
        int choice;

        while(isRunning){

            //DisplayMenu
            System.out.println("***************");
            System.out.println("BANKING PROGRAM");
            System.out.println("***************");

            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("***************");

            //Get and Process user choice
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch(choice){
                case 1 -> {
                    showBalance(balance);

                }

                case 2 -> {
                    balance = Deposit(balance);

                }

                case 3 -> {
                    balance =  Withdraw(balance);

                }

                case 4 -> {
                    isRunning = false;
                }
                default ->{
                    System.out.println("Enter Valid choice");
                }

            }

        }

        //exit message()
    }
    //show balance()
    static void showBalance(double balance){

        String cont;
        System.out.printf("Balance: %.2f\n", balance);
        System.out.println("Press any key to Continue to Main Menu");
        cont = scanner.next().toUpperCase();
        if(cont.contains("C")){
            return;
        }
    }

    //deposit()
    static double Deposit(double balance){
        String cont;
        double depositAmount;
        System.out.print("Enter Deposit: ");
        depositAmount = scanner.nextDouble();
        scanner.nextLine();
        balance = balance + depositAmount;
        System.out.println(depositAmount +" has been DEPOSITED to YOUR Account");
        System.out.println("New Balance: " + balance);
        System.out.println("Press any key to Continue to Main Menu");
        cont = scanner.next().toUpperCase();
        return balance;
    }

    //withdraw()
    static double Withdraw(double balance){
        String cont;
        double withdrawAmount;
        System.out.print("Enter Withdraw: ");
        withdrawAmount = scanner.nextDouble();
        scanner.nextLine();
        if(withdrawAmount < balance){
            balance = balance - withdrawAmount;
            System.out.println(withdrawAmount +" has been WITHDRAWN to YOUR Account");
            System.out.println("New Balance: " + balance);
        }

        else{
            System.out.println("You DO NOT have ENOUGH BALANCE!");
        }

        System.out.println("Press any key to Continue to Main Menu");
        cont = scanner.next().toUpperCase();
        return balance;

    }

}
