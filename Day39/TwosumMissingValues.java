import java.util.*;
import java.util.HashSet;
class TwosumMissingValues 
{
    public static void main(String args[])
    {
        int a[]={1,2,3,4,7};
        //twoSumPairs(a, 4);
        missingValues(a, 1, 7);
    }    
    static void twoSumPairs(int a[],int target)
    {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<a.length;i++)
        {
            map.put(a[i],i);
        }
        int required;
        for(int i=0;i<a.length;i++)
        {
            required=target-a[i];
            if(map.containsKey(required))
            {
                System.out.println(map.get(required)+" "+i);
            }
            map.remove(a[i]);
        }
    }
    static void missingValues(int a[],int low,int high)
    {
        Set<Integer> set=new HashSet<>();
        for(int x:a)
        {
            set.add(x);
        }
        for(int i=low+1;i<high;i++)
        {
            if(!set.contains(i))
                System.out.println(i);
        }
    }
}
