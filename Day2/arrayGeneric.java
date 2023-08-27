class arrayGeneric 
{
    public static void main(String arg[])
    {
        MyArray<Integer> m=new MyArray();
        m.addItem(10);
        m.addItem(20);
        //m.addItem("soujanya");
        m.display();
    }
}
/*class MyArray<T> 
{
    Object[] items;
    int count;
    MyArray(){
        items=new Object[10];
    }
    void addItem(Object i)
    {
        items[count++]=i;
    }
    void display()
    {
        for(Object b:items)
        {
            System.out.println(b);
        }
    }
}*/
class MyArray<T>
{
    Object[] items;
    int count;
    MyArray()
    {
        items=new Object[10];
    }
    void addItem(T i)
    {
        items[count++]=i;
    }
    void display()
    {
        for(Object b:items)
        {
            System.out.println(b);
        }
    }
}