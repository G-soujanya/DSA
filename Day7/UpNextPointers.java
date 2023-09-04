class UpNextPointers 
{
    public static void main(String args[])
    {
        List list=new List();
        list.insert(20);
       list.insert(2);
        list.insert(3);
        list.insert(60);
        list.insert(80);
        list.insert(9);
        list.displayLessThanTen();
        list.displayGreaterThanTen();
    }    
}
class Node 
{
    int data;
    Node up;
    Node next;
    Node(int value)
    {
        data=value;
    }
}
class List 
{
    Node head;
    void insert(int value)
    {
        Node node=new Node(value);
        if(head==null )
        {
            head=node;
            return;
        }
        else
        {

            if(value<10)
            {
                var current=head;
                while(current.up!=null)
                {
                    current=current.up;
                }
                current.up=node;
            }
            else 
            {
                var current=head;
                while(current.next!=null)
                {
                    current=current.next;
                }
                current.next=node;
            }
        }
    }
    void displayLessThanTen()
    {
        var current=head;
        while(current!=null)
        {
            if(current.data<10)
            System.out.println(current.data);
            current=current.up;
        }
    }
    void displayGreaterThanTen()
    {
        var current=head;
        while(current!=null)
        {
            if(current.data>10)
            System.out.println(current.data);
            current=current.next;
        }
    }
}
