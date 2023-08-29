import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = new String[row][];
        String[][] secondMatrix = new String[row][];

        readMatrix(scanner,row,firstMatrix);
        readMatrix(scanner,row,secondMatrix);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (!firstMatrix[i][j].equals(secondMatrix[i][j])) {
                    firstMatrix[i][j] = "*";
                }
            }
        }
        printMatrix(row,cols,firstMatrix);

    }

    private static void printMatrix(int row, int cols, String[][] firstMatrix) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(firstMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void readMatrix(Scanner scanner, int row, String[][] matrix) {
        for (int i = 0; i < row; i++) {
            String[] arr = scanner.nextLine().split("\\s+");
            matrix[i] = arr;
        }

    }
}
