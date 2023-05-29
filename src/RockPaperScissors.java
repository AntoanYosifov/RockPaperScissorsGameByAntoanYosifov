import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rounds = 0;
        int playerWins = 0;
        int computerWins = 0;

        while(rounds < 10) {


            System.out.print("Choose [r]ock, [p]aper or [s]cissors: ");
            String playerMove = scanner.nextLine();

           if("restart".equals(playerMove) || "res".equals(playerMove)){
               rounds = 0;
               playerWins = 0;
               computerWins = 0;
           }else{

            Random random = new Random();
            int computerNumber = random.nextInt(3);
            String computerMove = "";
            String result = "";
            if ("r".equals(playerMove) || "rock".equals(playerMove)) {
                playerMove = ROCK;
            } else if ("p".equals(playerMove) || "paper".equals(playerMove)) {
                playerMove = PAPER;
            } else if ("s".equals(playerMove) || "scissors".equals(playerMove)) {
                playerMove = SCISSORS;
            } else {
                System.out.println();
                System.out.println("Invalid input. Please try again...");
                System.out.println();
                continue;
            }
            switch (computerNumber) {
                case 0:
                    computerMove = ROCK;
                    break;
                case 1:
                    computerMove = PAPER;
                    break;
                case 2:
                    computerMove = SCISSORS;
                    break;
            }

            if ((playerMove.equals(ROCK) && computerMove.equals(PAPER)) ||
                    (playerMove.equals(PAPER) && computerMove.equals(SCISSORS)) ||
                    (playerMove.equals(SCISSORS) && computerMove.equals(ROCK))) {
                result = "You have lost this round.";
                computerWins += 1;
            } else if (playerMove.equals(computerMove)) {
                result = "This game was a draw.";
            } else {
                result = "You have won this round.";
                playerWins += 1;
            }
               rounds++;
            System.out.println("Round: " + rounds);
            System.out.println();
            System.out.printf("The computer chose %s.\n", computerMove);
            System.out.println(result);
            System.out.println();
            System.out.printf("Player wins: %s\n", playerWins);
            System.out.printf("Computer wins:  %s\n", computerWins);
            System.out.println();


            System.out.println();
           }
        }
       if(playerWins < computerWins){
           System.out.println("You have lost this session!");
       }else if(computerWins < playerWins){
           System.out.println("You have won this session!");
       }else{
           System.out.println("This session was a draw!");
       }
    }

    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";
}