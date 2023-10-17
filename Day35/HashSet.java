class HashSetIm 
{
    public static void main(String args[])
    {
        HashSet set=new HashSet();
        set.add(79);
        System.out.println(set.get(79));
        set.add(5);
        System.out.println(set.get(5));
    }    
}
class HashSet 
{
    int arr[]=new int[10];
    void add(int n)
    {
        arr[hash(n)]=n;
    }
    int hash(int num)
    {
        return num%arr.length;
    }
    int get(int n)
    {
        return arr[hash(n)];
    }
}
