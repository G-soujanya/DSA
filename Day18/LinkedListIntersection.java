import java.util.*;
class LinkedListIntersection
{
    public static void main(String args[])
    {
        linkedlist list1=new linkedlist();
        linkedlist list2=new linkedlist();
        /*list1.addLast(10);
        list1.addLast(20);
        list1.addLast(30);
        list2.addLast(40);
        list2.head.address=list1.head.address.address;*/
        /*list2.addLast(3);
        list2.addLast(6);
        list2.addLast(9);
        list1.addLast(10);
        list1.addLast(15);
        list1.addLast(30);
        list2.head.address.address.address=list1.head.address;
        //System.out.println(intersectionUsingHashSet(list1, list2));
        intersectionUsingLength(list1,list2);*/
        list1.addLast(1);
        list1.addLast(3);
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(4);
        list2.addLast(3);
        list2.head.address=list1.head.address.address.address;
        intersectionUsingLength(list1, list2);
        //System.out.println(intersectionUsingHashSet(list1, list2));

    }
    static node intersection(linkedlist l1,linkedlist l2)
    {
        int size1=l1.getSize();
        int size2=l2.getSize();
        if(size1>size2)
        {
        var current1=l1.head;
        var current2=l2.head;
        while(current1!=null)
        {
            if(current1.address==current2.address)
                return current1.address;
            else 
            {
                current1=current1.address;
            }
        }
        }
        else 
        {
            var current1=l1.head;
            var current2=l2.head;
            while(current2!=null)
            {
                if(current1.address==current2.address)
                    return current2.address;
                else 
                {
                current2=current2.address;
                }
            }
        }
        return null;
    }
    static int intersectionUsingHashSet(linkedlist l1,linkedlist l2)
    {
        int size1=l1.getSize();
        int size2=l2.getSize();
        Set<node> set=new HashSet<>();
        if(size1<size2)
        {
            var current=l1.head;
            while(current!=null)
            {
                set.add(current.address);
                current=current.address;
            }
            var current2=l2.head;
            while(current2!=null){
                if(set.contains(current2.address))
                {
                    return current2.address.data;
                }
                current2=current2.address;
            }
        }
        else 
        {
            var current2=l2.head;
            while(current2!=null)
            {
                set.add(current2.address);
                current2=current2.address;
            }
            var current1=l1.head;
            while(current1!=null)
            {
                if(set.contains(current1.address))
                    return current1.address.data;
                current1=current1.address;
            }
        }
        return -1;
    }
    static void intersectionUsingLength(linkedlist l1,linkedlist l2)
    {
        int size1=l1.getSize();
        int size2=l2.getSize();
        int size;
        if(size1>size2)
        {
            size=size1-size2;
            l1.reversekthElementWithOutSize(size);
        }
        else 
        {
            size=size2-size1;
            l2.reversekthElementWithOutSize(size);
        }
    }
}
class node {
    int data;
    node address;

    node(int d) {
        data = d;
    }
}

class linkedlist 
{
    node head;
    node tail;

    void addLast(int d) {
        node node = new node(d);
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
        node node = new node(d);
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
            node temp;
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
    void reversekthElementWithOutSize(int index) {
        node slow = head;
        node fast = head;
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
        System.out.println(slow.data);
    }
}