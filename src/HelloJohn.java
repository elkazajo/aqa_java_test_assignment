import java.util.Scanner;

public class HelloJohn {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please, enter your name:");
            String name = scanner.nextLine().trim();

            if (name.matches("[a-zA-Z ]+")) {
                if (name.equalsIgnoreCase("john")) {
                    System.out.println("Hello, John!");
                } else {
                    System.out.println("There is no such name!");
                }
            } else {
                System.out.println("Please, enter a valid string (letters only)!");
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
