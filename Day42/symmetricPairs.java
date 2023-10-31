import java.util.HashMap;
class symmetricPairs 
{
    public static void main(String args[])
    {
        int arr[][]={{11,20},{30,40},{5,10},{40,30},{10,5}};
        symmetricb(arr);
        System.out.println("h");
        symmetric(arr);
    }    
    static void symmetricb(int arr[][])
    {
        int rows=5;
        for(int i=0;i<rows;i++)
        {
            for(int j=i+1;j<rows;j++)
            {
                if(arr[i][0]==arr[j][1] && arr[i][1]==arr[j][0])
                {
                    System.out.println(arr[i][0]+" "+arr[i][1]);
                }
            }
        }
    }
    static void symmetric(int arr[][])
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(var x:arr)
        {
            map.put(x[0], x[1]);
        }
        for(var y:arr)
        {
            if(map.containsKey(y[1]))
            {
                var x=map.get(y[1]);
                if(x==y[0])
                {
                    map.remove(y[0]);
                    System.out.println(y[0]+" "+y[1]);
                }
            }
        }
    }
}