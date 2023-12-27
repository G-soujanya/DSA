class Main
{

public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9,1,2 ,3, 4};
        System.out.println(search2(arr,6));
    }
  //search for an element in sorted rotated array
    public static int search(int arr[],int key)
    {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(arr[mid]==key)
                return mid;
            else if(arr[mid]>key)
            {
                if(arr[start]>key)
                    start=mid+1;
                else 
                    end=mid-1;
            }
            else 
            {
                if(arr[end]<key)
                    end=mid-1;
                else 
                    start=mid+1;
            }
        }
        return -1;
    }
    public static int search2(int arr[],int key)
    {
        int pivot=findPivot2(arr);
        if(pivot==-1)
            return binarySearch(arr,0,arr.length-1,key);
        if(arr[0]>=key)
            return binarySearch(arr, 0, pivot-1, key);
        return binarySearch(arr, pivot, arr.length-1, key);
        
    }
    private static int findPivot2(int arr[])
    {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(mid-1!=-1 && arr[mid]<arr[mid-1])
                return mid-1+1;
            if(arr[mid]>arr[mid+1])
                return mid+1;
            if(arr[start]>=arr[mid])
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
  static int binarySearch(int arr[],int start,int end,int num)
    {
        //Arrays.sort(arr);
        //int end=arr.length-1;
        while(start<=end)
        {
            int middle=(start+end)/2;
            if(arr[middle]==num)
                return middle;
            else if(arr[middle]>num)
                end=middle-1;
            else
                start=middle+1;
        }
        return -1;
    }
    static int search2(int arr[],int key)
    {
        int pivot=findPivot2(arr);
        if(pivot==-1)
            return binarySearch(arr,0,arr.length-1,key);
        if(arr[0]<=key)
            return binarySearch(arr, 0, pivot-1, key);
        return binarySearch(arr, pivot, arr.length-1, key);

    }
    static int findPivot2(int arr[])
    {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(mid-1!=-1 && arr[mid]<arr[mid-1])
                return mid-1+1;
            if(end!=arr.length-1 && arr[mid]>arr[mid+1])
                return mid+1;
            if(arr[start]>=arr[mid])
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
    static String pairWithSum(int arr[],int sum)
    {
        int pivot=findPivot2(arr);
        int start,end;
        start=pivot;
        if(start==-1) {
            start++;
            end=arr.length-1;
        }
        else
        end=pivot-1;
        if(end==-1)
            end=arr.length-1;
        while(start!=end)
        {
            int gettingSum=arr[start]+arr[end];
            if(gettingSum==sum)
                return arr[start]+" "+arr[end];
            else if(gettingSum>sum)
            {
                end--;
                if(end==-1)
                    end=arr.length-1;
            }
            else
            {
                start++;
                if(start==arr.length)
                    start=0;
            }
        }
        return "No such Pair";
    }
}
