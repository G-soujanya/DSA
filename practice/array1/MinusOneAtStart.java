class MinusOneAtStart 
{
    public static void main(String args[])
    {
        int arr[]={5,-1,4,6,-1,9,2,-1,8,2};
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        rearrange(arr);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void rearrange(int[] a)
    {
        int i=a.length-1;
        int j=a.length-1;
        while(i>=0)
        {
            if(a[i]==-1)
                i--; 
            else 
            {
                a[j]=a[i]; 
                j--;
                i--;
            }
        }
        while(j>=0)
        {
            a[j]=-1;
            j--;
        }
    }
}