import java.util.*;
import java.util.HashSet;
class threeSum 
{
    public static void main(String args[])
    {
        int a[]={1,2,3,4,5};
        int target=9;
        pairsB(a, target);
        System.out.println();
        pairsOptimaized(a, target);
    }    
    static void pairsB(int a[],int target)
    {
        for(int i=0;i<a.length-2;i++)
        {
            for(int j=i+1;j<a.length-1;j++)
            {
                for(int k=j+1;k<a.length;k++)
                {
                    if(a[i]+a[j]+a[k]==target)
                        System.out.println(a[i]+" "+a[j]+" "+a[k]);
                }
            }
        }
    }
    static void pairsOptimaized(int a[],int target)
    {
        Set<Integer> set=new HashSet<>();
        for(int x:a)
        {
            set.add(x);
        }
        for(int i=0;i<a.length-2;i++)
        {
            int cur_sum=target-a[i];
            set.remove(a[i]);
            for(int j=i+1;j<a.length;j++)
            {
                int req_sum=cur_sum-a[j];
                if(req_sum!=a[j])
                {
                if(set.contains(req_sum))
                {
                    set.remove(a[j]);
                    set.remove(req_sum);
                    System.out.println(a[i]+" "+a[j]+" "+req_sum);
                }
                }
            }
        }
    }
}
