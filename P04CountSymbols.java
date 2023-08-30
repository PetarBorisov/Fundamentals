import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {


            char current = input.charAt(i);
            map.putIfAbsent(current,0);
            int currentOcurences = map.get(current);
            map.put(current,currentOcurences + 1);

        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            System.out.printf("%s: %d time/s%n",characterIntegerEntry.getKey(),characterIntegerEntry.getValue());
        }


    }
}
