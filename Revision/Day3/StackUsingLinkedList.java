public class StackUsingLinkedList {

    private class Node
    {
        int data;
        Node next;
        public Node(int value)
        {
            data=value;
        }
    }
    Node head;
    public void push(int value)
    {
        Node node=new Node(value);
        if(isEmpty())
            head=node;
        else {
            node.next=head;
            head=node;
        }
    }
    public int pop()
    {
        if(isEmpty())
            throw new IllegalStateException();
        int x;
        if(head.next==null) {
            x=head.data;
            head = null;
        }
        else
        {
            x=head.data;
            head=head.next;
        }
        return x;
    }
    public boolean isEmpty()
    {
        return head==null;
    }
    public int peek()
    {
        if(isEmpty())
            throw new IllegalStateException();
        return head.data;
    }
    public void display()
    {
        if(isEmpty())
            throw new IllegalStateException();
        var current=head;
        while (current!=null)
        {
            System.out.print(current.data+" ");
            current=current.next;
        }
    }
}
