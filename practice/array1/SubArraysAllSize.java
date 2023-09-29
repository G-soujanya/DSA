class SubArraysAllSize 
{
    public static void main(String args[])
    {
        int arr[]={1,3,5,4,8};
        int k=8;
        //for(int i=1;i<arr.length;i++)
        for(int i=arr.length;i>0;i--)
        {
            printSubArrays(arr, i,k);
        }
    }    
    static void printSubArrays(int []arr,int s,int k)
    {
        int i=0;
        int j=0;
        int sum;
        while(i<=arr.length-s)
        {
            j=i;
            sum=0;
            while(j<(i+s))
            {
                //System.out.print(arr[j]+" ");
                sum+=arr[j];
                j++;
            }
            if(sum==k)
            {
                j=i;
                while(j<(i+s))
                {
                System.out.print(arr[j]+" ");
                //sum+=arreturn;r[j];
                j++;
                }
                return;
            }
            i++;
            if(sum==k)
            System.out.println("");
        }
    }      
}
