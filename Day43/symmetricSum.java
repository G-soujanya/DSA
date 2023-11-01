import java.util.HashMap;
class symmetricSum 
{
    public static void main(String args[])
    {
        int arr[]={3,4,5,2,7,8,6};
        sum(arr);
    }    
    static void sum(int arr[])
    {
        HashMap<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                int sum=arr[i]+arr[j];
                if(map.containsKey(sum))
                {
                    int[] x=map.get(sum);
                    System.out.println("("+arr[i]+" "+arr[j]+")"+"             "+"("+x[0]+" "+x[1]+")");
                    map.remove(sum);
                }
                else
                {
                    map.put(sum,new int[] {arr[i],arr[j]});
                }
            }
        }
    }
}
