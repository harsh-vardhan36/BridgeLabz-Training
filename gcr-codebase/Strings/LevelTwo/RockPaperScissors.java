//Rock paper Scissors game between two players.
import java.util.Scanner;
public class RockPaperScissors {

    // Method to get computer choice
    static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);
        if (choice == 0)
            return "Rock";
        else if (choice == 1)
            return "Paper";
        else
            return "Scissors";
    }

    // Method to find winner
    static String findWinner(String user, String computer) {

        if (user.equals(computer))
            return "Draw";

        if (user.equals("Rock") && computer.equals("Scissors"))
            return "User";
        if (user.equals("Rock") && computer.equals("Paper"))
            return "Computer";

        if (user.equals("Paper") && computer.equals("Rock"))
            return "User";
        if (user.equals("Paper") && computer.equals("Scissors"))
            return "Computer";

        if (user.equals("Scissors") && computer.equals("Paper"))
            return "User";
        if (user.equals("Scissors") && computer.equals("Rock"))
            return "Computer";

        return "Invalid";
    }

    // Method to calculate stats and percentage
    static String[][] calculateStats(int userWins, int computerWins, int totalGames) {
        String[][] stats = new String[2][3];

        double userPercent = ((double) userWins / totalGames) * 100;
        double compPercent = ((double) computerWins / totalGames) * 100;

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.valueOf(userPercent);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.valueOf(compPercent);

        return stats;
    }

    // Method to display results
    static void displayResults(String[][] gameResults, String[][] stats) {

        System.out.println("\nGAME\tUSER\tCOMPUTER\tWINNER");

        for (int i = 0; i < gameResults.length; i++) {
            System.out.println((i + 1) + "\t" +
                    gameResults[i][0] + "\t" +
                    gameResults[i][1] + "\t\t" +
                    gameResults[i][2]);
        }

        System.out.println("\nPLAYER\tWINS\tWIN %");

        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" +
                    stats[i][1] + "\t" +
                    stats[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int games = in.nextInt();
        in.nextLine(); 

        String[][] gameResults = new String[games][3];

        int userWins = 0;
        int computerWins = 0;

        for (int i = 0; i < games; i++) {
            System.out.print("\nGame " + (i + 1) + " - Enter choice (Rock/Paper/Scissors): ");
            String userChoice = in.nextLine();

            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            if (winner.equals("User"))
                userWins++;
            else if (winner.equals("Computer"))
                computerWins++;

            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;
        }

        String[][] stats = calculateStats(userWins, computerWins, games);
        displayResults(gameResults, stats);

        in.close();
    }
}
