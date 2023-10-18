class Linear {
    public static void main(String args[])
    {
        HashSet set=new HashSet();
        set.add(79);
        System.out.println(set.get(79));
        set.add(5);
        System.out.println(set.get(5));
        set.add(56);
        set.add(55);
        System.out.println(set.get(6));
        System.out.println(set.get(7));
    }
}
class HashSet 
{
    int count=0;
    int arr[]=new int[10];
    void add(int n)
    {
        if(count==10)
            throw new IllegalStateException();
        if(arr[hash(n)]==0)
        arr[hash(n)]=n;
        else 
        {
            for(int i=hash(n);i<10;i++)
            {
                if(arr[i]==0)
                    arr[i]=n;
            }
        }
        count++;
    }
    int hash(int num)
    {
        return num%arr.length;
    }
    int get(int n)
    {
        if(count==0)
            throw new IllegalStateException();
        return arr[hash(n)];
    }
}
