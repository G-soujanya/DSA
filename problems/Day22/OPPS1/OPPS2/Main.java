// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//    Bicycle b=new Bicycle();
//    b.setColor("black");
//    b.maxSpeed=100;
//    System.out.println(b.getColor());
//    System.out.println(b.maxSpeed);
//    System.out.println(b.noOfWheels);
//        Car c=new Car();
//        b.print();
//        c.print();

        Car c=new Car();
        Vehicle v=new Car();
        Car c1=(Car)v;
        System.out.println(c1.noOfDoors);

    }
}