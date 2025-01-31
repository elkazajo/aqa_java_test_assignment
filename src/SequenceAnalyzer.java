import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SequenceAnalyzer {
    public static void main(String[] args) {
        String givenSequence = "[((())()(())]]";
        String result = analyzeSequence(givenSequence);
        System.out.println(result);
    }

    private static String analyzeSequence(String sequence) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> positions = new Stack<>();
        List<String> errors = new ArrayList<>();

        for (int i = 0; i < sequence.length(); i++) {
            char currentChar = sequence.charAt(i);

            if (currentChar == '(' || currentChar == '[') {
                stack.push(currentChar);
                positions.push(i);
            } else if (currentChar == ')' || currentChar == ']') {
                if (stack.isEmpty()) {
                    errors.add("Remove extra '" + currentChar + "' at position " + i);
                } else {
                    char lastOpen = stack.pop();
                    int lastPos = positions.pop();
                    if ((currentChar == ')' && lastOpen != '(') || (currentChar == ']' && lastOpen != '[')) {
                        String expected = (lastOpen == '[') ? "]" : ")";
                        errors.add("Change '" + currentChar + "' to '" + expected + "' at position " + i);
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            char unmatchedOpen = stack.pop();
            int unmatchedPos = positions.pop();
            String expected = (unmatchedOpen == '[') ? "]" : ")";
            errors.add("Add '" + expected + "' for unmatched '" + unmatchedOpen + "' at position " + unmatchedPos);
        }

        if (errors.isEmpty()) {
            return "Sequence is correct.";
        } else {
            return "Sequence is incorrect. To fix:\n" + String.join("\n", errors);
        }
    }
}
