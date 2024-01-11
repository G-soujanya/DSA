import java.util.*;
public class ProblemDisscussion {
    public static void main(String args[])
    {
        int arr[]={1,5,6,3,7,9};
        problemDissussion(arr,3);
    }
    public static void problemDissussion(int arr[],int k)
    {
        Arrays.sort(arr);
        int small=arr[0]+k;
        int big=arr[arr.length-1]-k;
        if(small>big)
        {
            int temp=small;
            small=big;
            big=temp;
        }
        for (int i = 1; i <arr.length-1 ; i++) {
            int subtracted=arr[i]-k;
            int added=arr[i]+k;
            if(subtracted>=small || added<=big)
                continue;
             if(big-subtracted<=added-small)
                    small=subtracted;
             else
                    big=added;

        }
        System.out.println(big-small);
    }
}
