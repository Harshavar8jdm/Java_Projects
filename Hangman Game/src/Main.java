import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {



    static void main(){
        String filePath = "words.txt";
        ArrayList<String> words = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine()) != null){
                words.add(line.trim());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Could not find file!");
        }
        catch (IOException e ){
            System.out.println("Something went wrong.");
        }

        Random random = new Random();

        String word = words.get(random.nextInt(0, words.size()));
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<Character>();
        int wrongGuesses = 0;
        char guess;
        for(int i = 0; i < word.length() ; i++){

            wordState.add('_');
        }
        System.out.println("***********************");
        System.out.println("Welcome to JAVA HANGMAN");
        System.out.println("***********************");

        while(wrongGuesses < 6){
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.print("Word: ");
            for(char letter: wordState){
                System.out.print(letter + " ");

            }
            System.out.println("");

            System.out.print("Guess a letter: ");
            guess = scanner.next().toLowerCase().charAt(0);
            if(word.indexOf(guess) >= 0){
                System.out.println("Correct Guess! \n");

            }
            else{
                System.out.println("Wrong Guess! \n");
                wrongGuesses+=1;
            }

            for(int i = 0; i < word.length(); i++){
                if(word.charAt(i) == guess ){
                    wordState.set(i, guess);
                }
            }

            if(!wordState.contains('_')){
                System.out.print(getHangmanArt(wrongGuesses));
                System.out.println("YOU WIN!");
                System.out.println("The word was: " + word);
                break;

            }

        }

        if(wrongGuesses >= 6){
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.println("GAME OVER!");
            System.out.println("The word was: " + word);
        }

    }

    static String getHangmanArt(int wrongGuesses){
        return switch(wrongGuesses){

            case 0 -> """
                      
                      
                       
                      """;
            case 1 -> """
                      |-----| 
                      |     o
                      |   
                      |
                      |----------   
                      """;
            case 2 -> """
                       |-----| 
                       |     o
                       |     |
                       |
                       |----------   
                       """;
            case 3 -> """
                      |-----| 
                      |     o
                      |    /|
                      |
                      |---------- 
                      """;
            case 4 -> """
                      |-----| 
                      |     o
                      |    /|\\
                      |
                      |----------  
                      """;
            case 5 -> """
                      |-----| 
                      |     o
                      |    /|\\
                      |    /
                      |----------
                      """;
            case 6 -> """
                      |-----|
                      |     o
                      |    /|\\
                      |    / \\
                      |----------
                      """;
                default -> """
                           """;
        };
    }

}
