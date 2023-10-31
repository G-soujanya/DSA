import java.util.HashSet;
class sumZero 
{
    public static void main(String[] args) 
    {
        int[] arr={4,2,-1,1,6};    
        pairsb(arr);
        System.out.println(subArray(arr));
    }    
    static void pairsb(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            int sum=0;
            int flag=0;
            for(int j=i;j<arr.length;j++)
            {
                sum+=arr[j];
                if(sum==0)
                {
                    flag=j;
                    break;
                }
            }
            if(flag!=0)
            {
                for(int j=i;j<=flag;j++)
                {
                    System.out.print(arr[j]+" ");
                }
                System.out.println();
            }
        }
    }
    static boolean subArray(int arr[])
    {
        HashSet<Integer> set=new HashSet<>();
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(arr[i]==0 || sum==0 || set.contains(sum))
                return true;
            set.add(sum);
        }
        return false;
    }
}
