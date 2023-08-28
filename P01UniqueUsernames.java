import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> names = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            names.add(command);
        }
            for (String name : names
            ) {
                System.out.println(name);


            }
        }
    }
