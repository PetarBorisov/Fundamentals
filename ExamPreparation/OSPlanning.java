package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(tasks::push);
        ArrayDeque<Integer> threads = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(threads::offer);

        int valueToKill = Integer.parseInt(scanner.nextLine());

        int task = tasks.peek();
        int tread = threads.peek();


        while (task != valueToKill) {

            if (tread >= task) {
                tasks.pop();
            }
                threads.poll();

            task = tasks.peek();
            tread = threads.peek();
        }
            System.out.println("Thread with value " + threads.peek() + " killed task " + valueToKill);

            String leftThreads = threads.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));

            System.out.println(leftThreads);
    }




    }

