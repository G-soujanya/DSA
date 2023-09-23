import java.util.*;
class LargestUniqueElement {
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
        for(int i=0;i<n-1;i++)
        {
            if(arr[i]==arr[i+1])
            {
                count++;
            }
            else 
            {
                if(count==1)
                {
                    if(arr[i]>max)
                        max=arr[i];
                    System.out.println(arr[i]+" "+count);
                }
                count=1;
            }
        }
        if(count==1)
        System.out.println(arr[n-1]+" "+count);
        System.out.println("maximum element is"+max);
    }
}