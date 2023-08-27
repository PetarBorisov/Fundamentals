import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = size[0];
        int cols = size[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] firstRow = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = firstRow[col];

            }
        }
        int[] size2 = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows2 = size2[0];
        int cols2 = size2[1];

        int[][] matrix2 = new int[rows2][cols2];

        for (int row2 = 0; row2 < rows2; row2++) {
            int[] secondRow = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col2 = 0; col2 < cols2; col2++) {
                matrix2[row2][col2] = secondRow[col2];
            }
        }
         if(isEqual(matrix,matrix2)) {
            System.out.println("equal");
        }else{
             System.out.println("not equal");
         }
    }

    private static boolean isEqual(int[][] matrix, int[][] matrix2) {
        if (matrix.length != matrix2.length) {
            return false;
        }
        for (int row = 0; row < matrix.length; row++) {
           if (matrix[row].length != matrix2[row].length) {
               return false;
           }
            for (int i = 0; i < matrix[row].length; i++) {
                if (matrix[row][i] != matrix2[row][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
