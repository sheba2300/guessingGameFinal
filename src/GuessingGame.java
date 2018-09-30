import java.util.InputMismatchException;
import java.util.Scanner;
public class GuessingGame {
    public static void main(String args[]) {
        boolean playing = true;
        System.out.println("lets play and guessing game. input 1 for me to guess or input 2 for you to guess");
        Scanner inputMode = new Scanner(System.in);
        String mode = inputMode.nextLine();
        int range  = 10;
        int max = 10;

        try {

            if(mode.equals("2")) {
                System.out.println("Choose your range. Should we guess a number from 1-10 (type 1) 1-100 (type 2) or 1-1000 (type 3) 1-10000 (type 4)");
                Scanner inputRange = new Scanner(System.in);
                int rangeChoice = inputRange.nextInt();

                if (rangeChoice == 1)
                    range = 10;

                if (rangeChoice == 2)
                    range = 100;

                if (rangeChoice == 3)
                    range = 1000;
                if (rangeChoice == 4)
                    range = 10000;


                int chosenNum = (int) Math.round(Math.random() * range);
                System.out.println("I am thinking of a number from 1 - " + range + ". Try to guess!");
                while (playing) {
                    Scanner inputGuess = new Scanner(System.in);
                    int guess = inputGuess.nextInt();
                    if (guess > chosenNum)
                        System.out.println("guess lower");
                    if (guess < chosenNum)
                        System.out.println("guess higher");
                    if (guess == chosenNum) {
                        System.out.println("That's my number! How did you know?");
                        playing = false;
                        return;
                    }
                }


            }
            if(mode.equals("1")) {
                System.out.println("Choose your range. Should we guess a number from 1-10 (type 1) 1-100 (type 2) or 1-1000 (type 3) 1-10000 (type 4)");
                Scanner inputRange = new Scanner(System.in);
                int rangeChoice = inputRange.nextInt();
                if (rangeChoice == 1)
                    max = 10;

                if (rangeChoice == 2)
                    max = 100;

                if (rangeChoice == 3)
                    max = 1000;
                if (rangeChoice == 4)
                    max = 10000;
                int min = 0;
                int num = max / 2;
                System.out.println("Think of a number, any number between 1-" + max);
                System.out.println("I am going to guess your number. If I guess too high type lower. If I guess too low type higher. If the guess is correct type correct");
                while (playing) {
                    System.out.println("Is your number " + num + "?");
                    Scanner inputAnswer = new Scanner(System.in);
                    String answer = inputAnswer.nextLine();
                    if (answer.equals("higher")) {
                        min = num;
                        num = (min + max) / 2;
                    }
                    if (answer.equals("lower")) {
                        max = num;
                        num = (min + max) / 2;
                    }
                    if (answer.equals("correct")) {
                        System.out.println("I found your number. It's " + num);
                        playing = false;
                        return;
                    }
                }
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Please input a 1 or 2 please");
            inputMode.next();
        }
    }

}
