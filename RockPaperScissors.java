
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        int wins = 0, losses = 0, draws = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter Rock, Paper, or Scissors: ");
            String player = sc.nextLine().trim();

            if (player.equalsIgnoreCase("rock")) {
                player = "Rock";
            } else if (player.equalsIgnoreCase("paper")) {
                player = "Paper";
            } else if (player.equalsIgnoreCase("scissors")) {
                player = "Scissors";
            } else {
                System.out.println("Invalid move. Try again.");
                i--;
                continue;
            }

            String computer = moves[random.nextInt(3)];
            String result = playRound(player, computer);

            System.out.println("Round " + i + " | Player: " + player
                    + " | Computer: " + computer + " | " + result);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        double percentage = (wins / 5.0) * 100;

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", percentage);

        sc.close();
    }
}
