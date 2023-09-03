import java.util.*;

public class Pianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberPieces = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> map = new LinkedHashMap<>();

        for (int i = 1; i <= numberPieces; i++) {
            String pieceData = scanner.nextLine();
            String[] pieces = pieceData.split("\\|");
            String piece = pieces[0];
            String composer = pieces[1];
            String key = pieces[2];

            List<String> list = new ArrayList<>();
            list.add(composer);
            list.add(key);

            map.put(piece, list);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] commands = command.split("\\|");
            if (!commands[0].equals("Add")) {
                if (commands[0].equals("Remove")) {
                    String piecesName = commands[1];
                    if (map.containsKey(piecesName)) {
                        map.remove(piecesName);
                        System.out.printf("Successfully removed %s!%n", piecesName);
                    }

                    String newPiece = commands[1];
                    String newKey = commands[2];
                    if (map.containsKey(newPiece)) {
                        List<String> newList = map.get(newPiece);
                        newList.remove(1);
                        newList.add(newKey);
                        map.put(newPiece, newList);
                        System.out.printf("Changed the key of %s to %s!%n", newPiece, newKey);

                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", newPiece);
                    }
                } else if (commands[0].equals("ChangeKey")) {
                    String newPiece = commands[1];
                    String newKey = commands[2];
                    if (map.containsKey(newPiece)) {
                        List<String> newList = map.get(newPiece);
                        newList.remove(1);
                        newList.add(newKey);
                        map.put(newPiece, newList);
                        System.out.printf("Changed the key of %s to %s!%n", newPiece, newKey);

                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", newPiece);
                    }
                }
            } else {
                String pieceName = commands[1];
                String composer = commands[2];
                String key = commands[3];

                if (map.containsKey(pieceName)) {
                    System.out.printf("%s is already in the collection!", pieceName);
                } else {
                    List<String> addList = new ArrayList<>();
                    addList.add(composer);
                    addList.add(key);
                    map.put(pieceName, addList);
                    System.out.printf("%s by %s in %s added to the collection!%n", pieceName, composer, key);
                }


                String piecesName = commands[1];
                if (map.containsKey(piecesName)) {
                    map.remove(piecesName);
                    System.out.printf("Successfully removed %s!%n", piecesName);
                }

                String newPiece = commands[1];
                String newKey = commands[2];
                if (map.containsKey(newPiece)) {
                    List<String> newList = map.get(newPiece);
                    newList.remove(1);
                    newList.add(newKey);
                    map.put(newPiece, newList);
                    System.out.printf("Changed the key of %s to %s!%n", newPiece, newKey);

                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", newPiece);
                }
            }


            command = scanner.nextLine();
    }

         map.forEach((key, value) -> System.out.printf("%s -> Composer: %s, Key: %s%n", key, value.get(0), value.get(1)));

    }
}
