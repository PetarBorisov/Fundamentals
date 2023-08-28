import java.util.Scanner;

public class P02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            double leftNum = Double.parseDouble(scanner.next());
            double rightsNum = Double.parseDouble(scanner.next());
            int sum = 0;
            if ( leftNum > rightsNum) {
                double firstNum = Math.abs(leftNum);
                while (firstNum > 0) {
                    sum += (firstNum % 10);
                    firstNum /=  10;
                }
        } else{
                double secondNum = Math.abs(rightsNum);
                while (secondNum > 0 ) {
                    sum += (secondNum % 10);
                    secondNum /= 10;
                }
            }
            System.out.println(Math.abs(sum));
        }
    }
}