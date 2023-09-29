class LongestSubArray 
{
    public static void main(String args[])
    {
        int arr[]={1,3,5,4,8};
        int k=8;
        //for(int i=1;i<arr.length;i++)
        for(int size=arr.length;size>0;size--)
        {
            for(int i=0;i<=arr.length-size;i++)
            {
                int sum=0;
                for(int j=i;j<i+size;j++)
                {
                    sum=sum+arr[j];
                }
                if(sum==k)
                {
                    for(int j=i;j<i+size;j++)
                    {
                        System.out.print(arr[j]+" ");
                    }
                    System.out.println();
                    return;
                }
            }
        }
    }        
}
