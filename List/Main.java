package List;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        CustomList<String> list = new CustomList<String>();

        while (!command.equals("END")) {
            String[] commandName = command.split(" ");
             String firstCommand = commandName[0];
             switch (firstCommand) {
                 case "Add":
                String elementToAdd = commandName[1];
                list.add(elementToAdd);
                  break;
                 case "Remove":
                   int indexToRemove = Integer.parseInt(commandName[1]);
                     list.remove(indexToRemove);
                     break;
                     case "Contains":
                        String elementToSearch = commandName[1];
                         System.out.println(list.contains(elementToSearch));
                          break;
                 case "Swap":
                  int firstIndex = Integer.parseInt(commandName[1]);
                  int secondIndex = Integer.parseInt(commandName[2]);
                  list.swap(firstIndex,secondIndex);
                  break;
                 case "Greater":
                 String element = commandName[1];
                     System.out.println(list.countGreaterThan(element));
                     break;
                 case "Max":
                     System.out.println(list.getMax());
                    break;
                 case "Min":
                     System.out.println(list.getMin());
                     break;
                 case "Sort":
                     Sorter.sort(list);
                     break;
                 case "Print":
                     System.out.println(list);
                     break;
             }

            command = scanner.nextLine();
        }
    }
}
