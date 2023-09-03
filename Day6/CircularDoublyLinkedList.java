class CircularDoublyLinkedList 
{
    public static void main(String args[])
    {
        CDLL list=new CDLL();
        list.addLastOptimized(60);
        list.addLastOptimized(70);
        list.addLastOptimized(90);
        list.display();
        list.reverse();
        list.display();
    }    
}
class Node 
{
    Node prev;
    int data;
    Node address;
    Node(int value)
    {
        data=value;
    }
}
class CDLL 
{
    Node head;
    int count;
    boolean isEmpty()
    {
        if(head==null)
            return true;
        return false;
    }
    void display()
    {
        var current=head;
        do
        {
            System.out.println(current.data);
            current=current.address;
        }while(current!=head);
    }
    void addFirst(int data)
    {
        Node node=new Node(data);
        count++;
        if(head==null)
        {
            head=node;
            head.prev=head.address=node;
        }
        else 
        {
            var current=head;
            do
            {
                current=current.address;
            }while(current.address!=head);
            node.prev=head.prev;
            node.address=head;
            head.prev=node;
            current.address=node;
            head=node;
        }
    }
    void addLast(int data)
    {
        Node node=new Node(data);
        count++;
        if(head==null)
        {
            head=node;
            head.prev=head.address=node;
        }
        else 
        {
            var current=head;
            do
            {
                current=current.address;
            }while(current.address!=head);
            node.prev=current.address;
            node.address=current.address;
            current.address=node;
            head.prev=node;
        }
    }
    void removeFirst()
    {
        count--;
        if(isEmpty())
            throw new IllegalStateException();
        if(head.address==head)
        {
            head=null;
        }
        else 
        {
            var current=head;
            do
            {
                current=current.address;
            }while(current.address!=head);
            head.address.prev=head.prev;
            head=head.address;
            current.address=head;
        }
    }
    void removeLast()
    {
        count--;
        if(isEmpty())
            throw new IllegalStateException();
        if(head.address==head)
        {
            head=null;
        }
        else 
        {
            var current=head;
            Node previous=null;
            do
            {
                previous=current;
                current=current.address;
            }while(current.address!=head);
            previous.address=current.address;
            head.prev=previous;
        }
    }
    void addFirstOptimized(int data)
    {
        Node node=new Node(data);
        count++;
        if(head==null)
        {
            head=node;
            head.prev=head.address=node;
        }
        else 
        {
            int temp=node.data;
            node.data=head.data;
            head.data=temp;
            head.address.prev=node;
            node.address=head.address;
            node.prev=head;
            head.address=node;
        }
    }
    void addLastOptimized(int data)
    {
        Node node=new Node(data);
        count++;
        if(head==null)
        {
            head=node;
            head.prev=head.address=node;
        }
        else 
        {
            int temp=node.data;
            node.data=head.data;
            head.data=temp;
            head.address.prev=node;
            node.address=head.address;
            node.prev=head;
            head.address=node;
            head=node;
        }
    }
    void removeFirstOptimized()
    {
        count--;
        if(isEmpty())
            throw new IllegalStateException();
        if(head.address==head)
        {
            head=null;
        }
        else 
        {
            int temp=head.data;
            head.data=head.address.data;
            head.address.data=temp;
            Node tempNode=head.address;
            head.address=head.address.address;
            tempNode.address=null;
        }
    }
    int getSize()
    {
        return count;
    }
    void reverse()
    {
        if(isEmpty())
            throw new IllegalStateException();
        var current1=head;
        do
        {
            current1=current1.address;
        }while(current1.address!=head);
        Node prev=current1;
        Node next=null;
        Node current=head;
        do 
        {
            next=current.address;
            current.prev=current.address;
            current.address=prev;
            prev=current;
            current=next;
        }while(current!=head);
        head=prev;
    }
}
