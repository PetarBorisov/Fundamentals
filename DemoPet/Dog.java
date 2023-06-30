package DemoPet;

import DemoPet.Demo;

public class Dog extends Demo {
    public static final int DOG_AGE = 20;
    public static final double DOG_KG = 40;
    public Dog(String dog, String cat, String horse) {
        super(dog, cat, horse, DOG_AGE, DOG_KG);
    }
}
