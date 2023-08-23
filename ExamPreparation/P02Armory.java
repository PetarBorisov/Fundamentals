package ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class P02Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] armory = generateArmory(n);
        fillArmory(scanner, armory);

        int[] officerPositionXY = getPlayerPosition(armory);
        int[][] mirrors = getMirrors(armory);
        int gold = 0;
        boolean officerHasLeavedArmory = checkOfficerLeavedArmory(officerPositionXY, armory);
        while (gold <= 65 && !officerHasLeavedArmory) {
            String command = scanner.nextLine();
            int[] nextPosition = new int[2];
            nextPosition[0] = officerPositionXY[0];
            nextPosition[1] = officerPositionXY[1];
            switch (command) {
                case "up":
                    nextPosition[0] -= 1;
                    break;
                case "down":
                    nextPosition[0] += 1;
                    break;
                case "left":
                    nextPosition[1] -= 1;
                    break;
                case "right":
                    nextPosition[1] += 1;
                    break;
            }
            officerHasLeavedArmory = checkOfficerLeavedArmory(nextPosition, armory);
            if (!officerHasLeavedArmory) {
                String spotValue = armory[nextPosition[0]][nextPosition[1]];
                if (!spotValue.equals("-") && !spotValue.equals("M")) {
                    gold += Integer.parseInt(armory[nextPosition[0]][nextPosition[1]]);
                } else if (spotValue.equals("M")) {
                    armory[nextPosition[0]][nextPosition[1]] = "-";
                    if (nextPosition[0] == mirrors[0][0] && nextPosition[1] == mirrors[0][1]) {
                        nextPosition[0] = mirrors[1][0];
                        nextPosition[1] = mirrors[1][1];
                    } else {
                        nextPosition[0] = mirrors[0][0];
                        nextPosition[1] = mirrors[0][1];
                    }
                }

                moveOfficer(officerPositionXY, nextPosition, armory);
                officerPositionXY[0] = nextPosition[0];
                officerPositionXY[1] = nextPosition[1];
            } else {
                armory[officerPositionXY[0]][officerPositionXY[1]] = "-";
                System.out.println("I do not need more swords!");
                break;
            }
        }
        if (gold >= 65) System.out.println("Very nice swords, I will come back for more!");
        System.out.printf("The king paid %d gold coins.%n", gold);

        printMatrix(armory);
    }

    private static void printMatrix(String[][] armory) {
        Arrays.stream(armory).forEach(row -> {
            Arrays.stream(row).forEach(System.out::print);
            System.out.println();
        });

    }

    private static void moveOfficer(int[] officerPositionXY, int[] nextPosition, String[][] armory) {
        armory[nextPosition[0]][nextPosition[1]] = "A";
        armory[officerPositionXY[0]][officerPositionXY[1]] = "-";
    }


    private static int[][] getMirrors(String[][] armory) {
        int[][] mirrors = new int[2][2];
        boolean foundFirst = false;
        for (int row = 0; row < armory.length; row++) {
            for (int col = 0; col < armory[row].length; col++) {
                if (armory[row][col].equals("M") && !foundFirst) {
                    foundFirst = true;
                    mirrors[0][0] = row;
                    mirrors[0][1] = col;
                } else if (armory[row][col].equals("M") && foundFirst) {
                    mirrors[1][0] = row;
                    mirrors[1][1] = col;
                }
            }
        }
        return mirrors;
    }

    private static boolean checkOfficerLeavedArmory(int[] nextPosition, String[][] armory) {
        return !(nextPosition[0] >= 0 && nextPosition[1] >= 0 && nextPosition[0] < armory.length && nextPosition[1] < armory.length);
    }

    private static void fillArmory(Scanner scanner, String[][] armory) {
        for (int row = 0; row < armory.length; row++) {
            String elements = scanner.nextLine();
            for (int col = 0; col < armory[row].length; col++) {
                armory[row][col] = String.valueOf(elements.charAt(col));
            }
        }
    }

    private static int[] getPlayerPosition(String[][] armory) {
        int[] playerPosition = new int[2];
        for (int row = 0; row < armory.length; row++) {
            for (int col = 0; col < armory[row].length; col++) {
                if (String.valueOf(armory[row][col]).equals("A")) {
                    playerPosition[0] = row;
                    playerPosition[1] = col;
                }
            }
        }
        return playerPosition;
    }

    private static String[][] generateArmory(int size) {
        String[][] armory = new String[size][size];
        for (String[] row : armory) {
            Arrays.fill(row, "-");
        }
        return armory;
    }
}
