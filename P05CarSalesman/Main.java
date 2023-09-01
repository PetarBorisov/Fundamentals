package P05CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfEngines = Integer.parseInt(sc.nextLine());
        List<Engine> dataEngine = new ArrayList<>();
        for (int i = 0; i < numberOfEngines; i++) {
            String[] engineData = sc.nextLine().split("\\s+");
            if (engineData.length == 4) {
                Engine current = new Engine(engineData[0], engineData[1], Integer.parseInt(engineData[2]), engineData[3]);
                dataEngine.add(current);
            } else if (engineData.length == 3) {
                if (Character.isAlphabetic(engineData[2].charAt(0))) {
                    Engine current = new Engine(engineData[0], engineData[1], engineData[2]);
                    dataEngine.add(current);
                } else {
                    Engine current = new Engine(engineData[0], engineData[1], Integer.parseInt(engineData[2]));
                    dataEngine.add(current);
                }
            } else {
                Engine current = new Engine(engineData[0], engineData[1]);
                dataEngine.add(current);
            }
        }
        int numberOfCars = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfCars; i++) {
            String[] carsData = sc.nextLine().split("\\s+");
            Car current;
            for (int j = 0; j < dataEngine.size(); j++) {
                if (carsData[1].equals(dataEngine.get(j).getModelOfEngine())) {
                    if (carsData.length == 4) {
                        current = new Car(carsData[0], carsData[1], Integer.parseInt(carsData[2]), carsData[3]);
                    } else if (carsData.length == 3) {
                        if (Character.isAlphabetic(carsData[2].charAt(0))) {
                            current = new Car(carsData[0], carsData[1], carsData[2]);
                        } else {
                            current = new Car(carsData[0], carsData[1], Integer.parseInt(carsData[2]));
                        }
                    } else {
                        current = new Car(carsData[0], carsData[1]);
                    }
                    System.out.println(carsData[0] + ":");
                    System.out.println(dataEngine.get(j).getModelOfEngine() + ":");
                    System.out.println("Power: " + dataEngine.get(j).getPower());
                    if (dataEngine.get(j).getDisplacement() == -1) {
                        System.out.println("Displacement: n/a");
                    } else {
                        System.out.println("Displacement: " + dataEngine.get(j).getDisplacement());
                    }
                    System.out.println("Efficiency: " + dataEngine.get(j).getEfficiency());
                    if (current.getWeight() == 0) {
                        System.out.println("Weight: n/a");
                    } else {
                        System.out.println("Weight: " + current.getWeight());
                    }
                    System.out.println("Color: " + current.getColor());
                }

            }
        }
    }
}