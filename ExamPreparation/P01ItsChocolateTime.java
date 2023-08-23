package ExamPreparation;

import java.util.*;

public class P01ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> queueMIlk = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(queueMIlk::offer);
        ArrayDeque<Double> stackCacao = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(stackCacao::push);
        Map<String,Integer> chocolate = new HashMap<>();
           chocolate.put("Milk Chocolate",0);
           chocolate.put("Dark Chocolate",0);
           chocolate.put("Baking Chocolate",0);

           while (!queueMIlk.isEmpty() && !stackCacao.isEmpty()) {
              double currentMilk  = queueMIlk.peek();
              double currentCacao =  stackCacao.peek();
              double percentCacao = currentCacao / (currentMilk + currentCacao) * 100;

              if (percentCacao == 30) {
                  int currentChocolate = chocolate.get("Milk Chocolate");
                  chocolate.put("Milk Chocolate",currentChocolate + 1);
                  queueMIlk.poll();
                  stackCacao.pop();
              }else if (percentCacao == 50) {
                  int currentChocolate = chocolate.get("Dark Chocolate");
                  chocolate.put("Dark Chocolate",currentChocolate + 1);
                  queueMIlk.poll();
                  stackCacao.pop();
              }else if (percentCacao == 100) {
                  int currentChocolate = chocolate.get("Baking Chocolate");
                  chocolate.put("Baking Chocolate",currentChocolate + 1);
                  queueMIlk.poll();
                  stackCacao.pop();
              }else{
                  stackCacao.pop();
                  currentMilk += 10;
                  queueMIlk.poll();
                  queueMIlk.offer(currentMilk);
              }
           }
           boolean isChocolateEmpty = false;
            for (Map.Entry<String, Integer> map : chocolate.entrySet()) {
            if (map.getValue() == 0) {
                System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
                isChocolateEmpty = true;
                break;
            }
        }
            if (!isChocolateEmpty) {
                System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
            }

            chocolate.entrySet().stream()
                    .sorted(Comparator.comparing(Map.Entry::getKey))
                    .forEach(e->{
                        if(e.getValue() > 0) {
                            System.out.printf(" # %s --> %d%n",e.getKey(),e.getValue());
                        }
                    });


    }
}
