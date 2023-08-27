import java.util.Scanner;

public class P01DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String type = "";
            if (command.equalsIgnoreCase("true") || command.equalsIgnoreCase("false")) {
                type = "boolean";
            } else if (command.length() == 1) {
                char symbol = command.charAt(0);
                if (symbol < 47 || symbol > 58) {
                    type = "character";
                }else {
                    type = "integer";
                }
            }else{
                boolean isString  = false;
                boolean isFloat = false;
                for (int i = 0; i < command.length(); i++) {
                    char currentSymbol = command.charAt(i);

                    if(currentSymbol < 45 || currentSymbol > 57) {
                        isString = true;

            }
                    if (currentSymbol == 46) {
                        isFloat = true;
                    }
                    }
                if (isString) {
                    type = "string";
                }else{
                    if(isFloat) {
                        type = "floating point";
                    } else {
                        type = "integer";
                    }

                }
            }
            System.out.printf("%s is %s type%n", command, type);
            command = scanner.nextLine();
        }
                }



        }

