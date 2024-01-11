import java.util.*;
public class Murder {
    public static void main(String args[])
    {
        int arr[]={1,5,3,6,4,7};
        murder(arr);
        merge(arr,0,arr.length-1);
    }
    public static void murder(int arr[])
    {
        int sum=0;
        int currentSum=0;
        for (int i = 0; i < arr.length; i++)
        {
            currentSum=0;
            for (int j = 0; j < i; j++) {
                if(arr[j]<arr[i])
                    currentSum+=arr[j];
            }
            sum+=currentSum;
        }
        System.out.println(sum);
    }
    public static void merge(int arr[],int start,int end)
    {
        if(start>=end)
            return;
        int mid=(start+end)/2;
        merge(arr,start,mid);
        merge(arr,mid+1,end);
        mergeTwo(arr,start,end);
    }


    private static void mergeTwo(int[] arr, int start, int end) {
        int size=end-start+1;
        int res[]=new int[size];
        int i=start;
        int mid=(start+end)/2;
        int j=mid+1;
        int k=0;
        int sum=0;
        while (i<=mid && j<=end)
        {
            if(arr[i]<arr[j])
            {
                res[k++]=arr[i];
                sum+=(end-j+1)*arr[i];
                i++;
            }
            else
            {
                res[k++]=arr[j];
                j++;
            }
        }
        while (i<=mid)
            res[k++]=arr[i++];
        while (j<=end)
            res[k++]=arr[j++];
        int a=0;
        for(int z=start;z<=end;z++){
            arr[z]=res[a];
            a++;

    }
        System.out.println(sum);
    }}
