class CircularQueue
{
    public static void main(String args[])
    {
        QueueImplementaion queue=new QueueImplementaion();
        queue.offerFirst(10);
        queue.offerLast(20);
        queue.offerFirst(5);
        queue.offerFirst(3);
        queue.offerLast(25);
        System.out.println(queue.pollFirst());
        System.out.println(queue.pollFirst());
        System.out.println(queue.isEmpty());
    }
}
class QueueImplementaion
{
    private class Node
    {
        int data;
        Node prev;
        Node next;
        Node(int value)
        {
            data=value;
        }
    }
    Node head;
    Node tail;
    int count;
    void offerLast(int value)
    {
        Node node=new Node(value);
        if(head==null)
        {
            head=tail=node;
        }
        else 
        {
            tail.next=node;
            node.prev=tail;
            tail=node;
        }
        count++;
    }
    void offerFirst(int value)
    {
        Node node=new Node(value);
        if(head==null)
        {
            head=tail=node;
        }
        else{
            node.next=head;
            head.prev=node;
            head=node;
        }
        count++;
    }
    void display()
    {
        Node current=head;
        while(current!=null)
        {
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println();
    }
    int size()
    {
        return count;
    }
    boolean isEmpty()
    {
        return count==0;
    }
    int getFront()
    {
        if(isEmpty())
            throw new IllegalStateException();
        return head.data;
    }
    int pollLast()
    {
        if(isEmpty())
            throw new IllegalStateException();
        count--;
        int x;
        if(head.next==null)
        {
            x=tail.data;
            head=tail=null;
        }
        else{
        x=tail.data;
        tail=tail.prev;
        tail.next=null;
        }
        return x;
    }
    int pollFirst()
    {
        if(isEmpty())
            throw new IllegalStateException();
        count--;
        int x;
        if(head.next==null)
        {
            x=tail.data;
            head=tail=null;
        }
        else{
        x=head.data;
        head=head.next;
        head.prev=null;
        }
        return x;
    }
}
