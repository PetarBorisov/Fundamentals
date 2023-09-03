import java.util.ArrayDeque;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");
        int numCikles = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < names.length; i++) {
            queue.offer(names[i]);
        }
        while (queue.size() > 1) {
            for (int i = 0; i < numCikles - 1; i++) {
                String name = queue.poll();
                queue.offer(name);

            }
            System.out.println("Removed " + queue.poll());
        }
        for (String s: queue
             ) {
            System.out.println("Last is " + s);

        }
        
    }
}
