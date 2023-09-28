public class SizeSumDisplay 
{
    public static void main(String args[])
    {
        int size=9;
        int arr[]={5,1,2,4,9,3,1,3,3};
        int i=0;
        int j=0;
        while(i<size-2)
        {
            int sum=0;
            j=i;
            while(j<(i+3))
            {
                sum=sum+arr[j];
                j++;
            }
            if(sum==7)
            {
                int k=3;
                while(k!=0)
                {
                    int l=j-k;
                    System.out.print(arr[l]+" ");
                    k--;
                }
            }
            i++;
            if(sum==7)
            System.out.println("");
        }
    }    
}
