import java.util.LinkedHashSet;
import java.util.Scanner;

public class P02SetsofElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] setSizes = scanner.nextLine().split(" ");
        int first = Integer.parseInt(setSizes[0]);
        int second = Integer.parseInt(setSizes[1]);

        LinkedHashSet<String> set1 = new LinkedHashSet<>();
        for (int i = 0; i < first; i++) {
            String element = scanner.nextLine();
            set1.add(element);
        }
        LinkedHashSet<String> set2 = new LinkedHashSet<>();
        for (int i = 0; i < first; i++) {
            String element = scanner.nextLine();
            set2.add(element);
        }
        set1.retainAll(set2);

        for (String element :
                set1) {
            System.out.print(element + " ");

        }

    }
}