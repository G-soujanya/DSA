import java.util.HashSet;
import java.util.Set;

class doublyLinkedList 
{
    public static void main(String args[])
    {
        doublyLinkedlist list=new doublyLinkedlist();
        list.addAtLast(1);
        list.addAtLast(0);
        list.addAtLast(1);
        //list.addAtLast(0);
        //list.addAtLast(1);
        System.out.println(list.palindrom());
        list.traverse(list.head);
    }    
}
class node
{
    node prev;
    int data;
    node next;
    node(int data)
    {
        this.data=data;
    }
}
class doublyLinkedlist 
{
    node head;
    node tail;
    int count;
    void addAtFirst(int value)
    {
        node n=new node(value);
        count++;
        if(head==null)
        {
            head=tail=n;
        }
        else 
        {
            n.next=head;
            head.prev=n;
            head=n;
        }
    }
    void display()
    {
        var current=head;
        while(current!=null)
        {
            System.out.println(current.data);
            current=current.next;
        }
    }
    void addAtLast(int value)
    {
        node n=new node(value);
        count++;
        if(head==null)
        {
            head=tail=n;
        }
        else 
        {
            n.prev=tail;
            tail.next=n;
            tail=n;
        }
    }
    boolean isEmpty()
    {
        if(head==null)
            return true;
        return false;
    }
    void removeAtFirst()
    {
        
        if(isEmpty())
            throw new IllegalStateException();
        count--;
        head.next.prev=null;
        head=head.next;
    }
    void removeAtLast()
    {
        
        if(isEmpty())
        {
            throw new IllegalStateException();
        }
        count--;
        tail.prev.next=null;
        tail=tail.prev;
    }
    int getSize()
    {
        return count;
    }
    void addAtIndex(int index,int value)
    {
        int start=0;
        var current=head;
        node n=new node(value);
        count++;
        while(current!=null)
        {
            if(start==index-1)
            {
                n.prev=current;
                n.next=current.next;
                current.next=n;
                current.next.prev=n;

            }
            start++;
            current=current.next;
        }
    }
    void removeAtIndex(int index)
    {
        if(isEmpty())
            throw new IllegalStateException();
        var current=head;
        int start=0;
        if(index==start)
        {
            removeAtFirst();
            return;
        }
        if(index==getSize()-1)
        {
            removeAtLast();
            return;
        }
        while(current!=null)
        {
            if(start==index-1)
            {
                current.next=current.next.next;
                current.next.prev=current;
            }
            start++;
            current=current.next;
        }
        count--;
    }
    void addManyAtFirst(int[] array)
    {
        for(int i=0;i<array.length;i++)
        {
            this.addAtFirst(array[i]);
        }
    }
    void addManyAtLast(int[] array)
    {
        for(int i=0;i<array.length;i++)
        {
            this.addAtLast(array[i]);
        }
    }
    boolean contains(int value)
    {
        var current=head;
        while(current!=null)
        {
            if(current.data==value)
            {
                return true;
            }
            current=current.next;
        }
        return false;
    }
    int indexOf(int value)
    {
        if(isEmpty())
            throw new IllegalStateException();
        if(contains(value)==false)
            throw new IllegalArgumentException();
        int start=0;
        var current=head;
        while(current!=null)
        {
            if(current.data==value)
                return start;
            start++;
            current=current.next;
        }
        return -1;
    }
    int valueOf(int index)
    {
        if(index<0 || index>getSize()-1)
            throw new IllegalArgumentException();
        int start=0;
        var current=head;
        while(current!=null)
        {
            if(start==index)
                return current.data;
            start++;
            current=current.next;
        }
        return -1;
    }
    void reverse()
    {
        if(isEmpty())
            throw new IllegalStateException();
        var current=head;
        node prevNode=null;
        node nextNode=null;
        while(current!=null)
        {
            nextNode=current.next;
            current.prev=current.next;
            current.next=prevNode;
            prevNode=current;
            current=nextNode;
        }
        tail=head;
        head=prevNode;
    }
    int nextNode(int value)
    {
        if(isEmpty())
            return -1;
        if(contains(value)==false)
            throw new IllegalArgumentException();
        var current=head;
        while(current!=null)
        {
            if(current==tail)
                throw new IllegalArgumentException("no next node");
            if(current.data==value)
                return current.next.data;
            current=current.next;
        }
        return 0;
    }
    int prevNode(int value)
    {
        if(isEmpty())
            return -1;
        if(contains(value)==false)
            throw new IllegalArgumentException();
        if(value==head.data)
            throw new IllegalArgumentException();
        var current=head;
        node prev=null;
        while(current!=null)
        {
            if(current.data==value)
            {
                return prev.data;
            }
            prev=current;
            current=current.next;
        }
        return -1;
    }   
    int getElementInReverse(int index)
    {
        if(index<0 || index>getSize()-1)
            throw new IllegalArgumentException();
        int start=0;
        var current=tail;
        while(current!=null)
        {
            if(start==index)
                return current.data;
            start++;
            current=current.prev;
        }
        return 0;
    }
    int getMiddleElement()
    {
        if(isEmpty())
            throw new IllegalStateException();
        int size=getSize()-1;
        int index=size/2;
        if(size%2==0)
        {
            return valueOf(index);
        }
        else 
        {
            return valueOf(index)+valueOf(index+1);
        }
    }
    int nextNextNode(int value)
    {
        if(isEmpty())
            throw new IllegalStateException(); 
        var current=head;
        while(current!=null)
        {
            if(current.data==value)
            {
                if(current.next!=null && current.next.next!=null)
                {
                    return current.next.next.data;
                }
                else 
                {
                    return -1;
                }
            }
            current=current.next;
        }
        return -1;
    }
    int getPrevPrevNode(int value)
    {
        if(isEmpty())
            throw new IllegalStateException(); 
        var current=head;
        while(current!=null)
        {
            if(current.data==value)
            {
                if(current.prev!=null && current.prev.prev!=null)
                {
                    return current.prev.prev.data;
                }
                else 
                {
                    return -1;
                }
            }
            current=current.next;
        }
        return -1;
    }
    void clearLinkedList()
    {
        head=tail=null;
    }
    int reversekthElementWithOutSize(int index)
    {
        node slow=head;
        node fast=head;
        for(int i=0;i<index;i++)
        {
            fast=fast.next;
            if(fast==null)
            {
                throw new IllegalArgumentException();
            }
        }
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow.data;
    }
    void getMiddleElementWithoutSize()
    {
        if(isEmpty())
            throw new IllegalStateException();
        if(head==null)
        {
            System.out.println(head.data);
            return;
        }
        else if(head.next==tail)
        {
            System.out.println(head.data+" "+head.next.data);
        }
        else
        {
        node slow=head;
        node fast=head;
        while(fast!=tail && fast.next!=tail)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast==tail)
            System.out.println(slow.data);
        else 
            System.out.println(slow.data+" "+slow.next.data);
        }
    }
    int lastIndexOf(int value)
    {
        if(contains(value)==false)
            throw new IllegalArgumentException();
        int start=0;
        var current=tail;
        int size=getSize()-1;
        while(current!=null)
        {
            if(current.data==value)
                return size-start; 
            start++;
            current=current.prev;
        }
        return 0;
    }
    void BinToDec()
    {
        int result=0;
        var current=head;
        while(current!=null)
        {
            result=result*2+current.data;
            current=current.next;
        }
        System.out.println(result);
    }
    static doublyLinkedlist createLoop()
    {
        doublyLinkedlist d=new doublyLinkedlist();
        d.addAtFirst(10);
        d.addAtLast(30);
        var temp=d.tail;
        d.addAtLast(40);
        d.tail.next=temp;
        return d;
    }
    boolean containsLoop()
    {
        Set<node> set=new HashSet<>();
        var current=head;
        while(current!=null)
        {
            if(set.contains(current))
                return true;
            set.add(current);
            current=current.next;
        }
        return false;
    }
    void traverse(node n)
    {
        if(n==null)
            return;
        System.out.println(n.data);
        traverse(n.next);
    }
    void insertLast(node n,int value)
    {
        if(n==null || n.next==null)
        {
            node nodenew=new node(value);
            count++;
            if(n==null)
            {
                head=nodenew;
                return;
            }
            n.next=nodenew;
            nodenew.prev=n;
            tail=nodenew;
            return;
        }
        insertLast(n.next,value);
    }
    void insertAtRightPosition(int data)
    {
        node n=new node(data);
        count++;
        if(head==null)
        {
            head=tail=n;
        }
        else if(head.data>data)
        {
            n.next=head;
            head.prev=n;
            head=n;
        }
        else 
        {
            var current=head;
            node previous=null;
            while(current.data<data)
            {
                previous=current;
                current=current.next;
            }
            n.prev=previous;
            n.next=previous.next;
            previous.next.prev=n;
            previous.next=n;
        }
    }
    boolean palindrom()
    {
        var current=head;
        var last=tail;
        while(current!=last && current.next!=last)
        {
            if(current.data!=last.data)
            {
                return false;
            }
            current=current.next;
            last=last.prev;
        }
        return true;
    }
}