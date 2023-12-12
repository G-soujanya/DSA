import java.util.*;
class Main
{
    public static void main(String args[])
    {
        // int arr1[]={10,10};
        // int arr2[]={10};
        // intersection2(arr1, arr2);
        int arr[]={0,3,1,5,4,3,2};
        // System.out.println(equilibriumIndex(arr));
        // System.out.println(equilibriumIndexB(arr));
        System.out.println(findDuplicates2(arr));
    }
    static int binarySearch(int arr[],int value)
    {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(arr[mid]==value)
                return mid;
            else if(arr[mid]>value)
                end=mid-1;
            else 
                start=mid+1;
        }
        return -1;
    }
    static void intersection(int arr1[],int arr2[])//time complexity is mlogm(for sorting)+nlogn+m+n(for traversing)
    {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i=0;
        int j=0;
        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i]==arr2[j])
            {
                System.out.print(arr1[i]+" ");
                i++;
                j++;
            }
            else if(arr1[i]<arr2[j])
            {
                i++;
            }
            else 
                j++;
        }
        System.out.println();
    }
    static void intersection2(int arr1[],int arr2[])//sort smaller length array nlogn(for sorting)+mlogn
    {                                               //logn(binary search),m for m element searching in larger array
        if(arr1.length>arr2.length)                 //this better then above because logn going to be because we sorting
        {                                            //smaller length array not in above case we have sort both
            Arrays.sort(arr2);                      //disadvantage duplicates not allowed in binary search
            for(int i=0;i<arr1.length;i++)
            {
                if(binarySearch(arr2, arr1[i])!=-1)
                    System.out.print(arr1[i]+" ");

            }
        }
        else 
        {
            Arrays.sort(arr1);
            for(int i=0;i<arr2.length;i++)
            {
                if(binarySearch(arr1, arr2[i])!=-1)
                    System.out.print(arr2[i]+" ");

            }
        }
        System.out.println();
    }
    static int equilibriumIndex(int arr1[])
    {
        int sum=0;
        for(int i=0;i<arr1.length;i++)
        {
            sum+=arr1[i];
        }
        int i=0;
        int leftSum=0;
        while(i<arr1.length)
        {
            if(sum-arr1[i]==2*leftSum)
                return i;
            leftSum+=arr1[i];
            i++;
        }
        return -1;
    }
    static int equilibriumIndex2(int arr1[])
    {
        int sum=0;
        for(int i=0;i<arr1.length;i++)
        {
            sum+=arr1[i];
        }
        int i=0;
        int leftSum=0;
        while(i<arr1.length)
        {
            sum-=arr1[i];
            if(sum==leftSum)
                return i;
            leftSum+=arr1[i];
            i++;
        }
        return -1;
    }
    static int equilibriumIndexB(int arr1[])
    {
        int leftSum=0;
        for(int  i=0;i<arr1.length;i++)
        {
            int rightSum=0;
            for(int j=i+1;j<arr1.length;j++)
            {
                rightSum+=arr1[j];
            }
            if(leftSum==rightSum)
                return i;
            leftSum+=arr1[i];
        }
        return -1;
    }
    //finding unique element using xor operation
    static int findDuplicates(int arr[])//n^2
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                    return arr[i];
            }
        }
        return -1;
    }
    static int findDuplicates2(int arr[])//nlogn(for sortin)+n(for traversing)
    {
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==arr[i-1])
                return arr[i];
        }
        return -1;
    }
    static int findDuplicates3(int arr[])
    {
        int n=arr.length-2;
        int sum=(n*(n+1))/2;
        int originalSum=0;
        for(int i=0;i<arr.length;i++)
            originalSum+=arr[i];
        return sum-originalSum;
    }
}