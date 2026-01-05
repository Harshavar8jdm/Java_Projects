import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static void main(){

        Random random = new Random();
        //declare variables
        int numberOfDice;
        int subRoll;
        int outcome;
        int numberOfRolls;
        int total = 0;

        //display main menu
        System.out.println("************");
        System.out.println("----DICE----");
        System.out.println("************");
        System.out.print("Enter number of DICE to ROLL: ");
        numberOfDice = scanner.nextInt();
        if(numberOfDice > 0) {
            for (int i = 0; i < numberOfDice; i++) {
                subRoll = random.nextInt(1, 7);
                printDie(subRoll);
                System.out.println("You rolled: " + subRoll);
                total = total + subRoll;
            }
        }
        else{
            System.out.println("# of dice should be greater than 0!");
        }
        System.out.println("Total: " + total);



    }

    static void printDie(int roll){
        String[] DICE = {
                // 1
                "+-------+\n" +
                        "|       |\n" +
                        "|   ●   |\n" +
                        "|       |\n" +
                        "+-------+",

                // 2
                "+-------+\n" +
                        "| ●     |\n" +
                        "|       |\n" +
                        "|     ● |\n" +
                        "+-------+",

                // 3
                "+-------+\n" +
                        "| ●     |\n" +
                        "|   ●   |\n" +
                        "|     ● |\n" +
                        "+-------+",

                // 4
                "+-------+\n" +
                        "| ●   ● |\n" +
                        "|       |\n" +
                        "| ●   ● |\n" +
                        "+-------+",

                // 5
                "+-------+\n" +
                        "| ●   ● |\n" +
                        "|   ●   |\n" +
                        "| ●   ● |\n" +
                        "+-------+",

                // 6
                "+-------+\n" +
                        "| ●   ● |\n" +
                        "| ●   ● |\n" +
                        "| ●   ● |\n" +
                        "+-------+"
        };
        System.out.println(DICE[roll - 1]);
    }


}
