import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArr(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        List<ArrayList<Integer>> matrixList = new ArrayList<>();
        int numberCounter = 1;

        for (int row = 0; row < rows; row++) {
            matrixList.add(row, new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrixList.get(row).add(col, numberCounter);
                numberCounter++;
            }
        }

        String inputCommand = scanner.nextLine();

        while (!"Nuke it from orbit".equals(inputCommand)) {
            int[] commands = Arrays.stream(inputCommand.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int rowIndex = commands[0];
            int colIndex = commands[1];
            int power = commands[2];

            for (int row = rowIndex - power; row <= rowIndex + power; row++) {
                if (isBound(row, colIndex, matrixList)) {
                    matrixList.get(row).set(colIndex, 0);
                }
            }
            for (int col = colIndex - power; col <= colIndex + power; col++) {
                if (isBound(rowIndex, col, matrixList)) {
                    matrixList.get(rowIndex).set(col, 0);
                }
            }
            for (int i = 0; i < matrixList.size(); i++) {
                matrixList.get(i).removeAll(new ArrayList<Integer>() {{
                    add(0);
                }});

                if (matrixList.get(i).size() == 0) {
                    matrixList.remove(i);
                    i--;
                }
            }
            inputCommand = scanner.nextLine();
        }
        for (ArrayList<Integer> integers : matrixList) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static boolean isBound(int rowIndex, int colIndex, List<ArrayList<Integer>> matrixList) {
        return (rowIndex >= 0 && rowIndex < matrixList.size())
                && (colIndex >= 0 && colIndex < matrixList.get(rowIndex).size());
    }

    private static int[] readArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

