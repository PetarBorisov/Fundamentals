import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");
        int numCikles = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue,names);
        int counter = 1;
       while (queue.size() > 1) {
           for (int i = 1; i < numCikles; i++) {
               queue.offer(queue.poll());

           }
           if(isPrime(counter)){
               System.out.println("Prime " + queue.peek());

           }else{
               System.out.println("Removed " + queue.poll());
           }
           counter++;
       }

        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int number) {

        if(number <= 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number) ; i++) {

            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}

