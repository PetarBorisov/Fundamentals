package P01GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Integer> box = new Box();

        for (int i = 0; i < n; i++) {
            Integer element = Integer.parseInt(scanner.nextLine());
            box.add(element);

        }
        String[] indices = scanner.nextLine().split(" ");
        int first = Integer.parseInt(indices[0]);
        int second  = Integer.parseInt(indices[1]);
        box.swap(first,second);

        System.out.println(box);
    }
}
