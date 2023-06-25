package CarConstructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<CarWhithConstructor> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            CarWhithConstructor car;
            if (carData.length == 1) {
                car = new CarWhithConstructor(carData[0]);
            }else {
                car =new CarWhithConstructor(carData[0],carData[1],Integer.parseInt(carData[2]));
            }
            list.add(car);
        }
        list.forEach(car -> System.out.println(car.carInfo2()));
    }
}
