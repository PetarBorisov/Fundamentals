import java.util.ArrayDeque;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] sequences = scanner.nextLine().split(" ");

        int n = Integer.parseInt(sequences[0]);
        int s = Integer.parseInt(sequences[1]);
        int x = Integer.parseInt(sequences[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] line2 = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(line2[i]));

        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            System.out.println("0");
        } else if (stack.contains(x)) {
            System.out.println(true);
        }else{
            int minElement = stack.stream().mapToInt(e -> e).min().getAsInt();
            System.out.println(minElement);
        }
    }
}

