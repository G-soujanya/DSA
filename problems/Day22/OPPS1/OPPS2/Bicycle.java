import org.w3c.dom.ls.LSOutput;

public class Bicycle extends Vehicle{
    int noOfWheels=2;
    String color="blue";
    public void print(){
        System.out.println(color+" "+super.getColor());
    }
}
