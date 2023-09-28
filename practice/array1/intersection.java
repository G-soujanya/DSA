class intersection
{
    public static void main(String args[])
    {
        int size1=6;
        int arr1[]={3,5,6,8,8,9};
        int size2=7;
        int arr2[]={2,3,4,6,7,8,8};
        int i=0;
        int j=0;
        while(i<size1 && j<size2)
        {
            if(arr1[i]==arr2[j])
            {
                System.out.print(arr1[i]+" ");
                i++;
                j++;
            }
            else if(arr2[j]<arr1[i])
                j++;
            else 
                i++;
        }
        System.out.println("");
    }
}