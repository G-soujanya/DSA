package user;

public class User {

    public String name;
    public static int rollNo=0;
    public User(String name)
    {
        this.name=name;
        rollNo++;
    }

    public int getRollNo()
    {
        return rollNo;
    }
    public void print(){
        System.out.println(this.name+" "+this.rollNo);
    }

}
