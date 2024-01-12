package vehicle;

public class Vehicle {
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String color;
    protected static  int maxSpeed;
    public  void print()
    {
        System.out.println("vehicle"+color+maxSpeed);
    }
}
