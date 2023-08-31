import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String brackets = scanner.nextLine();
        boolean isBalanced = true;

        Deque<Character> stackOpeningBrackets = new ArrayDeque<>();
        for (int i = 0; i < brackets.length(); i++) {
            char currentBrackets = brackets.charAt(i);
            if (currentBrackets == '(' || currentBrackets == '{' || currentBrackets == '[') {
                stackOpeningBrackets.push(currentBrackets);
            } else {
                if (stackOpeningBrackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpeningBracket = stackOpeningBrackets.pop();
                if (currentBrackets == '}' && lastOpeningBracket != '{') {
                    isBalanced = false;
                    break;
                } else if (currentBrackets == ')' && lastOpeningBracket != '(') {
                    isBalanced = false;
                    break;
                } else if (currentBrackets == ']' && lastOpeningBracket != '[') {
                    isBalanced = false;
                    break;
                }
            }


        }
        if (isBalanced && stackOpeningBrackets.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
