class LinkedList 
{
    public static void main(String args[])
    {
        linkedlist list=new linkedlist();
        /*list.addLast(10);
        list.display();
        list.addFirst(20);
        list.removeFirst();
        list.display();
        System.out.println(list.getSize());
        System.out.println(list.isEmpty());
        System.out.println(list.contains(20));
        System.out.println(list.indexOf(20));
        System.out.println(list.valueOf(10));*/
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.removeLast();
        list.display();
    }    
}
class node 
{
    int data;
    node address;
    node(int d)
    {
        data=d;
    }
}
class linkedlist 
{
    node head;
    node tail;
    void addLast(int d)
    {
        node node=new node(d);
        if(head==null)
        {
            head=tail=node;
        }
        else 
        {
            tail.address=node;
            tail=node;
        }
    }
    void display()
    {
        var current=head;
        while(current!=null)
        {
            System.out.println(current.data);
            current=current.address;
        }
    }
    void addFirst(int d)
    {
        node node=new node(d);
        if(head==null)
            head=tail=node;
        node.address=head;
        head=node;
    }
    void removeFirst()
    {
        if(head==null)
            throw new IllegalStateException();
        else if(head==tail)
            head=tail=null; 
        else 
        {
            node temp;
            temp=head.address;
            head.address=null; 
            head=temp;
        }
    }
    int getSize()
    {
        int count=0;
        var current=head; 
        while(current!=null)
        {
            count++;
            current=current.address;
        }
        return count;
    }
    boolean isEmpty()
    {
        if(head==null)
            return true; 
        return false;
    }
    boolean contains(int value)
    {
        var current=head;
        if(head==null)
        {
            throw new IllegalArgumentException();
        }
        while(current!=null)
        {
            if(current.data==value)
                return true; 
            current=current.address;
        }
        return false;
    }
    int indexOf(int value)
    {
        int count=0;
        var current=head;
        while(current!=null)
        {
            if(current.data==value)
                return count; 
            count++;
            current=current.address;
        }
        return -1;
    }
    int valueOf(int index)
    {
        if(index<0 | index>=getSize())
        {
            throw new IllegalStateException();
        }
        int ind=0;
        var current=head;
        while(current!=null)
        {
            if(ind==index)
                return current.data; 
            ind++;
            current=current.address;
        
        }
        return -1;
    }
    void removeLast()
    {
        var current=head;
        while(current.address!=tail)
        {
            current=current.address;
        }
        current.address=null;
    }
}