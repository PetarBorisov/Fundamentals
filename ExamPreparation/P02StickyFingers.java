package ExamPreparation;

import java.util.Scanner;

public class P02StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commandsToMOve = scanner.nextLine().split(",");
        String[][] matrix = new String[size][size];

        int rowIndex = 0;
        int colIndex = 0;

        for (int row = 0; row < size; row++) {
            String[] firstRow = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = firstRow[col];

                if (matrix[row][col].equals("D")) {
                    rowIndex = row;
                    colIndex = col;
                }
            }
            }
            int totalMoney = 0;
            boolean caught = false;

            for (int i = 0; i < commandsToMOve.length; i++) {
                switch (commandsToMOve[i]) {
                    case "up":
                        if (rowIndex - 1 >= 0) {
                            matrix[rowIndex][colIndex] = "+";
                            rowIndex--;
                        } else {
                            System.out.println("You cannot leave the town, there is police outside!");
                        }
                        break;
                    case "down":
                        if (rowIndex + 1 < size) {
                            matrix[rowIndex][colIndex] = "+";
                            rowIndex++;
                        } else {
                            System.out.println("You cannot leave the town, there is police outside!");
                        }
                        break;
                    case "left":
                        if (colIndex - 1 >= 0) {
                            matrix[rowIndex][colIndex] = "+";
                            colIndex--;
                        } else {
                            System.out.println("You cannot leave the town, there is police outside!");
                        }
                        break;
                    case "right":
                        if (colIndex + 1 < size) {
                            matrix[rowIndex][colIndex] = "+";
                            colIndex++;
                        } else {
                            System.out.println("You cannot leave the town, there is police outside!");
                        }
                        break;
                }
                if (matrix[rowIndex][colIndex].equals("P")) {
                    System.out.printf("You got caught with %d$, and you are going to jail.%n", totalMoney);
                    matrix[rowIndex][colIndex] = "#";
                    caught = true;
                    break;
                }
                if (matrix[rowIndex][colIndex].equals("$")) {
                    System.out.printf("You successfully stole %d$.%n", rowIndex * colIndex);
                    totalMoney += rowIndex * colIndex;

                }
                matrix[rowIndex][colIndex] = "D";
            }


            if (!caught) {
                System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalMoney);
            }
            for (int i = 0; i < size; i++) {
                System.out.println(String.join(" ", matrix[i]));
            }
        }
    }

