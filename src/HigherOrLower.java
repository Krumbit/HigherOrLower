import java.util.*;

public class HigherOrLower {
    private static final List<String> yesNoList = Arrays.asList("y", "n");
    private static final List<String> highLowList = Arrays.asList("h", "l");

    private static int score = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Higher or Lower! Enter Yes (Y) or No (N) to play...");
        String answer = validateInput(yesNoList, scanner);

        if (answer.equals("y")) {
            playGame();
        } else {
            System.out.println("See you soon!");
            System.exit(0);
        }
    }

    public static void playGame() {
        Random random = new Random();
        int integer = random.nextInt(100) + 1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("The first number is " + integer + ". Higher (H) or Lower (L)?");
        String answer = validateInput(highLowList, scanner);

        while(true) {
            int newInteger = random.nextInt(100) + 1;
            if ((answer.equals("h") && newInteger > integer) || (answer.equals("l") && newInteger < integer)) {
                score++;
                System.out.println("Correct! The number was " + newInteger + ". Higher (H) or Lower (L)?");
                integer = newInteger;
                answer = validateInput(highLowList, scanner);
            } else {
                System.out.println("You lost! The number was " + newInteger + ". Your final score was " + score + ". Would you like to play again? Yes (Y) or No (N)...");
                answer = validateInput(yesNoList, scanner);

                if (answer.equals("y")) {
                    score = 0;
                    playGame();
                } else {
                    System.out.println("See you soon!");
                    System.exit(0);
                }
            }
        }
    }

    public static String validateInput(List<String> validInputs, Scanner scanner) {
        StringBuilder invalidInputString = new StringBuilder("Invalid input. Enter ");
        for (String s : validInputs) {
            if (validInputs.indexOf(s) == 0) invalidInputString.append(s.toUpperCase());
            else invalidInputString.append(" or ").append(s.toUpperCase());
        }
        invalidInputString.append(".");

        String answer = scanner.nextLine().toLowerCase();
        while (answer.length() > 1 || !validInputs.contains(answer)) {
            System.out.println(invalidInputString);
            answer = scanner.nextLine().toLowerCase();
        }

        return answer;
    }
}