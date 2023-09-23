import java.util.Arrays;
import java.util.Scanner;

class SmallestUniqueElements {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array size");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the array elements");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int count=1;
        int max=Integer.MIN_VALUE;
        //int min=Integer.MAX_VALUE;
        int i=0;
        for(i=0;i<n-1;i++)
        {
            if(arr[i]==arr[i+1])
            {
                count++;
            }
            else 
            {
                if(count>1)
                {
                    if(count>max)
                        max=arr[i];
                }
                count=1;
            }
        }
        if(count>max)
        System.out.println(arr[n-1]+" "+count);
        System.out.println(arr[i]);
    }
}
