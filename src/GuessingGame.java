import java.util.Scanner;
public class GuessingGame {
    public static void main(String args[])
    {
        System.out.println("lets play and guessing game. input 1 for me to guess or  input 2 for you to guess");
        Scanner inputMode = new Scanner(System.in);
        int mode = inputMode.nextLine();
        if(mode.equals("2")) {
            boolean playing = true;
            int range = 100;
            int chosenNum = (int) Math.round(Math.random() * range);
            System.out.println(chosenNum);
            System.out.println("I am thinking of a number from 1-100. Try to guess!");
            while (playing) {
                Scanner inputGuess = new Scanner(System.in);
                int guess = inputGuess.nextInt();
                if (guess > chosenNum)
                    System.out.println("guess lower");
                if (guess < chosenNum)
                    System.out.println("guess higher");
                if (guess == chosenNum) {
                    System.out.println("Thats my number! How did you know?");
                    playing = false;
                }
            }
        }
    }
}
