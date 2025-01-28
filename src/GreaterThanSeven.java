import java.util.InputMismatchException;
import java.util.Scanner;

public class GreaterThanSeven {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter an integer:");

            if (scanner.hasNext()) {
                int number = scanner.nextInt();

                if (number > 7) {
                    System.out.println("Hello!");
                } else {
                    System.out.println("The number is not greater than 7");
                }
            } else {
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }
}
