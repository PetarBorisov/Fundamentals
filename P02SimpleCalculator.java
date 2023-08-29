import java.util.ArrayDeque;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line  = scanner.nextLine().split(" ");

        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = line.length - 1; i > -1; i--) {
          stack.push(line[i]);


        }
        while (stack.size() >1) {
            int a  = Integer.parseInt(stack.pop());
            String hui  = stack.pop();
            int b = Integer.parseInt(stack.pop());

            if (hui.equals("+")) {
                stack.push(""+(a+b));
            }else{
                stack.push(""+(a-b));

            }
        }
        for (String s:stack
             ) {
            System.out.println(s);

        }
    }
}
