public class CircularDoublyLinkedList {
    private class Node{
        Node prev;
        int data;
        Node next;
        public Node(int value)
        {
            data=value;
        }
    }
    Node head;
    int count=0;
    public boolean isEmpty()
    {
        return head==null;
    }
    public void display()
    {
        if(isEmpty())
            throw new IllegalStateException();
        var current=head;
        do {
            System.out.println(current.data);
            current=current.next;
        }while (current!=head);
    }
    public void addFirst(int value)
    {
        Node node=new Node(value);
        if (head==null)
        {
            head=node;
            node.next=node;
            node.prev=node;
        }
        else
        {
            var current=head;
            do {
                current=current.next;
            }while (current.next!=head);
            Node temp=head.prev;
            node.next=head;
            head.prev=node;
            node.prev=temp;
            current.next=node;
        }
        count++;
    }
    public void addLast(int value)
    {
        Node node=new Node(value);
        if (head==null)
        {
            head=node;
            node.next=node;
            node.prev=node;
        }
        else
        {
            Node current=head;
            do {
                current=current.next;
            }while (current.next!=head);
            current.next=node;
            node.prev=current;
            node.next=head;
            head.prev=node;
        }
        count++;
    }
    public void removeFirst()
    {
        if(isEmpty())
            throw new IllegalStateException();
        if(head.next==head)
            head=null;
        else {
            var current = head;
            while (current.next != head)
            {
                current=current.next;
            }
            head=head.next;
            head.prev=current;
            current.next=head;
        }
        count--;
    }
    public void removeLast()
    {
        if(isEmpty())
            throw new IllegalStateException();
        if(head.next==head)
            head=null;
        else
        {
            var current = head;
            while (current.next.next!= head)
            {
                current=current.next;
            }
            current.next=current.next.next;
            head.prev=current.next;
        }
        count--;
    }
    public void addFirstOptimaized(int value)
    {
        Node node=new Node(value);
        if(head==null)
        {
            head=node;
            node.next=node;
            node.prev=node;
        }
        else {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            node.data = head.data;
            head.data = value;
        }
        count++;
    }
    public void addLastOptimaized(int value)
    {
        Node node=new Node(value);
        if(head==null)
        {
            head=node;
            node.next=node;
            node.prev=node;
        }
        else
        {
            node.next=head.next;
            head.next.prev=node;
            head.next=node;
            node.prev=head;
            node.data=head.data;
            head.data=value;

            head=head.next;
        }
        count++;
    }
    public void removeFirstOptimaized()
    {
        if(isEmpty())
            throw new IllegalStateException();
        if(head.next==head)
            head=null;
        else
        {
            head.data=head.next.data;
            head.next=head.next.next;
            head.next.next.prev=head;
        }
        count--;
    }
    public int getSize()
    {
        return count;
    }
    public void reverse()
    {
        if(isEmpty())
            throw new IllegalStateException();
        Node prev=head.prev;
        Node current=head;
        do {
            Node nextNode=current.next;
            current.next=prev;
            prev=current;
            current=nextNode;
        }while (current!=head);
        head=prev;
    }
}
