import java.util.*;
class nfibonacci
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number");
        int n=sc.nextInt();
        int a[]=new int[n];
        a[0]=1;
        a[1]=1;
        int prev2=a[0];
        int prev1=a[1];
        for(int i=2;i<n;i++)
        {
            a[i]=prev1+prev2;
            prev2=prev1;
            prev1=a[i];
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();
        System.out.println(a[n-1]);
    }
}
