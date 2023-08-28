import java.util.Scanner;

public class P02RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String racingN = scanner.nextLine();

        int firstRow = 0;
        int firstCol = 0;

        int kilometers = 0;

        boolean theStart = false;
        boolean theFinal = false;

        char[][] theMatrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String firstRowInAMatrix = scanner.nextLine();
            firstRowInAMatrix = firstRowInAMatrix.replace(" ", "");
            char[] oneRow = firstRowInAMatrix.toCharArray();
            theMatrix[row] = oneRow;
        }

        String commands = scanner.nextLine();
        while (!theStart && !theFinal) {
            if (commands.equals("End")) {
                theFinal = true;

            }else if (commands.equals("right") && firstCol != size - 1) {
                theMatrix[firstRow][firstCol] = '.';
                firstCol++;
                kilometers = kilometers + 10;

            }else if (commands.equals("left") && firstCol != 0) {
                theMatrix[firstRow][firstCol] = '.';
                firstCol--;
                kilometers = kilometers + 10;

            }else if (commands.equals("down") && firstRow != size - 1) {
                theMatrix[firstRow][firstCol] = '.';
                firstRow++;
                kilometers = kilometers + 10;

            }else if (commands.equals("up") && firstRow != 0) {
                theMatrix[firstRow][firstCol] = '.';
                firstRow--;
                kilometers = kilometers + 10;

            }if (theMatrix[firstRow][firstCol] == 'F') {
                theStart = true;
                theMatrix[firstRow][firstCol] = 'C';
                break;

            } else if (theMatrix[firstRow][firstCol] == 'T') {
                theMatrix[firstRow][firstCol] = '.';

                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        if (theMatrix[row][col] == 'T') {
                            firstRow = row;
                            firstCol = col;
                            theMatrix[row][col] = 'C';
                            kilometers = kilometers + 20;
                            break;
                        }
                    }
                }
            } else if (theMatrix[firstRow][firstCol] == '.') {
                theMatrix[firstRow][firstCol] = 'C';
            }

            if (!theStart && !theFinal) {
                commands = scanner.nextLine();
            }
        }
        if (theFinal) {
            System.out.printf("Racing car %s DNF.%n", racingN);
        }
        if (theStart) {
            System.out.printf("Racing car %s finished the stage!%n", racingN);
        }
        System.out.printf("Distance covered %d km.%n", kilometers);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == firstRow && col == firstCol) {
                    theMatrix[row][col] = 'C';
                }
                System.out.print(theMatrix[row][col]);
            }
            System.out.println();
        }

    }
}



