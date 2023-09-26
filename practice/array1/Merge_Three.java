class Merge_Three 
{
    public static void main(String args[])
    {
        int i=0;
        int arr1[]={2,3,4};
        int arr2[]={5,6,7,8};
        int arr3[]={9,10,11,12,13};
        int arr4[]=new int[arr1.length+arr2.length+arr3.length];
        int k=0;
        while(k<arr4.length)
        {
            if(i<arr1.length)
            {
                arr4[k]=arr1[i];
                k++;
            }
            if(i<arr2.length)
            {
                arr4[k]=arr2[i];
                k++;
            }
            if(i<arr3.length)
            {
                arr4[k]=arr3[i];
                k++;
            }
            i++;
        }
        for(int o=0;o<arr4.length;o++)
        {
            System.out.print(arr4[o]+" ");
        }
    }    
}
