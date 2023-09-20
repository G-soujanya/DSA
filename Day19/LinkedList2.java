import java.util.*;
class LinkedList2 
{
    public static void main(String args[])
    {
        linkedlist2 list=new linkedlist2();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(35);
        list.addLast(25);
        list.addLast(20);
        //list.removeDuplicate();
        //list.display();
        //list.displayLastkElementWithOutSize(4);
        //list.display();
        //System.out.println(list.palindrom());
        //list.revPrinting(list.head);
        //list.count(10);
        //list.intoCircularLinkedList();
        //System.out.println(list.circularOrNot());
        list.exchangeFirstLast();
        list.display();
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
}
