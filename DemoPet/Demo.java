package DemoPet;

public  class Demo {
    private String dog;
    private String cat;
    private String horse;
    private int age;
    private double kg;

    public Demo(String dog, String cat, String horse, int age, double kg) {
        this.dog = dog;
        this.cat = cat;
        this.horse = horse;
        this.age = age;
        this.kg = kg;

    }

    public void setDog(String dog) {
        if (dog == null || dog.trim().isEmpty()) {
            throw new IllegalArgumentException("DemoPet.Dog is null");
        }
        this.dog = dog;
    }

    public void setCat(String cat) {
        if (cat == null || cat.trim().isEmpty()) {
            throw new IllegalArgumentException("Cat is null");
        }
        this.cat = cat;
    }

    public void setHorse(String horse) {
        if (horse == null || horse.trim().isEmpty()) {
            throw new IllegalArgumentException("Horse is null");
        }
            this.horse = horse;
    }

    public void setAge(int age) {
        if (age > 100) {
            throw new IllegalArgumentException("Pet is dead");
        }
        this.age = age;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }
    public void action() {

    }
}