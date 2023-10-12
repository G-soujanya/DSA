import java.util.*;
class FiveSixSeries 
{
    public static void main(String args[])
    {
        fiveSixSeries(6);
    }    
    static void fiveSixSeries(int n)
    {
        Queue<String> queue=new ArrayDeque<>();
        queue.add("5");
        queue.add("6");
        for(int i=0;i<n;i++)
        {
            String temp=queue.remove();
            System.out.println(temp);
            queue.add(temp+"5");
            queue.add(temp+"6");
        }
    }
}
