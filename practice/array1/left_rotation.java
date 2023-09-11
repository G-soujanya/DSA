import java.util.* ;
import java.io.*; 


public class Solution {

    static int[] rotateArray(int[] arr, int n) {
        int temp=arr[0];
        for(int i=0;i<n;i++)
        {
            if(i!=n-1)
            {
            arr[i]=arr[i+1];
            }
        }
        arr[n-1]=temp;
        return arr;
    }
}
