import java.util.Scanner;

public class proba_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int rows = Integer.parseInt(scanner.nextLine());
        int cows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][cows];

        for (int row = 0; row < rows; row++) {
            String[] firstRowOfMatrix = scanner.nextLine().split(" ");
            for (int col = 0; col < cows; col++) {
                matrix[row][col] = Integer.parseInt(firstRowOfMatrix[col]);

            }

        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cows; col++) {
                System.out.println(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
