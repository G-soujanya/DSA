public class QueueUsingLinkedList 
{
    public static void main(String args[])
    {
        QueueImplementation queue=new QueueImplementation();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue());
        queue.display();
    }    
}
class QueueImplementation 
{
    private class Node
    {
        int data;
        Node address;
        Node(int value)
        {
            data=value;
        }
    }
    Node head;
    Node tail;
    int count;
    void enqueue(int value)
    {
        Node node=new Node(value);
        if(head==null)
        {
            head=tail=node;
        }
        else 
        {
            tail.address=node;
            tail=node;
        }
        count++;
    }
    int dequeue()
    {
        if(count==0)
            throw new IllegalStateException();
        int x=head.data;
        if(head==tail)
        {
            head=tail=null;
        }
        else 
        {
            head=head.address;
        }
        count--;
        return x;
    }
    int peek()
    {
        if(count==0)
            throw new IllegalStateException();
        return head.data;
    }
    int size()
    {
        return count;
    }
    boolean isEmpty()
    {
        return count==0;
    }
    void display()
    {
        var current=head;
        while(current!=null)
        {
            System.out.print(current.data+" ");
            current=current.address;
        }
    }
}