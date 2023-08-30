import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] components = scanner.nextLine().split(" ");
            Collections.addAll(set,components);

        }
        String result  = String.join(" ",set);
        System.out.println(result);
    }
}
