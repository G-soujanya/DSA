import java.util.*;
import java.util.HashSet;
import java.util.HashMap;
class DiffPairsCount 
{
    public static void main(String args[])
    {
        int arr[]={1,2,3,4,5,6,7,8,2,3,4,5,3,4,4,4};
        int diff=4;
        //System.out.println(countPairs(arr, diff));
        System.out.println(maxFrequencyEle(arr));
    }   
    static int countPairs(int arr[],int diff)
    {
        int count=0;
        Set<Integer> set=new HashSet<>();
        for(var x:arr)
        {
            set.add(x);
        }
        for(var x:arr)
        {
            if(set.contains(x+diff))
                count++;
            if(set.contains(x-diff))
                count++;
            set.remove(x);
        }
        return count;
    } 
    static int maxFrequencyEle(int arr[])
    {
        Map<Integer,Integer> map=new HashMap<>();
        for(var x:arr)
        {
            if(map.containsKey(x))
            {
                map.put(x,map.get(x)+1);
            }
            else 
            {
                map.put(x,0);
            }
        }
        int max=0;
        int index=0;
        for(var x:map.entrySet())
        {
            if(x.getValue()>max)
            {
                max=x.getValue();
                index=x.getKey();
            }
        }
        return index;
    }
}
