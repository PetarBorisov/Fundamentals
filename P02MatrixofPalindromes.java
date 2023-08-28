import java.util.Scanner;

public class P02MatrixofPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String[] size = scanner.nextLine().split(" ");
       int rows = Integer.parseInt(size[0]);
       int cols = Integer.parseInt(size[1]);

       String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char outSideLetter = (char) ('a'+ row);
                char middleLetter = (char) ('a'+ row + col);
                matrix[row][col] = String.valueOf(outSideLetter) + middleLetter + outSideLetter;
            }
        }
       // така се принтира матрица
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");

            }
            System.out.println();
        }
    }
}
