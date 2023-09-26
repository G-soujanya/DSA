class sorted_array 
{
    public static void main(String args[])
    {
        int arr1[]={3,5,7,9,13};
        int arr2[]={1,2,3,4,9,15,17,19};
        int arr3[]=new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while(i<arr1.length && j<arr2.length)
        {
            if(arr2[j]<=arr1[i])
            {
                arr3[k]=arr2[j];
                j++;
                k++;
            }
            else 
            {
                arr3[k]=arr1[i];
                k++;
                i++;
            }
        }
        while(j<arr2.length)
        {
            arr3[k]=arr2[j];
                j++;
                k++;
        }
        while(i<arr1.length)
        {
            arr3[k]=arr1[i];
                k++;
                i++;
        }
        for(k=0;k<arr3.length;k++)
        {
            System.out.print(arr3[k]+" ");
        }
    }    
}