package P05CarSalesman;

public class Car {
    private String model;
    private String engineType;
    private int weight;
    private String color;

    Car(String _model,String _engineType,int _wight,String _color){
        this.model=_model;
        this.engineType=_engineType;
        this.weight=_wight;
        this.color=_color;
    }
    Car(String _model,String _engineType,String _color){
        this.model=_model;
        this.engineType=_engineType;
        this.weight=0;
        this.color=_color;
    }
    Car(String _model,String _engineType,int _wight){
        this.model=_model;
        this.engineType=_engineType;
        this.weight=_wight;
        this.color="n/a";
    }

    public Car(String model, String engineType) {
        this.model = model;
        this.engineType = engineType;
        this.color="n/a";
    }

    public String getModel() {
        return model;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String getEngineType() {
        return engineType;
    }
}