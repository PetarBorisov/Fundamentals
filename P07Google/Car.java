package P07Google;

public class Car {
    private String childName;
    private double speed;

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Car(String childName, double speed) {
        this.childName = childName;
        this.speed = speed;
    }
}
