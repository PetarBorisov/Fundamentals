package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Kat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queueLicensePlates = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(queueLicensePlates::offer);

        ArrayDeque<Integer> stackCars = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(stackCars::push);


        int countOfRegisteredCars = 0;
        int countOfDays = 0;
       while(!queueLicensePlates.isEmpty() && !stackCars.isEmpty()) {
           countOfDays++;

           int currentPlateNumber = queueLicensePlates.poll();
           int currentCars = stackCars.pop();

           if (currentPlateNumber > (currentCars * 2)) {
               queueLicensePlates.addLast(currentPlateNumber - (currentCars * 2));
               countOfRegisteredCars += currentCars;
           } else if (currentPlateNumber < (currentCars * 2)) {
               int leftCars = currentCars - (currentPlateNumber / 2);
               stackCars.addLast(leftCars);
               countOfRegisteredCars += (currentPlateNumber / 2);
           }else {
               countOfRegisteredCars += currentCars;
           }

       }

        System.out.printf("%d cars were registered for %d days!%n",countOfRegisteredCars,countOfDays);
       if (!queueLicensePlates.isEmpty()) {
           int sumUnplacedPlate = 0;
           while (!queueLicensePlates.isEmpty()) {
               sumUnplacedPlate += queueLicensePlates.poll();
           }
           System.out.printf("%d license plates remain!",sumUnplacedPlate);
       } else if (!stackCars.isEmpty()) {
           int carWithoutPlate = 0;
           while (!stackCars.isEmpty()) {
               carWithoutPlate += stackCars.pop();
           }
           System.out.printf("%d cars remain without license plates!" ,carWithoutPlate);
       }else{
           System.out.println("Good job! There is no queue in front of the KAT!");
       }


    }

}
