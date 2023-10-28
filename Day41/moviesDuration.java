import java.util.*;
import java.util.HashSet;
class moviesDuration 
{
    public static void main(String args[])
    {
        int arr[]={70,40,55,89};
        System.out.println(pairs(arr));
    }    
    static boolean pairs(int arr[])
    {
        Set<Integer> set=new HashSet<>();
        for(var x:arr)
        {
            set.add(x);
        }
        int target;
        for(int x:arr)
        {
            target=120-x;
            if(set.contains(target))
                return true;
        }
        return false;
    }
}
