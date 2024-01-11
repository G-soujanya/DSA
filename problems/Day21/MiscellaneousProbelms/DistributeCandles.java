import java.util.*;
public class DistributeCandles {
    public static void main(String args[]) {
        int arr[] = {3, 2,3,9};//2,3,3,9   len=4  //1,3,3,4
        distributeCandles2(arr, 5);
        distributeCandles3(arr, 5);
    }

    public static void distributeCandles(int arr[], int numofStudents) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int currentMax = arr[i];
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                int currentEle=arr[j];
                while (currentEle >= currentMax) {
                    currentEle-=currentMax;
                    count++;
                }
            }
            if (count >= numofStudents)
                max = Math.max(max, currentMax);
        }
        System.out.println(max);
    }
    public static void distributeCandles2(int arr[], int numofStudents) {
        int max=-1;
        for (int i = 0; i < arr.length ;i++) {
            max=Math.max(arr[i],max);
        }
        int maxCandies=0;
        for (int i = 1; i <= max; i++) {
            int currentMax=i;
            int count=0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j]>=currentMax)
                {
                    count+=arr[j]/currentMax;
                }
            }
            if(count>=numofStudents)
            {
                maxCandies=Math.max(maxCandies,currentMax);
            }
            else
                break;
        }
        System.out.println(maxCandies);
    }
    public static void distributeCandles3(int arr[], int numofStudents)
    {
        int max=-1;
        int maxCandies=0;
        for (int i = 0; i < arr.length ;i++) {
            max=Math.max(arr[i],max);
        }
        int start=1;
        int end=max;
        while (start<=end)
        {
            int mid=(start+end)/2;
            int count=0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]>=mid)
                {
                    count+=arr[i]/mid;
                }
            }
            if(count<numofStudents)
                end=mid-1;
            else {
                maxCandies=Math.max(maxCandies,mid);
                start=mid+1;
            }
        }
        System.out.println(maxCandies);
    }
}