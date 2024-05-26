import java.util.Scanner;

import static java.lang.Thread.sleep;

public class MyRunnable implements Runnable {
    private int minutes ;
    private int seconds ;

    public MyRunnable() {
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Enter the minutes (minutes must be positive) ");
            minutes = scanner.nextInt();
        }while(minutes < 0);
        do{
            System.out.println("Enter the seconds (0~60) ");
            seconds = scanner.nextInt();
        }while(seconds < 0 || seconds > 60);
    }

    @Override
    public void run() {
         while (true){
             if (seconds == 0 && minutes == 0) {
                 System.out.printf("Time: %02d:%02d%n", minutes, seconds--); return;
             }
             System.out.printf("Time: %02d:%02d%n", minutes, seconds--);
             if (seconds == 0 && minutes > 0) {
                 seconds = 60;
                 minutes--;
             }
             try {
                 sleep(1000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         }

    }
}
