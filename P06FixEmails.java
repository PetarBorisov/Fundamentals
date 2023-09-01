import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputName = scanner.nextLine();

        LinkedHashMap<String,String> map = new LinkedHashMap<>();

        while (!inputName.equals("stop")) {
          String emails = scanner.nextLine();
          if (!emails.endsWith(".us") && !emails.endsWith(".uk") && !emails.endsWith(".com")) {
              map.put(inputName,emails);
          }

            inputName = scanner.nextLine();
        }
        for (Map.Entry<String, String> theGame : map.entrySet()) {
            System.out.printf("%s -> %s%n",theGame.getKey(),theGame.getValue());
        }

    }
}
