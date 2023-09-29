class MinusOneAtStart 
{
    public static void main(String args[])
    {
        int arr[]={5,-1,3,-1,4,5,3,-1,8,2};
        int count=0;
        int arr1[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==-1)
                 count++;
        }  
        int i=0;
        while(count!=0)
        {
            arr1[i]=-1;
            count--;
            i++;
        }  
        int j=0;
        while(i<arr1.length)
        {
            if(arr[j]!=-1)
            {
                arr1[i]=arr[j];
                i++;
                j++;
            }
            else 
                j++;
        }
        for(int k=0;k<arr1.length;k++)
        {
            System.out.print(arr1[k]+" ");
        }
    }    
}
