public class LogFact {
    public static void main(String args[])
    {
        int n=3;
        System.out.println(Math.log(fact(n)));
    }
    public static int fact(int n)
    {
        if(n==1)
            return 1;
        return n*fact(n-1);
    }
}
