// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//     Student s1=new Student();
//     s1.name="souajanya";
//     s1.rollNo=161;
//     System.out.println(s1.name+" "+s1.rollNo);
//     Student s2=new Student();
//     System.out.println(s2.name+" "+s2.rollNo);
        Polynomial p1=new Polynomial();
        p1.setCoefficient(2,1);
        p1.setCoefficient(3,2);
        p1.setCoefficient(6,4);
        Polynomial p2=new Polynomial();
        p2.setCoefficient(4,3);
        p2.setCoefficient(2,1);
        Polynomial p3=Polynomial.sub(p1,p2);
        p3.print();
    }
}