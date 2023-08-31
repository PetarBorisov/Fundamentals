package P05CarSalesman;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Engine {
    private String modelOfEngine;
    private String power;
    int  displacement;
    String efficiency;

    public Engine(String _model,String _power,int _displacement,String _efficiency){
        this.modelOfEngine=_model;
        this.power=_power;
        this.displacement=_displacement;
        this.efficiency=_efficiency;
    }

    public Engine(String modelOfEngine, String power, int  displacement) {
        this.modelOfEngine = modelOfEngine;
        this.power = power;
        this.displacement = displacement;
        this.efficiency="n/a";
    }

    public Engine(String modelOfEngine, String power, String efficiency) {
        this.modelOfEngine = modelOfEngine;
        this.power = power;
        this.displacement=-1;
        this.efficiency = efficiency;
    }

    public Engine(String modelOfEngine, String power) {
        this.modelOfEngine = modelOfEngine;
        this.power = power;
        this.efficiency="n/a";
        this.displacement=-1;
    }

    public String getModelOfEngine() {
        return modelOfEngine;
    }

    public String getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

}