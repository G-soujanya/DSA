import java.util.HashSet;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dl=new DoublyLinkedList();
        dl.addLast(10);
        dl.addLast(20);
        dl.addLast(20);
        dl.addLast(10);
        System.out.println(dl.palindromeOrNot());
    }
}

class LinkedList
{
    private int size=0;
    Node head;
    private Node tail;
    public class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
        }
    }
    public void display()
    {
        if(head==null)
            throw new IllegalStateException();
        Node currentNode=head;
        while(currentNode!=null)
        {
            System.out.println(currentNode.data);
            currentNode=currentNode.next;
        }
    }
    public void addFirst(int value)
    {
        size++;
        Node node=new Node(value);
        if(head==null)
            head=tail=node;
        else
        {
            node.next=head;
            head=node;
        }
    }
    public void addLast(int value)
    {
        size++;
        Node node=new Node(value);
        if(head==null)
            head=tail=node;
        else
        {
            tail.next=node;
            tail=node;
        }
    }
    public void removeFirst()
    {
        if(head==null)
            throw new IllegalStateException();
        size--;
        Node tempNode=head;
        head=head.next;
        tempNode.next=null;
    }
    public int getSize()
    {
        int count=0;
        Node currentNode=head;
        while (currentNode!=null)
        {
            count++;
            currentNode=currentNode.next;
        }
        return count;
    }
    public int getSizeUsingSize()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return head==null;
    }
    public boolean contains(int value)
    {
        if(isEmpty())
            throw new IllegalStateException();
        Node currentNode=head;
        while (currentNode!=null)
        {
            if(currentNode.data==value)
                return true;
            currentNode=currentNode.next;
        }
        return false;
    }
    public int indexOf(int value)
    {
        if(isEmpty())
            throw new IllegalStateException();
        Node currentNode=head;
        int count=0;
        while (head!=null)
        {
            if(currentNode.data==value)
                return count;
            count++;
            currentNode=currentNode.next;
        }
        return -1;
    }
    public int valueOf(int index)
    {
        if(isEmpty() || index>=size)
            throw new IllegalStateException();
        int count=0;
        Node currentNode=head;
        while (currentNode!=null)
        {
            if(count==index)
                return currentNode.data;
            count++;
            currentNode=currentNode.next;
        }
        return -1;
    }
    public void removeLast()
    {
        if(isEmpty())
            throw new IllegalStateException();
        Node currentNode=head;
        while (currentNode.next!=tail)
        {
            currentNode=currentNode.next;
        }
        currentNode.next=null;
        size--;
    }
    public void reverse()
    {

        Node currentNode=head;
        Node prev=null;
        while (currentNode!=null)
        {
            Node nextNode=currentNode.next;
            currentNode.next=prev;
            prev=currentNode;
            currentNode=nextNode;
        }
        tail=head;
        head=prev;
    }
    public int nextNode(int value)
    {
        if(!contains(value))
            throw new IllegalStateException();
        Node currentNode=head;
        while (currentNode.next!=null)
        {
            if(currentNode.data==value)
                return currentNode.next.data;
            currentNode=currentNode.next;
        }
        return -1;
    }
    public int prevNode(int value)
    {
        if(!contains(value))
            throw  new IllegalStateException();
        Node currentNode=head;
        while (currentNode.next!=null)
        {
            if(currentNode.next.data==value)
                return currentNode.data;
            currentNode=currentNode.next;
        }
        return -1;
    }
    public int getElement(int k)
    {
        int count=0;
        var currentNode=head;
        while (currentNode!=null)
        {
            if(count==k)
                return currentNode.data;
            currentNode=currentNode.next;
            count++;
        }
        return -1;
    }
    public int getElementReverse(int k)
    {
        int count1=getSize()-k;
        int count=0;
        var currentNode=head;
        while (currentNode!=null)
        {
            if(count==count1)
                return currentNode.data;
            currentNode=currentNode.next;
            count++;
        }
        return -1;
    }
    public int getElementMiddle()
    {
        int k=(getSize()-1)/2;
        return getElement(k);
    }
    public int nextNextNode(int value)
    {
        if(head==null)
            throw new IllegalStateException();
        var currentNode=head;
        while (currentNode.next.next!=null)
        {
            if(currentNode.data==value)
                return currentNode.next.next.data;
            currentNode=currentNode.next;
        }
        return -1;
    }
    public int prevPrevNode(int value)
    {
        if(head==null)
            throw new IllegalStateException();
        var cuurentNode=head;
        while (cuurentNode.next.next!=null)
        {
            if(cuurentNode.next.next.data==value)
                return cuurentNode.data;
            cuurentNode=cuurentNode.next;
        }
        return -1;
    }
    public void addMany(int arr[])
    {
        for (int i = 0; i < arr.length; i++) {
            addLast(arr[i]);
        }
    }
    public void clear()
    {
        head=tail=null;

    }
    public void addManyFirst(int arr[])
    {
        for (int i = 0; i < arr.length; i++) {
            addFirst(arr[i]);
        }
    }

    public int reverseKthElementWithoutSize(int k)
    {
        if(isEmpty())
            throw new IllegalStateException();
        var slow=head;
        var fast=head;
        int count=1;
        while (count!=k)
        {
            fast=fast.next;
            if(fast==null)
                throw new IllegalStateException();
            count++;
        }
        while (fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow.data;
    }
    public int getMiddleEleWithoueSize()
    {
        var slow=head;
        var fast=head;
        while (fast.next.next!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }
    public void removeAt(int index)
    {
        if(index<0 || index>getSize())
            throw new IllegalStateException();
        var current=head;
        if(index==1)
            removeFirst();
        else
        {
            Node prev=null;
            int count = 1;
            while (count < index) {
                count++;
                prev=current;
                current = current.next;
            }
            prev.next = prev.next.next;
        }
    }
    public int lastIndexOf(int value)
    {
        if(!contains(value) || isEmpty())
            throw new IllegalStateException();
        int index=1;
        int lastIndex=1;
        var current=head;
        while (current!=null)
        {
            if(current.data==value)
                lastIndex=index;
            index++;
            current=current.next;
        }
        return lastIndex;
    }
    public void addAt(int index,int value)
    {
        if(index<0 || index>getSize())
            throw new IllegalStateException();
        int count=1;
        var current=head;
        while (count<index)
        {
            current=current.next;
            count++;
        }
        Node n=new Node(value);
        n.next=current.next;
        current.next=n;
    }
    public int binaryToDecimal()
    {
        int decimal=0;
        int value;
        int count=getSize();
        var current=head;
        while (current!=null)
        {
            value=1;
            if(current.data==1)
            {
                for (int i = 1; i <count; i++) {
                    value*=2;
                }
                decimal+=value;
            }
            count--;
            current=current.next;
        }
        return decimal;
    }
    public int binToDecWithoutSize()
    {
        int decimal=0;
        var current=head;
        while (current!=null)
        {
            decimal=decimal*2+current.data;
            current=current.next;
        }
        return decimal;
    }
    public static LinkedList createLoop()
    {
        var l=new LinkedList();
        l.addLast(10);
        l.addLast(20);
        var temp=l.tail;
        l.addLast(30);
        //l.tail.next=temp;
        return l;
    }
    boolean containsLoop(LinkedList l)
    {
        Set<Node> set=new HashSet<>();
        var current=l.head;
        while (current!=null)
        {
            if(set.contains(current))
                return true;
            set.add(current);
            current=current.next;
        }
        return false;
    }
    public void traverse(Node node)
    {
        if(node==null)
            return;
        System.out.println(node.data);
        traverse(node.next);
    }
    public void inertAtLast(int value,Node node)
    {
        if(node.next==null)
        {
            Node n=new Node(value);
            node.next=n;
            return;
        }
        inertAtLast(value,node.next);
    }
    public void removeAtRecursive(Node node,int index)
    {
        if(isEmpty())
            throw new IllegalStateException();
        if(index==1)
        {
            removeFirst();
            return;
        }
        if(index==2)
        {
            Node temp = node.next;
            node.next = node.next.next;
            temp.next = null;
            return;
        }
        index--;
        removeAtRecursive(node.next,index);
    }
    public LinkedList evenFirst()
    {
        LinkedList even=new LinkedList();
        var current=head;
        while (current!=null)
        {
            if(current.data%2==0) {
                even.addLast(current.data);
            }
            current=current.next;
        }
        var current1=head;
        while (current1!=null)
        {
            if (current1.data%2==1)
            {
                even.addLast(current1.data);
            }
            current1=current1.next;
        }
        return even;
    }
    public LinkedList addTwoLinkedList(LinkedList l1)
    {
        if(l1.head==null)
            return this;
        if(this.head==null)
            return this;
        var current=head;
        while(current.next!=null)
        {
            current=current.next;
        }
        current.next=l1.head;
        return this;
    }
    public void reverseUptokElements(int k)
    {
        if(isEmpty())
            throw new IllegalStateException();
        if(k<0 || k>getSize())
            throw new IllegalArgumentException();
        int start=0;
        Node prev=null;
        Node current=head;
        Node nextNode=null;
        while (start!=k)
        {
            nextNode=current.next;
            current.next=prev;
            prev=current;
            current=nextNode;
            start++;
        }
        head.next=nextNode;
        head=prev;
    }
    public Node segregation()
    {
        Node evenStart=null;
        Node oddStart=null;
        Node evenEnd=null;
        Node oddEnd=null;
        Node current=head;
        while (current!=null)
        {
            if(current.data%2==0)
            {
                if(evenStart==null)
                    evenStart=evenEnd=current;
                else
                {
                    evenEnd.next=current;
                    evenEnd=current;
                }
            }
            else
            {
                if(oddStart==null)
                    oddEnd=oddStart=current;
                else
                {
                    oddEnd.next=current;
                    oddEnd=current;
                }
            }
            current=current.next;
        }
        if(evenStart!=null && evenEnd!=null)
        {
            evenEnd.next=oddStart;
            oddEnd.next=null;
            return evenStart;
        }
        if(evenStart==null)
            return oddStart;
        if(oddStart==null)
            return evenStart;
        return head;
    }
    public void removeDuplicatesUsingHashSet()
    {
        Set<Integer> set=new HashSet<>();
        var current=head;
        Node prev=null;
        while (current!=null)
        {
            if(set.contains(current.data))
            {
                prev.next=prev.next.next;
                current=current.next;
            }
            else {
                prev=current;
                set.add(current.data);
                current=current.next;
            }

        }
    }
    public void displayLastKElements(int k)
    {
        if(k<0 && k>getSize())
            throw new IllegalArgumentException();
        int start=1;
        int count=getSize()-k;
        var current=head;
        while (start<=count)
        {
            current=current.next;
            start++;
        }
        while (current!=null)
        {
            System.out.println(current.data);
            current=current.next;
        }
    }
    public void displayLastKElementsWithoutSize(int k)
    {
        if(k<0 || k>getSize())
            throw new IllegalArgumentException();
        Node slow=head;
        Node fast=head;
        for (int i = 1; i < k; i++) {
            fast=fast.next;
            if(fast==null)
                throw new IllegalStateException();
        }
        while (fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        while (slow!=null)
        {
            System.out.println(slow.data);
            slow=slow.next;
        }
    }
    public void removeDuplicates()
    {
        if(isEmpty())
            throw new IllegalStateException();
        var current=head;
        var current1=head;
        while (current!=null)
        {
            while (current1.next!=null)
            {
                if(current.data==current1.next.data)
                {
                    current1.next=current1.next.next;
                }
                else {
                    current1=current1.next;
                }
            }
            current=current.next;
            current1=current;
        }
    }
    public boolean palindrome()
    {
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        var current=head;
        slow=slow.next;
        while (slow!=null)
        {
            if(current.data!=slow.data)
                return false;
            current=current.next;
            slow=slow.next;
        }
        return true;
    }
}