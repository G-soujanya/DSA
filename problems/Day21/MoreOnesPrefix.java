public class MoreOnesPrefix {
    public static void main(String args[])
    {
//        moreOnesPrefix("",3,0,0);
        recursive("",0,3);
    }
    public static void moreOnesPrefix(String str,int n,int ones,int zeros)
    {
        if(ones<zeros)
            return;
        if(n==0)
        {
            System.out.println(str);
            return;
        }
        moreOnesPrefix(str+"1",n-1,ones+1,zeros);
        moreOnesPrefix(str+"0",n-1,ones,zeros+1);
    }
    public static void recursive(String str,int extraOnes,int remainingPlaces)
    {
        if(remainingPlaces==0)
        {
            System.out.println(str);
            return;
        }
        recursive(str+"1",extraOnes+1,remainingPlaces-1);
        if(0<extraOnes)
        {
            recursive(str+"0",extraOnes-1,remainingPlaces-1);
        }
    }
}
