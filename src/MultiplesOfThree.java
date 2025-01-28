import java.util.ArrayList;
import java.util.Scanner;

public class MultiplesOfThree {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a list of numbers separated by spaces: ");
            String inputArray = scanner.nextLine();

            validateString(inputArray);
            String[] stringNumbers = inputArray.split("\\s+");

            ArrayList<Integer> numbers = new ArrayList<>();
            for (String stringNumber : stringNumbers) {
                numbers.add(Integer.parseInt(stringNumber));
            }

            ArrayList<Integer> multiplesOfThree = new ArrayList<>();
            for (int number : numbers) {
                if (number % 3 == 0) {
                   multiplesOfThree.add(number);
                }
            }

            System.out.println("Multiples of three are: " + multiplesOfThree);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void validateString(String stringToValidate) {
        String[] elements = stringToValidate.split("\\s+");

        for (String element : elements) {
            try {
                if (element.contains(".")) {
                    throw new NumberFormatException("Invalid input: Floats or doubles are not allowed.");
                }
                Integer.parseInt(element);
            } catch (NumberFormatException e) {
                if (e.getMessage().equals("Invalid input: Floats or doubles are not allowed.")) {
                    throw e;
                } else {
                    throw new IllegalArgumentException("Invalid input: Please enter only numbers separated by spaces.");
                }
            }
        }
    }
}
