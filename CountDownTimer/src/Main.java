import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    static void main(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Time: ");
        int response = scanner.nextInt();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int countdown  = response;
            @Override
            public void run() {

                System.out.println(countdown);
                countdown--;
                if(countdown == 0){
                    System.out.println("Time's UP!");
                    timer.cancel();
                }

            }
        };

        timer.schedule(task,0,1000);
        scanner.close();


    }
}
