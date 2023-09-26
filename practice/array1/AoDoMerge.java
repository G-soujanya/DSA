class AoDoMerge 
{
    public static void main(String args[])
    {
        int arr1[]={3,5,7,9,13};
        int arr2[]={19,17,15,9,4,3,2,1};
        int arr3[]=new int[arr1.length+arr2.length];
        int i=0;
        int j=arr2.length-1;
        int k=0;
        while(i<arr1.length&&j>=0)
        {
            if(arr2[j]<=arr1[i])
            {
                arr3[k]=arr2[j];
                k++;
                j--;
            }
            else 
            {
                arr3[k]=arr1[i];
                k++;
                i++;
            }
        }
        while(i<arr1.length)
        {
            arr3[k]=arr1[i];
            i++;
            k++;
        }
        while(j>=0)
        {
            arr3[k]=arr2[j];
            k++;
            j--;
        }
        for(int l=0;l<arr3.length;l++)
        {
            System.out.print(arr3[l]+" ");
        }
    }    
}
