import java.util.HashSet;
import java.util.*;
class fourSum 
{
    public static void main(String args[])
    {
        int a[]={10,2,3,4,5,9,7,8};
        int target=23;
        pairsB(a, target);
        System.out.println();
        pairsOptimaized(a, target);
    }  
    static void pairsB(int a[],int target)
    {
        for(int i=0;i<a.length-3;i++)
        {
            for(int j=i+1;j<a.length-2;j++)
            {
                for(int k=j+1;k<a.length-1;k++)
                {
                    for(int l=k+1;l<a.length;l++)
                    {
                    if(a[i]+a[j]+a[k]+a[l]==target)
                        System.out.println(a[i]+" "+a[j]+" "+a[k]+" "+a[l]);
                    }
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
        for(int i=0;i<a.length-3;i++)
        {
            int cur_sum=target-a[i];
            set.remove(a[i]);
            for(int j=i+1;j<a.length-2;j++)
            {
                int req_sum=cur_sum-a[j];
                for(int k=j+1;k<a.length;k++)
                {
                    int reqired=req_sum-a[k];
                if(reqired!=a[k])
                {
                if(set.contains(reqired))
                {
                    set.remove(a[j]);
                    set.remove(a[k]);
                    set.remove(reqired);
                    System.out.println(a[i]+" "+a[j]+" "+a[k]+" "+reqired);
                }
                }
                }
            }
        }
    } 
}
