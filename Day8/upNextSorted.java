class upNextSorted 
{
    public static void main(String args[])
    {
        LinkedListUpNext list=new LinkedListUpNext();
        list.insert(10);
        list.insert(20);
        list.insert(5);
        list.insert(8);
        list.insert(3);
        list.insert(30);
        list.insert(15);
        System.out.println(list.search(10));
        System.out.println(list.search(0));
        System.out.println(list.search(15));
        System.out.println(list.search(90));
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
class LinkedListUpNext 
{
    Node head;
    void insert(int value)
    {
        Node node=new Node(value);
        if(head==null)
        {
            head=node;
            return;
        }
        var current=head;
        while(current!=null)
        {
            if(current.data>value)
            {
                if(current.up==null)
                {
                    current.up=node;
                    return;
                }
                current=current.up;
            }
            else 
            {
                if(current.next==null)
                {
                    current.next=node;
                    return;
                }
                current=current.next;
            }
        }
    }
    boolean search(int value)
    {
        if(head==null)
            throw new IllegalStateException();
        var current=head;
        while(current!=null)
        {
            if(current.data==value)
            {
                return true;
            }
            if(current.data>value)
            {
                    current=current.up;
            }
            else 
            {
                    current=current.next;
            }
        }
        return false;
    }
}