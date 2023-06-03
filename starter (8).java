import pkg.*;
import java.util.Scanner;
import java.util.Random;

public class starter{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //very nice 2d array to set amount of exercise to 6(reps) and amount of sets to 3
        int[][] weightData = new int[6][3];

        System.out.println("We shall go to gym. Let us get big!");
         boolean on = true;

        //options for your next desired action
         while(on){
            System.out.println("What do you feel like doing?");
            System.out.println("1. Log my workout");
            System.out.println("2. Calculate my recommended weigt");
            System.out.println("3. Exit the tracker");

            int option = scanner.nextInt();

            //performs whatever action the user desires
            if(option == 1) {
                logWeight(weightData, scanner);
            }
            else if(option == 2){
                calculateRecommendedWeight(weightData, scanner);
            }
            else if(option == 3){
                on = false;
                System.out.print("Already looking bigger. See you next time!");
            }
            else{
                System.out.println("That's not an option Mr. Poole...");
            }
         }
         scanner.close();
    }

}