package P07Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Person> map = new LinkedHashMap<>();
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String humanName = tokens[0];

            if (!map.containsKey(humanName)) {
                Person person = new Person(humanName);
                map.put(humanName,person);
            }

            String classes = tokens[1];
            switch (classes) {
                case "company" :
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company newCompany = new Company(companyName,department,salary);
                    map.get(humanName).setCompany(newCompany);
                    break;
                case "pokemon" :
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon newPokemon = new Pokemon(pokemonName,pokemonType);
                    map.get(humanName).setPokemon(newPokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentsBirthday = tokens[3];
                    Parents newParents = new Parents(parentName,parentsBirthday);
                    map.get(humanName).setParents(newParents);
                    break;
                case "children" :
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Children newChildren = new Children(childName,childBirthday);
                    map.get(humanName).setChildren(newChildren);
                    break;
                case "car" :
                    String model = tokens[2];
                    double carSpeed  = Double.parseDouble(tokens[3]);
                    Car newCar = new Car(model,carSpeed);
                    map.get(humanName).setCar(newCar);
                    break;

            }

            command = scanner.nextLine();
        }
        Person personToPrint = map.get(scanner.nextLine());
        String name = personToPrint.getName();
        Company company = personToPrint.getCompany();
        Car car = personToPrint.getCar();

        System.out.println(name);

        System.out.println("Company:");
        if (company != null) {
            System.out.println();
        }

        System.out.println("Car:");
        if (car != null) {
            System.out.println(car);
        }

        System.out.println("Pokemon:");
        if (personToPrint.getName().isEmpty()) {
            System.out.println(personToPrint.getName());
        }

        System.out.println("Parents:");
        if (personToPrint.getName().isEmpty()) {
            System.out.println(personToPrint.getName());
        }

        System.out.println("Children:");
        if (personToPrint.getName().isEmpty()) {
            System.out.println(personToPrint.getName());
        }
    }
}
