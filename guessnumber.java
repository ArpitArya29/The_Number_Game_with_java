import java.util.Random;
import java.util.Scanner;

public class guessnumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //object of scanner class
        Random r = new Random();  //random variable object

        //a random variable is generated
        int ch = r.nextInt(100);

        //variable for remaining chances and attempts
        int count=10;
        int attempt=0;
        System.out.println("Enter any number between 1-100");

        //a boolean variable which will help for multiple rounds till the user want to play the game
        boolean wtp = true;

        //the main logic starts here
        while (wtp && count>0) {
            System.out.println("-----------------------------------------");
            System.out.format("You have %d Chances ", count);
            int ui = sc.nextInt();
            attempt++;
            if (ui == ch) {
                System.out.println("**********----------------**********");
                System.out.println("    Congrats, you wom the game");
                System.out.format("You guessed the number in %d attempts\n", attempt);

                //logic to provide the accuracy of the player
                if(attempt<=2) {
                    System.out.println("     Accuracy: PERFECT");
                }
                else if(attempt>2 && attempt<=5){
                    System.out.println("      Accuracy: Good");
                }
                else if(attempt>5 && attempt<=8){
                    System.out.println("     Accuracy: Moderate");
                }
                else{
                    System.out.println("Very poor accuracy, u just have to play well!");
                }

                //An option to play multiple rounds, if the player want to play
                System.out.println("-----------------------------------------");
                System.out.println("Would you wanna play again?\n(Y/N)");
                String pc=sc.next();

                //if user want to play the game again, the following logic needs to implement:-
                // --> A new random number is generated
                // --> the chance variable i.e count is reset to its maximum limit
                // --> The attempt variable is reset to 0
                if(pc.toLowerCase().equals("y")){
                    ch=r.nextInt(100);
                    count=10;
                    attempt=0;
                    System.out.println("============----------------=============");
                }
                else{
                    wtp=false;
                }               
            } 
            else if (ui < ch) {
                System.out.println("Your guess is too small, think some larger");
                count--;
            }
            else {
                System.out.println("Your guess is too high, think some smaller");
                count--;
            }

            //if the user reached the maximum chances to be attempt, the game will be over 
            if(count==0){
                System.out.println("___________________________________________");
                System.out.println("                opps!!!!");
                System.out.println("You've reached to your maximum attempt........");
                System.out.println("       NEEDS TO BE MORE PERFECT!!");
            }
        }
    }
}