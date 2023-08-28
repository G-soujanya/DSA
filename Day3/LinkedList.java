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
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        //list.removeLast();
        //list.display();
        //list.reverse();
        //list.display();
        //System.out.println(list.nextNode(20));
        //System.out.println(list.nextNode(30));
        //System.out.println(list.prevNode(20));
        //System.out.println(list.getElement(4));
        System.out.println(list.getElementReverse(8));
        System.out.println(list.getMiddleElement());
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
        else{
        node.address=head;
        head=node;}
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
    void reverse()
    {
        if(isEmpty())
            return;
        var current=head;
        node next=null;
        node previous=null;
        while(current!=null)
        {
            next=current.address;
            current.address=previous;
            previous=current;
            current=next;
        }
        tail=head;
        tail.address=null;
        head=previous;
    }
    int nextNode(int value)
    {
        if(isEmpty())
            return -1;
        if(contains(value))
        {   
            var current=head;
            while(current.address!=null)
            {
                if(current.data==value)
                    return current.address.data;
                current=current.address;
            }
            return -1;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
    int prevNode(int value)
    {
        if(isEmpty())
            return -1;
        if(contains(value))
        {
            var current=head;
            node prev=null;
            while(current!=null)
            {
                if(current.data==value)
                    if(current.data==head.data)
                        return -1;
                    else
                        return prev.data;
                prev=current;
                current=current.address;
            }
            return -1;
        }
        else
        {
            throw new IllegalArgumentException();
        }     
    }
    int getElement(int k)
    {
        int count=0;
        var current=head;
        while(current!=null)
        {
            if(count==k)
                return current.data;
            count++;
            current=current.address;
        }
        return -1;
    }
    int getElementReverse(int k)
    {
        int size=getSize();
        int count=0;
        int kr=size-k;
        var current=head;
        while(current!=null)
        {
            if(count==kr)
                return current.data;
            count++;
            current=current.address;
        }
        return -1;
    }
    int getMiddleElement()
    {
        int size=getSize();
        int k=size/2;
        if(size%2==1)
        {
            return valueOf(k); 
        }
        else
        {
            return valueOf(k)+valueOf(k-1);
        }
    }
}
