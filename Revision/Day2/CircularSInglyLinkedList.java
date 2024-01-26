public class CircularSInglyLinkedList {
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
    int count=0;
    public boolean isEmpty()
    {
        return head==null;
    }
    public void addFirst(int value)
    {
        Node node=new Node(value);
        if(isEmpty())
        {
            head=node;
            node.next=node;
        }
        else
        {
            var current=head;
            while (current.next!=head)
            {
                current=current.next;
            }
            current.next=node;
            node.next=head;
            head=node;
        }
        count++;
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
    public void addLast(int value)
    {
        Node node=new Node(value);
        if(isEmpty())
        {
            head=node;
            node.next=node;
        }
        else
        {
            var current=head;
            while (current.next!=head)
                current=current.next;
            Node temp=current.next;
            current.next=node;
            node.next=temp;
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
            Node temp = head;
            head = head.next;
            Node current = head;
            while (current.next != temp) {
                current = current.next;
            }
            current.next = head;
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
            var current=head;
            while (current.next.next!=head)
            {
                current=current.next;
            }
            current.next=head;
        }
        count--;
    }
    public void addFirstOptimaized(int value)
    {
        Node node=new Node(value);
        if(isEmpty())
        {
            head=node;
            node.next=node;
        }
        else
        {
            node.next=head.next;
            head.next=node;
            int temp=node.data;
            node.data=head.data;
            head.data=temp;
        }
        count++;
    }
    public void addLastOptimaized(int value)
    {
        Node node=new Node(value);
        if(isEmpty())
        {
            head=node;
            node.next=node;
        }
        else
        {
            node.next=head.next;
            head.next=node;
            int temp=node.data;
            node.data=head.data;
            head.data=temp;
            head=head.next;
        }
    }
    public void removeFirstoptimaized()
    {
        if(head.next==head)
            head=null;
        else
        {
            int temp=head.next.data;
            head.next.data=head.data;
            head.data=temp;
            head.next=head.next.next;
        }
    }
    public void insertAtRightPos(int value)
    {

        if(head.data>value)
        {
            addFirst(value);
        }
        else
        {
            var current=head;
            Node prev=null;
            while (current.next!=head && current.data<value)
            {
                prev=current;
                current=current.next;
            }
            Node node = new Node(value);
            if(current.data<value)
                addLast(value);
            else if(prev!=null) {
                node.next = prev.next;
                prev.next = node;
            }
            else {
                node.next=current.next;
                current.next=node;
            }
        }
    }
    public void removeLastUsingRecursion(Node node)
    {
        if(node==null)
            throw new IllegalStateException();
        if(node.next==head) {
            head = null;
            return;
        }
        else if(node.next.next==head)
        {
            node.next=node.next.next;
            return;
        }
        removeLastUsingRecursion(node.next);
    }
    public void reverse()
    {
        if(isEmpty())
            throw new IllegalStateException();
        Node prev=null;
        Node current=head;
        do
        {
            Node nextNode=current.next;
            current.next=prev;
            prev=current;
            current=nextNode;
        }while (current!=head);
        head.next=prev;
        head=prev;
    }
}