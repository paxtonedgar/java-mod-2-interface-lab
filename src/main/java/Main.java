import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static void log(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        CanFly userBird = getUserBird();
        int monsterSpeed = getMonsterSpeed();

        int birdSpeed = userBird.fly();
        if (birdSpeed > monsterSpeed) {
            log("Your bird was fast enough to escape");
        } else {
            log("Your bird was not fast enough to escape :-(");
        }
    }

    private static CanFly getUserBird() {
        Scanner inputScanner = new Scanner(System.in);
        while (true) {
            log("Please enter the type of bird you would like");
            log("1. Pigeon");
            log("2. Puffin");
            try {
                int userSelection = inputScanner.nextInt();
                if (userSelection == 1) {
                    return new Pigeon();
                } else if (userSelection == 2) {
                    return new Puffin();
                } else {
                    throw new InputMismatchException("Value must be either 1 or 2");
                }
            } catch(InputMismatchException inputException) {
                inputScanner.nextLine(); // clear the invalid input
                log("Invalid input - " + inputException.getMessage());
            }
        }
    }

    private static int getMonsterSpeed() {
        Scanner inputScanner = new Scanner(System.in);
        while (true) {
            log("How fast can the monster fly (in mph)?");
            try {
                int monsterSpeed = inputScanner.nextInt();
                return monsterSpeed;
            } catch(InputMismatchException inputException) {
                inputScanner.nextLine(); // clear the invalid input
                log("Invalid input - " + inputException.getMessage());
            }
        }
    }
}
