// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println(minCount(7));
    }
    public static void printASRoeNoOfTime(int arr[][])
    {
        int rows=arr.length;
        int columns=arr[0].length;
        for (int i = 0; i < rows; i++) {
            for(int k=rows-i;k>0;k--) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    public static int maxProfitOnApp(int[] arr,int buyers)
    {
        int max=Integer.MIN_VALUE;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++)
        {
            int buyers1=arr[i]*(buyers-i);
            if(buyers1>max)
                max=buyers1;
        }
        return max;
    }
    public static int minCount(int n)
    {
        if(n<=3)
            return n;
        int res=n;
        for(int i=1;i*i<=n;i++)
        {
            int temp=i*i;
            res=Math.min(res,1+minCount(n-temp));
        }
        return res;
    }
}
