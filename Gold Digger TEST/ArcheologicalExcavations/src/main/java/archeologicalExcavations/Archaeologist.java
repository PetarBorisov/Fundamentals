package archeologicalExcavations;

public class Archaeologist {
    private String name;
    private double energy;

    public Archaeologist(String name, String energy) {
        this.name = name;
        this.energy = Double.parseDouble(energy);
    }

    public String getName() {
        return this.name;
    }

    public double getEnergy() {
        return this.energy;
    }
}
