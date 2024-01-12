public class Car extends Vehicle{
    public Car(){

        System.out.println("car constructor");
    }
    int noOfDoors=4;
    public void print()
    {
        System.out.println("car"+getColor()+maxSpeed+noOfDoors);
    }
}
