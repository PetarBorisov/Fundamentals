import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        Deque<String> stack = new ArrayDeque<>();

        for (String s : numbers
             ) {
            stack.push(s);


        }
        while (!stack.isEmpty()) {
            System.out.printf("%s ",stack.pop());
        }
    }
}
