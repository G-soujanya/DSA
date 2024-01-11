import java.util.*;
public class InterestingSequence {
    public static void main(String args[])
    {
        int arr[]={1,2,3,4,5};
        interestingSequence2(arr,2,1);
    }
    public static void interestingSequence(int arr[],int k,int l)
    {
        Arrays.sort(arr);
        int avg=(arr[0]+arr[arr.length-1])/2;
        int start=0;
        int end=arr.length-1;
        int totalCost=0;
        while (start<=end)
        {
            if(arr[start]!=avg && arr[end]!=avg)
            {
                totalCost+=k;
                arr[start]+=1;
                arr[end]-=1;
                if(arr[start]==avg && arr[end]==avg) {
                    start++;
                    end--;
                }
            }
            else if(arr[start]!=avg)
            {
                totalCost+=l;
                arr[start]+=1;
                if(arr[start]==avg)
                    start++;
            }
            else if(arr[end]!=avg)
            {
                totalCost+=l;
                arr[end]+=1;
                if(arr[end]==avg)
                    end--;
            }
            else
            {
                start++;
                end--;
            }
        }
        System.out.println(totalCost);
    }
    public static void interestingSequence2(int arr[],int k,int l) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        int minCost=Integer.MAX_VALUE;
        int currentCost;
        for (int i = min; i <=max ; i++) {
            int inc=0;
            int dec=0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j]<i)
                   inc+=i-arr[j];
                else if(arr[j]>i)
                    dec+=arr[j]-i;
            }
            currentCost=dec*k;
            if((inc-dec)>0)
                currentCost+=(inc-dec)*l;
            minCost=Math.min(minCost,currentCost);
        }
        System.out.println(minCost);
    }
}
