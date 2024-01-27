import javax.swing.plaf.DimensionUIResource;

public class DoublyLinkedList {
    private class Node
    {
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
    public void addFirst(int value)
    {
        Node node=new Node(value);
        if(head==null)
            head=node;
        else
        {
            node.next=head;
            head.prev=node;
            head=node;
        }
        count++;
    }
    public void display()
    {
        var current=head;
        while (current!=null)
        {
            System.out.println(current.data);
            current=current.next;
        }
    }
    public void addLast(int value)
    {
        Node node=new Node(value);
        if(head==null)
            head=node;
        else
        {
            var current=head;
            while (current.next!=null)
            {
                current=current.next;
            }
            current.next=node;
            node.prev=current;
        }
        count++;
    }
    public boolean isEmpty()
    {
        return head==null;
    }
    public void removeFirst()
    {
        if(isEmpty())
            throw new IllegalStateException();
        head=head.next;
        head.prev=null;
        count--;
    }
    public void removeLast()
    {
        if(isEmpty())
            throw new IllegalStateException();
        var current=head;
        while (current.next.next!=null)
        {
            current=current.next;
        }
        current.next.prev=null;
        current.next=null;
        count--;
    }
    public int getSize()
    {
        return count;
    }
    public void addAtIndex(int index,int value)
    {
        if(index<0 || index>getSize())
            throw new IllegalStateException();
        var current=head;
        int count=1;
        Node node=new Node(value);
        while (count!=index)
        {
            count++;
            current=current.next;
        }
        current.prev.next=node;
        node.prev=current.prev;
        node.next=current;
        current.prev=node;
    }
    public void removeAtIndex(int index)
    {
        if(isEmpty() ||index<0 || index>getSize())
            throw new IllegalStateException();
        if(index==1)
            removeFirst();
        else if(index==getSize())
            removeLast();
        else {
            var current = head;
            int count = 1;
            while (count != index) {
                count++;
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.next = null;
            current.prev = null;
        }
    }
    public void addManyAtFirst(int arr[])
    {
        for(int x:arr)
            addFirst(x);
    }
    public void addManyAtLast(int arr[])
    {
        for(int x:arr)
            addLast(x);
    }
    public boolean contains(int value)
    {
        if(isEmpty())
            throw new IllegalStateException();
        var current=head;
        while (current!=null)
        {
            if(current.data==value)
                return true;
            current=current.next;
        }
        return false;
    }
    public int indexOf(int value)
    {
        if(isEmpty() || !contains(value))
            throw new IllegalStateException();
        int count=1;
        var current=head;
        while (current!=null)
        {
            if(current.data==value)
                return count;
            current=current.next;
            count++;
        }
        return -1;
    }
    public int valueOf(int index)
    {
        if(isEmpty() || index<0 || index>getSize())
            throw new IllegalStateException();
        int count=1;
        var current=head;
        while (current!=null)
        {
            if(count==index)
                return current.data;
            current=current.next;
            count++;
        }
        return -1;
    }
    public void reverse()
    {
        if(isEmpty())
            throw new IllegalStateException();
        Node current=head;
        Node prev=null;
        while (current!=null)
        {
            prev=current;
            Node temp1=current.next;
            Node temp=current.prev;
            current.prev=current.next;
            current.next=temp;
            current=temp1;
        }
        head=prev;
    }
    public int nextNode(int value)
    {
        if(!contains(value))
            throw new IllegalStateException();
        var current=head;
        while (current.next!=null)
        {
            if(current.data==value)
                return current.next.data;
            current=current.next;

        }
        return -1;
    }
    public int prevNode(int value)
    {
        if(!contains(value) || head.data==value)
            throw new IllegalStateException();
        var current=head.next;
        while (current!=null)
        {
            if(current.data==value)
                return current.prev.data;
            current=current.next;
        }
        return -1;
    }
    public int getElementInReverse(int index)
    {
        if(isEmpty())
            throw new IllegalStateException();
        var slow=head;
        var fast=head;
        int count=1;
        while (count!=index) {
            fast = fast.next;
            count++;
        }
        while (fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow.data;
    }
    public int getMiddleEle()
    {
        if(isEmpty())
            throw new IllegalStateException();
        var slow=head;
        var fast=head;
        while (fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }
    public int nextNextNode(int value)
    {
        if(isEmpty() || !contains(value))
            throw new IllegalStateException();
        var current=head;
        while (current.next.next!=null)
        {
            if(current.data==value)
                return current.next.next.data;
            current=current.next;
        }
        return -1;
    }
    public int prevPrevNode(int value)
    {
        if(isEmpty() || !contains(value) || head.data==value || head.next.data==value)
            throw new IllegalStateException();
        var current=head.next.next;
        while (current!=null)
        {
            if(current.data==value)
                return current.prev.prev.data;
            current=current.next;
        }
        return -1;
    }
    public void clearLinkedList()
    {
        head=null;
    }
    public int lastIndexOf(int value)
    {
        if(isEmpty() || !contains(value))
            throw new IllegalStateException();
        int index=0;
        int count=0;
        var current=head;
        while (current!=null)
        {
            if(current.data==value)
                index=count;
            count++;
            current=current.next;
        }
        return index;
    }
    public void traverse(Node node)
    {
        if(node==null)
            return;
        System.out.println(node.data);
        traverse(node.next);
    }
    public void insertAtLast(int value,Node n)
    {
        if(n.next==null)
        {
            Node node=new Node(value);
            n.next=node;
            node.prev=n;
            return;
        }
        insertAtLast(value,n.next);
    }
    public boolean palindromeOrNot()
    {
        var current=head;
        Node tail=null;
        while (current.next!=null)
        {
            current=current.next;
        }
        tail=current;
        var current1=head;
        while (current1!=tail || current1.next==tail)
        {
            if(current.data!=tail.data)
                return  false;
            current1=current1.next;
            tail= tail.prev;
        }
        return true;
    }
    public boolean palindromeWithoutSize()
    {
        if(isEmpty())
            return true;
        Node fast=head;
        Node slow=head;
        while (fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        fast=fast.next;
        var current=head;
        while (current!=slow)
        {
            if(fast.data!=current.data)
                return false;
            current=current.next;
            fast=fast.prev;
        }
        return true;
    }
}


