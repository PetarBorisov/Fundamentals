import java.util.ArrayDeque;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sequences = scanner.nextLine().split(" ");

        int n = Integer.parseInt(sequences[0]);
        int s = Integer.parseInt(sequences[1]);
        int x = Integer.parseInt(sequences[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        String[] line2 = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(line2[i]));

        }
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println("0");
        } else if (queue.contains(x)) {
            System.out.println(true);
        }else{
            int minElement = queue.stream().mapToInt(e -> e).min().getAsInt();
            System.out.println(minElement);
        }

    }
}

