class LongestConseSub
{
    public static void main(String args[])
    {
        int a[]={9,12,13,14,4,2,3,5,10};
        disSubArrays(a);
    }    
    static void disSubArrays(int[] a)
    {
        int si=0;
        int ei=0;
        int start=0;
        int end=0;
        for(int i=0;i<a.length-1;i++)
        {
            if(a[i]+1==a[i+1])
            {
                ei++;
            }
            else 
            {
                if(ei-si>end-start)
                {
                    start=si;
                    end=ei;
                }
                si=i+1;
                ei=i+1;
            }
        }
        if(ei-si>end-start)
        {
            start=si;
            end=ei;
        }
        for(int j=start;j<=end;j++)
        {
            System.out.print(a[j]+" ");
        }
    }
}