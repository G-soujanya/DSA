public class DynamicArray {
    private int data[];
    private int nextElementIndex;
    public DynamicArray()
    {
        data=new int[5];
        nextElementIndex=0;
    }
    public int size()
    {
        return nextElementIndex;
    }
    public boolean isEmpty()
    {
        return nextElementIndex==0;
    }
    public int get(int i)
    {
        if(i>=nextElementIndex)
            throw new ArrayIndexOutOfBoundsException();
        return data[i];
    }
    public void set(int i,int num)
    {
        data[i]=num;
    }
    public void add(int num)
    {
        if(nextElementIndex==data.length)
        {
            int data1[]=new int[data.length*2];
            for (int i = 0; i < data.length; i++) {
                data1[i]=data[i];
            }
            data=data1;
        }
        data[nextElementIndex++]=num;
    }
    public int removeLast()
    {
        int temp=data[nextElementIndex-1];
        data[nextElementIndex-1]=0;
        nextElementIndex--;
        return temp;
    }
}
