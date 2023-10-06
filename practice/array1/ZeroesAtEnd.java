class ZeroesAtEnd 
{
    public static void main(String args[])
    {
        int arr[]={0,5,3,2,0,1,4,0,6,8};
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        rearrangeZeroes(arr);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }    
    static void rearrangeZeroes(int[] a)
    {
        int i=0;
        int j=0;
        while(i<a.length)
        {
            if(a[i]==0)
                i++;
            else 
            {
                a[j]=a[i];
                j++;
                i++;
            }
        }
        while(j<a.length)
        {
            a[j]=0;
            j++;
        }
    }
}
