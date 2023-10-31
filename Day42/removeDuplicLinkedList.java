import java.util.*;
import java.util.HashSet;
class removeDuplicLinkedList 
{
    public static void main(String args[])
    {
        LinkedList list=new LinkedList();
        list.addLast(1);
        list.addLast(1);
        list.addLast(10);
        list.addLast(20);
        list.addLast(10);
        list.display();
        list.removeDuplicatesHashSet();
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

class LinkedList
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
            System.out.print(current.data+" ");
            current = current.address;
        }
        System.out.println();
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
                prev.address=prev.address.address;
                current.address=null;
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
}