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
       // System.out.println(list.minElement());
        //list.minElementRec(list.head);
        //System.out.println(list.maxElement());
        //list.maxElementRec(list.head);
        //list.display(list.head);
        list.displayInc(list.head);
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
    int minElement()
    {
        if(head==null)
            throw new IllegalStateException();
        var current=head;
        while(current.up!=null)
        {
            current=current.up;
        }
        return current.data;
    }
    int maxElement()
    {
        if(head==null)
            throw new IllegalStateException();
        var current=head;
        while(current.next!=null)
        {
            current=current.next;
        }
        return current.data;
    }
    void minElementRec(Node node)
    {
        if(node.up==null)
        {
            System.out.println(node.data);
            return;
        }
        minElementRec(node.up);
    }
    void maxElementRec(Node node)
    {
        if(node.next==null)
        {
            System.out.println(node.data);
            return;
        }
        maxElementRec(node.next);
    }
    void display(Node node)
    {
        if(node==null)
            return;
        display(node.up);
        System.out.println(node.data);
        display(node.next);
    }
    void displayInc(Node node)
    {
        if(node==null)
            return;
        displayInc(node.next);
        System.out.println(node.data);
        displayInc(node.up);
    }
}
