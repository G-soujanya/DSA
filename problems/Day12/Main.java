import java.util.*;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int a[] = {3, 6, 4, 8};
        int b[] = {4, 6, 8, 3};
        int n = a.length;

        System.out.println( minSwapToMakeArraySame(a, b));
    }

    static int binarySearch(int arr[], int start, int end, int num) {
        //Arrays.sort(arr);
        //int end=arr.length-1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (arr[middle] == num)
                return middle;
            else if (arr[middle] > num)
                end = middle - 1;
            else
                start = middle + 1;
        }
        return -1;
    }

    static int search2(int arr[], int key) {
        int pivot = findPivot2(arr);
        if (pivot == -1)
            return binarySearch(arr, 0, arr.length - 1, key);
        if (arr[0] <= key)
            return binarySearch(arr, 0, pivot - 1, key);
        return binarySearch(arr, pivot, arr.length - 1, key);

    }

    static int findPivot2(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid - 1 != -1 && arr[mid] < arr[mid - 1])
                return mid - 1 + 1;
            if (end != arr.length - 1 && arr[mid] > arr[mid + 1])
                return mid + 1;
            if (arr[start] >= arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    static String pairWithSum(int arr[], int sum) {
        int pivot = findPivot2(arr);
        int start, end;
        start = pivot;
        if (start == -1) {
            start++;
            end = arr.length - 1;
        } else
            end = pivot - 1;
        if (end == -1)
            end = arr.length - 1;
        while (start != end) {
            int gettingSum = arr[start] + arr[end];
            if (gettingSum == sum)
                return arr[start] + " " + arr[end];
            else if (gettingSum > sum) {
                end--;
                if (end == -1)
                    end = arr.length - 1;
            } else {
                start++;
                if (start == arr.length)
                    start = 0;
            }
        }
        return "No such Pair";
    }

    public static void minSwaps(int arr1[], int arr2[]) {
        int swaps = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                int j = i + 1;
                for (; j < arr2.length; j++) {
                    if (arr2[j] == arr1[i])
                        break;
                }
                int temp = arr2[i];
                arr2[i] = arr2[j];
                arr2[j] = temp;
                swaps++;
            }
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(swaps);
    }

    static int minSwaps(int arr[])
    {
        Map<Integer,Integer> map=new HashMap<>();
        int len=arr.length;
        for (int i = 0; i < len; i++) {
            map.put(arr[i],i);
        }
        Arrays.sort(arr);
        int ans=0;
        boolean visited[]=new boolean[len];
        for(int i=0;i<len;i++)
        {
            if(visited[i] || map.get(arr[i])==i)
            {
                continue;
            }
            else
            {
                int j=i;
                int cycle=0;
                while(!visited[j])
                {
                    visited[j]=true;
                    j=map.get(arr[j]);
                    cycle++;
                }
                if(cycle>0)
                {
                    ans+=cycle-1;
                }
            }
        }
        return ans;
    }
    static int minSwapToMakeArraySame(int arr1[],int arr2[])
    {
        Map<Integer,Integer> map=new HashMap<>();
        int len=arr1.length;
        for(int i=0;i<len;i++)
        {
            map.put(arr2[i],i);
        }
        for(int i=0;i<len;i++)
            arr2[i]=map.get(arr1[i]);
        return minSwaps(arr2);
    }
}
