import java.util.*;

public class demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkQuantity = new ArrayDeque<>();
        ArrayDeque<Double> cacaoQuantity = new ArrayDeque<>();

        String[] milk = scanner.nextLine().split("\\s+");
        String[] cacao = scanner.nextLine().split("\\s+");

        for (String milkQ : milk) {
            milkQuantity.offer(Double.parseDouble(milkQ));
        }
        for (String cacaoQ : cacao) {
            cacaoQuantity.push(Double.parseDouble(cacaoQ));
        }
        Map<String, Integer> chocolate = new TreeMap<>();
        chocolate.put("Milk Chocolate", 0);
        chocolate.put("Dark Chocolate", 0);
        chocolate.put("Baking Chocolate", 0);

        while (!milkQuantity.isEmpty() && !cacaoQuantity.isEmpty()) {
            double currentMilk = milkQuantity.peek();
            double currentCacao = cacaoQuantity.peek();
            double cacaoPercent = currentCacao / (currentCacao + currentMilk) * 100;

            if (cacaoPercent == 30) {
                int currentPercent = chocolate.get("Milk Chocolate");
                chocolate.put("Milk Chocolate", currentPercent + 1);
                milkQuantity.poll();
                cacaoQuantity.pop();
            } else if (cacaoPercent == 50) {
                int currentPercent = chocolate.get("Dark Chocolate");
                chocolate.put("Dark Chocolate", currentPercent + 1);
                milkQuantity.poll();
                cacaoQuantity.pop();
            } else if (cacaoPercent == 100) {
                int currentPercent = chocolate.get("Baking Chocolate");
                chocolate.put("Baking Chocolate", currentPercent + 1);
                milkQuantity.poll();
                cacaoQuantity.pop();
            } else {
                cacaoQuantity.pop();
                currentMilk = milkQuantity.poll();
                currentMilk += 10;
                milkQuantity.offer(currentMilk);
            }
        }
        boolean isChocolateIsEmpty = false;
        for (Map.Entry<String, Integer> map : chocolate.entrySet()) {
            if (map.getValue() == 0) {
                System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
                isChocolateIsEmpty = true;
                break;
            }
        }
        if (!isChocolateIsEmpty) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");

        }
        for (Map.Entry<String, Integer> map : chocolate.entrySet()) {
            if (map.getValue() > 0) {

                System.out.printf(" # %s --> %d%n", map.getKey(), map.getValue());
            }

        }

    }}

