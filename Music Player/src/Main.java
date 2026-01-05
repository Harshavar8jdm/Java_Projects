import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final String AUDIO_FILE_PATH = "src/OnnOn.wav";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMainMenu();
            System.out.print("Select an option: ");
            String choice = scanner.next().trim();

            switch (choice) {
                case "1" -> launchAudioPlayer(scanner);
                case "2" -> {
                    System.out.println("Exiting application...");
                    running = false;
                }
                default -> System.out.println("Invalid selection. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Goodbye.");
    }

    private static void printMainMenu() {
        System.out.println("\n==============================");
        System.out.println("        MAIN MENU");
        System.out.println("==============================");
        System.out.println("1. Audio Player");
        System.out.println("2. Exit");
        System.out.println("==============================");
    }

    private static void launchAudioPlayer(Scanner scanner) {
        File audioFile = new File(AUDIO_FILE_PATH);

        if (!audioFile.exists()) {
            System.out.println("Error: Audio file not found.");
            return;
        }

        try (AudioInputStream audioStream =
                     AudioSystem.getAudioInputStream(audioFile)) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            boolean inPlayer = true;

            while (inPlayer) {
                printPlayerMenu();
                System.out.print("Command: ");
                String command = scanner.next().toUpperCase();

                switch (command) {
                    case "P" -> {
                        clip.start();
                        System.out.println("Playback started.");
                    }
                    case "S" -> {
                        clip.stop();
                        System.out.println("Playback stopped.");
                    }
                    case "R" -> {
                        clip.setMicrosecondPosition(0);
                        System.out.println("Playback reset.");
                    }
                    case "Q" -> {
                        clip.stop();
                        clip.close();
                        inPlayer = false;
                        System.out.println("Returning to Main Menu...");
                    }
                    default -> System.out.println("Unknown command.");
                }
            }

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio format.");
        } catch (IOException e) {
            System.out.println("I/O error while accessing audio file.");
        } catch (LineUnavailableException e) {
            System.out.println("Audio system unavailable.");
        }
    }

    private static void printPlayerMenu() {
        System.out.println("\n------------------------------");
        System.out.println("        AUDIO PLAYER");
        System.out.println("------------------------------");
        System.out.println("P - Play");
        System.out.println("S - Stop");
        System.out.println("R - Reset");
        System.out.println("Q - Back to Main Menu");
        System.out.println("------------------------------");
    }
}
