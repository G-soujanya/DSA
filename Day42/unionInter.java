import java.util.HashSet;
class unionInter
{
    public static void main(String args[])
    {
        int[] arr1={8,2,9,4,5,2};
        int arr2[]={8,3,2,7,4};
        //uni(arr1,arr2);
        inter(arr1, arr2);
    }    
    static void uni(int arr1[],int arr2[])
    {
        HashSet<Integer> set=new HashSet<>();
        for(var x:arr1)
        {
            set.add(x);
        }

        for(var y:arr2)
        {
            set.add(y);
        }
        for(var h:set)
        {
            System.out.print(h+" ");
        }
        System.out.println();
    }
    static void inter(int arr1[],int arr2[])
    {
        HashSet<Integer> set=new HashSet<>();
        for(var x:arr1)
        {
            set.add(x);
        }

        for(var y:arr2)
        {
            if(set.contains(y))
                System.out.print(y+" ");
        }
        System.out.println();
    }
}
