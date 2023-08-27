import java.util.Scanner;

public class mandeCareste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];

        int matrixPoint = 1;

        int[][] theMatrix = new int[n][n];
        if (pattern.equals("A")) {
            fillTheMatrixA(n, matrixPoint,theMatrix);
        } else if (pattern.equals("B")) {
            fillTheMatrixB(n, matrixPoint,theMatrix);
        }
        printTheMatrix(n,theMatrix);
    }

    private static void printTheMatrix(int m, int[][] matrix) {
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < m; col++) {
                System.out.print(matrix[row][col] + " ");
        }
            System.out.println();

        }
    }

    private static void fillTheMatrixA(int m, int counter, int[][] matrix) {
        for (int col = 0; col < m; col++) {
                for (int row = 0; row < m; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
        }
    }

    private static void fillTheMatrixB(int m, int counter, int[][] matrix)  {
        for (int col = 0; col < m; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < m; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }else {
                for (int row = m - 1; row >= 0 ; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
    }
}
