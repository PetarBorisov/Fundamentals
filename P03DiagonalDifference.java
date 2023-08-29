import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            String[] rowOfMatrix  = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = Integer.parseInt(rowOfMatrix[col]);
            }
        }
        int mainDiagonal = 0;
        for (int i = 0; i < size; i++) {
            mainDiagonal += matrix[i][i];
        }
        int secondDiagonal = 0;
        for (int row = 0; row < size; row++) {
            secondDiagonal += matrix[row][size - row -1];

        }
        int different = Math.abs(mainDiagonal - secondDiagonal);
        System.out.println(different);
    }
}
