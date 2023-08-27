import java.util.ArrayDeque;
import java.util.Scanner;

public class P01EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> milligramsCaffeine = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrink = new ArrayDeque<>();


        String[] miligrams = scanner.nextLine().split(",\\s+");

        String[] sumDrinks = scanner.nextLine().split(",\\s+");


        for (String mgs : miligrams) {
            milligramsCaffeine.push(Integer.parseInt(mgs));

        }

        for (String drinks: sumDrinks) {
            energyDrink.offer(Integer.parseInt(drinks));
        }
        int stamatCaffeine = 0;
        while (!milligramsCaffeine.isEmpty() && !energyDrink.isEmpty()){

            int lastMg = milligramsCaffeine.pop();
            int firstDrink = energyDrink.poll();
            int calculateMgs = lastMg * firstDrink;

            if (stamatCaffeine + calculateMgs <= 300){
                stamatCaffeine += calculateMgs;
            }else{
                energyDrink.offer(firstDrink);
                if (stamatCaffeine - 30 < 0){
                    stamatCaffeine = 0;
                }else {
                    stamatCaffeine -= 30;
                }
            }
        }

        if (!energyDrink.isEmpty()){
              StringBuilder sb = new StringBuilder();
              for (Integer integer : energyDrink) {
                  sb.append("").append(integer);
                  sb.append(", ");
            }
            sb.deleteCharAt(sb.length() - 2);
            System.out.printf("Drinks left: %s%n",sb.toString());
        }else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");

        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n",stamatCaffeine);
    }


}