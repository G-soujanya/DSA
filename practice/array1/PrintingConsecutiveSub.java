class PrintingConsecutiveSub 
{
    public static void main(String args[])
    {
        int a[]={9,12,13,14,4,2,3,5,10};
        disSubArrays(a);
    }    
    static void disSubArrays(int[] a)
    {
        int count=1;
        int max=0;
        for(int i=0;i<a.length-1;i++)
        {
            if(a[i]+1==a[i+1])
                //System.out.print(a[i]+" ");
                count++;
            else 
            {
                //System.out.print(a[i]);
                //System.out.println();
                //System.out.println(count);
                if(count>max)
                    max=count;
                count=1;
            }
        }
        //System.out.println(count);
        if(count>max)
            max=count;
        System.out.println(max);
    }
}
