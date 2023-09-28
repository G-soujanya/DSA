import java.util.*;
class LinkedList2 
{
    public static void main(String args[])
    {
        linkedlist2 list=new linkedlist2();
        list.addLast(1);
        //list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        //list.addLast(10);
        linkedlist2 list1=new linkedlist2();
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        //list.addLast(8);
        list.intersection(list1);
        //list.modify();
        //list.display();
    }    
}
class Node {
    int data;
    Node address;

    Node(int d) {
        data = d;
    }
}

class linkedlist2 
{
    Node head;
    Node tail;

    void addLast(int d) {
        Node node = new Node(d);
        if (head == null) {
            head = tail = node;
        } else {
            tail.address = node;
            tail = node;
        }
    }

    void display() {
        var current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.address;
        }
    }

    void addFirst(int d) {
        Node node = new Node(d);
        if (head == null)
            head = tail = node;
        else {
            node.address = head;
            head = node;
        }
    }

    void removeFirst() {
        if (head == null)
            throw new IllegalStateException();
        else if (head == tail)
            head = tail = null;
        else {
            Node temp;
            temp = head.address;
            head.address = null;
            head = temp;
        }
    }

    int getSize() {
        int count = 0;
        var current = head;
        while (current != null) {
            count++;
            current = current.address;
        }
        return count;
    }

    boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }

    boolean contains(int value) {
        var current = head;
        if (head == null) {
            throw new IllegalArgumentException();
        }
        while (current != null) {
            if (current.data == value)
                return true;
            current = current.address;
        }
        return false;
    }

    int indexOf(int value) {
        int count = 0;
        var current = head;
        while (current != null) {
            if (current.data == value)
                return count;
            count++;
            current = current.address;
        }
        return -1;
    }

    int valueOf(int index) {
        if (index < 0 | index >= getSize()) {
            throw new IllegalStateException();
        }
        int ind = 0;
        var current = head;
        while (current != null) {
            if (ind == index)
                return current.data;
            ind++;
            current = current.address;

        }
        return -1;
    }

    void removeLast() {
        var current = head;
        while (current.address != tail) {
            current = current.address;
        }
        current.address = null;
    }
    void removeDuplicatesHashSet()
    {
        var current=head;
        Set<Integer> set=new HashSet<>();
        Node prev=null;
        while(current!=null)
        {
            if(set.contains(current.data))
            {
                Node temp=prev.address;
                prev.address=prev.address.address;
                temp.address=null;
                current=prev.address;
            }
            else 
            {
                prev=current;
                set.add(current.data);
                current=current.address;
            }
        }
    }
    void displayLastKElements(int k)
    {
        if(k<0 || k>getSize())
            throw new IllegalArgumentException();
        k=getSize()-k;
        var current=head;
        int start=0;
        while(start!=k)
        {
            current=current.address;
            start++;
        }
        while(current!=null)
        {
            System.out.println(current.data);
            current=current.address;
        }
    }
    void removeDuplicate()
    {
        var current=head;
        var current1=head;
        while(current!=null)
        {
            while(current1.address!=null)
            {
                if(current.data==current1.address.data)
                {
                    var temp=current1.address.address;
                    current1.address.address=null;
                    current1.address=temp;
                }
                else 
                {
                    current1=current1.address;
                }
            }
            current=current.address;
            current1=current;
        }
    }
    boolean palindrom()
    {
        Node slow=head;
        Node fast=head;
        StringBuilder str=new StringBuilder();
        while(fast.address!=null && fast.address.address!=null)
        {
            str.append(slow.data);
            slow=slow.address;
            fast=fast.address.address;
        }
        StringBuilder str1=new StringBuilder();
        if(fast.address==null)
        {
            slow=slow.address;
            while(slow!=null)
            {
                str1.append(slow.data);
                slow=slow.address;
            }
        }
        else
        {
            str.append(slow.data);
            slow=slow.address;
            while(slow!=null)
            {
                str1.append(slow.data);
                slow=slow.address;
            }
        }
        //System.out.println(str);
        //System.out.println(str1.reverse());
        if(str.compareTo(str1.reverse())==0)
            return true;
        return false;
    }
    void displayLastkElementWithOutSize(int index) {
        Node slow = head;
        Node fast = head;
        for (int i = 1; i < index; i++) {
            fast = fast.address;
            if (fast == null) {
                throw new IllegalArgumentException();
            }
        }
        while (fast != null && fast.address != null) {
            slow = slow.address;
            fast = fast.address;
        }
        while(slow!=null)
        {
            System.out.println(slow.data);
            slow=slow.address;
        }
    }
    void revPrinting(Node node)
    {
        if(node==null)
            return;
        revPrinting(node.address);
        System.out.println(node.data);
    }
    void count(int data)
    {
        int count=0;
        var current=head;
        while(current!=null)
        {
            if(current.data==data)
                count++;
            current=current.address;
        }
        System.out.println(count);
    }
    void intoCircularLinkedList()
    {
        Node temp=head;
        var current=head;
        while(current.address!=null)
        {
            current=current.address;
        }
        current.address=temp;
    }
    boolean circularOrNot()
    {
        Node temp=head;
        var current=head;
        while(current!=null)
        {
            if(current.address==temp)
                return true;
            current=current.address;
        }
        return false;
    }
    void exchangeFirstLast()
    {
        Node temp=head.address;
        Node temp3=head;
        var current=head;
        while(current.address.address!=null)
        {
            current=current.address;
        }
        Node temp2=current.address;
        temp3.address=null;
        current.address=temp3;
        head=temp2;
        temp2.address=temp;
    }
    static linkedlist2 createLoop() {
        var l = new linkedlist2();
        l.addLast(10);
        l.addLast(20);
        var temp = l.tail;
        l.addLast(30);
        l.addLast(40);
        l.addLast(50);
        l.tail.address=temp;
        return l;
    }

    boolean containsLoop() {
        Set<Node> h = new HashSet<>();
        var current = head;
        while (current != null) {
            if (h.contains(current))
                return true;
            h.add(current);
            current = current.address;
        }
        return false;
    }
    void removeLoop()
    {
        Set<Node> h = new HashSet<>();
        var current = head;
        while (current != null) {
            if (h.contains(current))
                current.address=null;
            h.add(current);
            current = current.address;
        }
    }
    void lengthOfLoop()
    {
        Set<Node> h = new HashSet<>();
        Node temp=null;
        var current = head;
        while (current != null) {
            if (h.contains(current.address))
            {
                temp=current.address;
                current.address=null;
            }
            h.add(current);
            current = current.address;
        }
        int i=0;
        temp=temp.address;
        while(temp!=null)
        {
            i++;
            temp=temp.address;
        }
        System.out.println(i);
    }
    void removeDuplicates()
    {
        var current=head;
        while(current!=null)
        {
            if(current.data==current.address.data)
                current.address=current.address.address;
            current=current.address;
        
        }
    }
    void delete(Node pointer)
    {
        var current=head;
        while(current!=null)
        {
            if(current.address==pointer)
                current.address=current.address.address;
            current=current.address;
        }
    }
    void reverse() {
        if (isEmpty())
            return;
        var current = head;
        Node next = null;
        Node previous = null;
        while (current != null) {
            next = current.address;
            current.address = previous;
            previous = current;
            current = next;
        }
        tail = head;
        tail.address = null;
        head = previous;
    }
    void modify()
    {
        Node slow=head;
        Node fast=head;
        while(fast.address!=null && fast.address.address!=null)
        {
            slow=slow.address;
            fast=fast.address.address;
        }
        int size=getSize();
        Node head2=head;
        head=slow.address;
        slow.address=null;
        reverse();
        var current=head2;
        var current1=head;
        if(size%2==0)
        {
        while(current1.address!=null && current.address!=null)
        {
            current.data=current.data-current1.data;
            current1=current1.address;
            current=current.address;
        }
        current.data=current.data-current1.data;
        }
        else 
        {
            while(current1!=null && current!=null)
        {
            current.data=current.data-current1.data;
            current1=current1.address;
            current=current.address;
        }
        }
        reverse();
        current.address=head;
        head=head2;
    }
    void intersection(linkedlist2 l)
    {
        var current=head;
        linkedlist2 lo=new linkedlist2();
        while(current!=null)
        {
            var c=l.head;
            while(c!=null)
            {
                if(current.data==c.data)
                {
                    lo.addLast(c.data);

                }
                c=c.address;
            }
            current=current.address;
        }
        lo.display();
    }
}
