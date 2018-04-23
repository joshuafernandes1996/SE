import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Number{
        static int input = 20;
        static int input1 = 20;
        static int input2 = 20;
        static String finish = "";
        static int e = 9;
        static int f = 0;
       
        public static String readLine(String prompt) {
                    String input = "";
                    System.out.print(prompt);
                    InputStreamReader isr = new InputStreamReader(System.in);
                    BufferedReader br = new BufferedReader(isr);
                    try {
 
                      input = br.readLine();
 
                    } catch (IOException ioe) {
                    }
                    return input;
                  }
 
                   public static int readInteger(String prompt) {
                    try {
 
                      return (int) Integer.parseInt(readLine(prompt));
 
                    } catch (NumberFormatException nfe) {
                    }
                    return input = 999999;
                  }
       
        public static void Player1(String finish, int x, int f, int score1, int lastdiff1, int input, int d, int e, boolean test, int input2, int y, int input1) {
                do {
                        if (test == true) {
                                input = readInteger("I'm thinking of an a integer between 0 and " + d + " inclusively, enter a guess: ");
                                score1++;
                        } else if (test == false) {
                                input = readInteger("Unfortunately that's wrong, guess another integer between 0 and " + d + " inclusively: ");
                                score1++;
                        }
                        if ((input > d) || (input < 0)) {
                                do {
                                        input = readInteger("Very funny, I'll ignore that. Guess an integer between 0 and " + d + " inclusively: ");
                                } while ((input > d) || (input < 0));
                        }
                       
                        if (input == x) {
                                System.out.println("Well done! The number is: " + x + ". You did it in " + score1 + " tries!");
                                Win(finish, f, input2, y, input1, x);
                        } else if (((Math.abs(input - x)) >= lastdiff1) && (test == false)) {
                                System.out.println("Colder or the same as last time, however.....");
                        } else if (test == false) {
                                System.out.println("Warmer, however......");
                        }
                        test = false;
                        lastdiff1 = Math.abs(input - x);
                } while (input != x);
        }
 
        public static void Player2(boolean test, int x, int d, int f, int lastdiff1, int lastdiff2, int input1, int input2, int score1, int score2, int y, String finish) {
                do {
                        if (test == true) {
                                System.out.println("I'm thinking of an a integer between 0 and " + d + " inclusively......");
                                input1 = readInteger("Player 1, please enter an integer between 0 and " + d + ", inclusivley: ");
                                score1++;
                        } else if (test == false) {
                                input1 = readInteger("Player 1, please enter another integer between 0 and " + d + ", inclusivley: ");
                                score1++;
                        }
                        if ((input1 > d) || (input1 < 0)) {
                                do {
                                        input1 = readInteger("Very funny, I'll ignore that. Player 1, guess an integer between 0 and " + d + " inclusively: ");
                                } while ((input1 > d) || (input1 < 0));
                        }
                        if (input1 == x) {
                                System.out.println("Player 1 is right! Your number is: " + x + ". You did it in " + score1 + " tries!");
                        } else if (((Math.abs(input1 - x)) >= lastdiff1) && (test == false)) {
                                System.out.println("Player 1. That was colder or the same as your last guess...");
                        } else if (test == false) {
                                System.out.println("Player 1. That was Warmer than your last guess!");
                        }
                        lastdiff1 = Math.abs(input1 - x);
                        if (test == true) {
                                System.out.println("I'm thinking of a different integer for player 2 between 0 and " + d + " inclusively.....");
                                input2 = readInteger("Player 2, please enter an integer between 0 and " + d + ", inclusivley: ");
                                score2++;
                        } else if (test == false) {
                                input2 = readInteger("Player 2, please enter another integer between 0 and " + d + ", inclusivley: ");
                                score2++;
                        }
                        if ((input2 > d) || (input1 < 0)) {
                                do {
                                        input2 = readInteger("Very funny, I'll ignore that. Player 2, guess an integer between 0 and " + d + " inclusively: ");
                                } while (input2 > d);
                        }
                        if (input2 == y) {
                                System.out.println("Player 2 is is right! Your number is: " + y + ". You did it in " + score1 + " tries!");
                        }
                        if ((input1 == x) && (input2 == y)) {
                                System.out.println("Players 1 and 2 drew!");
                        } else if (((Math.abs(input2 - y)) >= lastdiff2) && (test == false)) {
                                System.out.println("Player 2. That was colder or the same as last your last guess.....");
                        } else if (test == false) {
                                System.out.println("Player 2. That was warmer than last your last guess!");
                        }
                        test = false;
                        lastdiff2 = Math.abs(input2 - y);
                } while ((input1 != x) && (input2 != y));
                Win(finish, f, input2, y, input1, x);
        }
 
        public static void Win(String finish, int f, int input2, int y, int input1, int x) {
                if ((input2 != y) && (input1 == x)) {
                        System.out.println("Player 1 wins overall!");
                        System.out.println("Player 2's number was "+y+"!");
                }
                if ((input2 == y) && (input1 != x)) {
                        System.out.println("Player 2 wins overall!");
                        System.out.println("Player 1's number was "+x+"!");
                }
                finish = readLine("Would you like to play again? Enter yes or no: ");
                if ((false == finish.equals("yes")) && (false == finish.equals("no"))) {
                        do {
                                finish = readLine("Sorry, I didn't get that. Would you like to play again? Enter yes or no without any typos: ");
                        } while ((false == finish.equals("yes"))
                                        && (false == finish.equals("no")));
                }
                if (finish.equals("yes")) {
                        main(null);
                } else if (finish.equals("no")) {
                        System.out.println("Goodbye! I hope you enjoyed the Number Guessing game by Greg Cawthorne!");
                }
        }
 
        public static void main(String[] args) {
                int lastdiff1 = 9999;
                int lastdiff2 = 9999;
                double rand1 = Math.random();
                double rand2 = Math.random();
                boolean test = true;
                int score1 = 0;
                int score2 = 0;
            int d = 9;
                System.out.println("Welcome to the Number Guessing game by Greg Cawthorne!:");
                f = readInteger("Please enter the number of players (1 or 2): ");
                while ((f < 1) || (f > 2)){
                        f = readInteger("Please enter the number of players as an integer 1 or 2: ");
                }
                System.out.println("Please choose an option:");
                System.out.println("Press 0 for: Instructions");
                System.out.println("Press 1 for: Easy difficulty   (upto 10)");
                System.out.println("Press 2 for: Medium difficulty (upto 100)");
                System.out.println("Press 3 for: Hard   difficulty (upto 1000)");
                do {
                        e = readInteger("Please enter an integer 0, 1, 2 or 3: ");
                } while ((e > 3.1) || (e < 0));
                if (e == 3) {
                        d = 1000;
                } else if (e == 2) {
                        d = 100;
                } else if (e == 1) {
                        d = 10;
                } else if (e == 0) {
                        System.out.println("Instructions: The aim of the Random Number game is to guess a random number in the least amount of guesses possible.\nFirst you will be asked to select a difficulty by pressing 1 (which will make the random number between 0 and 10 inclusive), 2 (between 0 and 100), or 3 (between 0 and 1000).\nThen you will be asked to make a guess (must be an integer) between your 0 and your selected difficulty number.\nOn your second guess it will tell you if you are warmer (nearer) or colder (further away) from the random number compared to your last valid guess.\nIf you select more than one player you will all be guessing different numbers!\nEnjoy!");
                }
                if (e == 0) {
                        System.out.println("Please choose a difficulty:");
                        System.out.println("Press 1 for: Easy   (upto 10)");
                        System.out.println("Press 2 for: Medium (upto 100)");
                        System.out.println("Press 3 for: Hard   (upto 1000)");
                        do {
                                e = readInteger("Please enter an integer 1, 2 or 3: ");
                        } while ((e > 3.1) || (e < 0));
                }
                if (e == 3) {
                        d = 1000;
                } else if (e == 2) {
                        d = 100;
                } else if (e == 1) {
                        d = 10;
                }
                int x = (int) (rand1 * d);
                int y = (int) (rand2 * d);
                if (f == 1) {
                        Player1(finish,x, f, score1, lastdiff1, input, d, e, test, input2, y, input1);
                }
                if (f != 1) {
                        Player2(test, x, d, f, lastdiff1, lastdiff2, input1, input2, score1, score2, y, finish);
                }
        }
}