package easterBasket;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Basket basket = new Basket("Cloth",5);
        Egg egg = new Egg("Yellow",12,"pointy");
        Egg egg2 = new Egg("Red",22,"round");
        Egg egg3 = new Egg("Blue",2,"cracked");
        basket.addEgg(egg);
        basket.addEgg(egg2);
        basket.addEgg(egg3);
        basket.removeEgg("Blue");
        System.out.println(basket.report());

    }
}