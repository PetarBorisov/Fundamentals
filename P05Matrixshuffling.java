import java.util.Scanner;

public class P05Matrixshuffling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String dimensions = scanner.nextLine();
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensions.split("\\s+")[1]);

        String [][] matrix = new String[rows][cols];
        fillMatrix(scanner, matrix, rows);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            if(!validateCommand(command, rows, cols)) {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            } else {
                String [] commandParts = command.split("\\s+");
                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);

                String element1 = matrix[row1][col1];
                String element2 = matrix[row2][col2];

                matrix[row1][col1] = element2;
                matrix[row2][col2] = element1;

                printMatrix(matrix, rows, cols);

            }

            command = scanner.nextLine();
        }



    }

    private static boolean validateCommand(String command, int rows, int cols) {

        String[] commandParts = command.split("\\s+");

        if (!commandParts[0].equals("swap")) {
            return false;
        }
        if (commandParts.length != 5) {
            return false;
        }
        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);

        if (row1 < 0 || row1 >= rows || row2 < 0
                || row2 >= rows || col1 < 0 || col1 >= cols
                || col2 < 0 || col2 > cols) {
            return false;
        }

        return true;
    }

    private static void fillMatrix(Scanner scanner, String[][] m, int rows) {
        for (int row = 0; row < rows; row++) {
            m[row] = scanner.nextLine().split("\\s+");
        }
    }


    public static void printMatrix (String [][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

