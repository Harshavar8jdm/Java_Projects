import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static void main(){
        //initialize objects
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        //Declare variables
        int currentBalance = 100;
        int betAmount = 0;
        String choice = "";
        boolean isRunning = true;
        String[] symbols = {"🍒", "🍉", "🍋" ,  "🔔", "⭐"};
        int[] randomOutcomes = new int[3];


        while(isRunning){
            System.out.println("*************************");
            System.out.println("|-------SLOT MACHINE-----|");
            System.out.println("--------------------------");
            System.out.println("|Symbols: 🍒 🍉 🍋 🔔 ⭐|");
            System.out.println("*************************");
            System.out.println("Current Balance: "+ currentBalance);
            System.out.print("Place your bet amount: ");
            betAmount = scanner.nextInt();
            scanner.nextLine();
            if(betAmount <= 0){
                System.out.println("Enter Valid Bet to PROCEED!!!");
            }
            else if(betAmount > currentBalance){
                System.out.println("Not ENOUGH BALANCE");
            }
            else{
                currentBalance = currentBalance - betAmount;

                for(int i = 0; i < randomOutcomes.length; i++){
                    randomOutcomes[i] = (random.nextInt(0,5));

                }
                System.out.println(" ");
                for(int i = 0 ; i < randomOutcomes.length; i++){
                    System.out.printf("|%s| ", symbols[randomOutcomes[i]]);
                }

                if(randomOutcomes[0] == randomOutcomes[1] &&
                        randomOutcomes[1] == randomOutcomes[2]){

                    int winAmount = betAmount * 5;
                    currentBalance += winAmount;
                    System.out.println("\nYOU WIN! +" + winAmount + "🏁");

                }
                else{
                    System.out.println("\n YOU LOSE! ☹️");
                }

            }

            System.out.println("Do you Wish to CONTINUE? (y/n)");
            choice = scanner.nextLine().toUpperCase();
            if(!choice.contains("Y")){
                isRunning = false;
            }

        }

        System.out.println("BYE BYE");

    }
}
