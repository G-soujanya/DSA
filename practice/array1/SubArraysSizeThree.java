public class SubArraysSizeThree 
{
    public static void main(String args[])
    {
        int size=9;
        int arr[]={5,1,2,4,9,3,1,3,3};
        int i=0;
        int j=0;
        int count=0;
        while(i<size-2)
        {
            int sum=0;
            j=i;
            while(j<(i+3))
            {
                //System.out.print(arr[j]+" ");
                sum=sum+arr[j];
                j++;
            }
            if(sum==7)
            {
                //System.out.println(i);
                count++;
            }
            i++;
            //System.out.println("");
        }
        System.out.println(count);
    }    
}
