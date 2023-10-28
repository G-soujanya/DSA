import java.util.*;
import java.util.HashSet;
class twoArrayRep 
{
    public static void main(String[] args) 
    {
        int arr[]={1,2,3};
        int arr1[]={3,4,5};
        /*Set<Integer> set=new HashSet<>();
        for(int x:arr)
            set.add(x);
        for(int y:arr1)
        {
            if(set.contains(y))
                System.out.println(y);
        }*/
        for(int x:arr)
        {
            for(int y:arr1)
            {
                if(x==y)
                    System.out.println(x);
            }
        }
    }    
}
