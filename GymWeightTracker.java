import java.util.Scanner;
import java.util.Random;

public class GymWeightTracker{
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

    private static void logWeight(int[][] weightData, Scanner scanner){
        System.out.println("Which exercise are you on? (1-6) and which set are you on? (1-3): ");
        int exercise = scanner.nextInt();
        int set = scanner.nextInt();

        //checks if users input is valid
        if(isValidExercise(exercise) && isValidSet(set)){
            System.out.println("Enter the weight you lifted in lbs:");
            int weight = scanner.nextInt();

            //uses the stupid freaking 2d array by storing the user's data
            weightData[exercise-1][set-1] = weight;
            System.out.println("That is pretty heavy... Your weight has been logged.");
        }
        else{
            System.out.print("That's not an option Mr. Poole...");
        }
    }
    private static void calculateRecommendedWeight(int[][] weightData, Scanner scanner){
        System.out.println("Enter the exercise number you are on (1-6):");
        int exercise = scanner.nextInt();

        //checks if input is valid again
        if(isValidExercise(exercise)){
            int totalWeight = 0;
            int count = 0;

            //iterates and calculates the total weight for the inputed sets
            for(int set = 0; set < 3; set++) {
                int weight = weightData[exercise - 1][set];
                if(weight>0){
                    totalWeight += weight;
                    count++;
                }
            }
            if(count>0){
                //calculates average weight
                int avgWeight = totalWeight/count;
                //uses average weight to calculate a new recommended weight(increase by 10% optimal)
                int recommendedWeight = (int)(avgWeight*1.1);

                System.out.println("I would recommend that for exercise " + exercise + " you should try using around: " + recommendedWeight + " lbs for your next exercise");

            }
            else{
                System.out.println("Nothing is logged for exercise " + exercise + ".  Try logging your workout first!");

            }

        }
        else{
            System.out.println("That's not an option Mr. Poole");
        }
    }
    //checks if exercise input is valid
    private static boolean isValidExercise(int exercise){
        return exercise >= 1 && exercise <= 6;
    }
    //checks if the set input is valid
    private static boolean isValidSet(int set){
        return set >= 1 && set <=3;
    }
}