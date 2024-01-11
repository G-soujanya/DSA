import java.util.*;
public class PerimeterWithConditions {
    public static void main(String args[])
    {
        int arr[]={2,2,4};
        perimeterWithConditions(arr);
    }
    public static void perimeterWithConditions(int arr[])
    {
        Arrays.sort(arr);
        int i=arr.length-3;
        while (i>=0)
        {
            if(arr[i]+arr[i+1]>arr[i+2])
                break;
            else
                i--;
        }
        if(i<0)
            System.out.println(-1);
        else
            System.out.println(arr[i]+" "+arr[i+1]+" "+arr[i+2]);
    }
}
