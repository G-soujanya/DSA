import java.util.Scanner;

class ArraysSumMaxMin 
{
    public static void main(String args[])
    {
        System.out.println("Enter the size of array");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("enter array elements");
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=0;
            for(int j=0;j<n;j++)
            {
                if(i!=j)
                    sum=sum+a[j];
            }
            if(sum>max)
            {
                max=sum;
            }
            if(sum<min)
            {
                min=sum;
            }
        }
        System.out.println("minimum sum is array elements of length minus one "+min+" max is "+max);
    }    
}