import java.util.HashSet;
import java.util.Set;

class LinkedList {
    public static void main(String args[]) {
        // linkedlist list=new linkedlist();
        /*
         * list.addLast(10);
         * list.display();
         * list.addFirst(20);
         * list.removeFirst();
         * list.display();
         * System.out.println(list.getSize());
         * System.out.println(list.isEmpty());
         * System.out.println(list.contains(20));
         * System.out.println(list.indexOf(20));
         * System.out.println(list.valueOf(10));
         */
        // list.removeLast();
        // list.display();
        // list.reverse();
        // list.display();
        // System.out.println(list.nextNode(20));
        // System.out.println(list.nextNode(30));
        // System.out.println(list.prevNode(20));
        // System.out.println(list.getElement(4));
        // System.out.println(list.getElementReverse(8));
        // System.out.println(list.getMiddleElement());
        // System.out.println(list.nextNextNode(30));
        // System.out.println(list.getPrevPrevNode(50));
        // list.display();
        // list.addFirst(10);
        // list.addLast(20);
        // list.addLast(20);
        // list.addLast(10);
        // int[] a={10,20,30};
        // list.addManyLast(a);
        // list.addManyFirst(a);
        // list.clearLinkedList();
        // list.display();
        // list.getMiddleElementWithoutSize();
        // list.reversekthElementWithOutSize(3);
        // System.out.println(list.lastIndex(10));
        // list.addAt(2, 2);
        // list.removeAt(1);
        // list.display();
        // list.BinToDec();
        // list.BinToDecStart();
        // System.out.println(list.getSize());
        // list.kthElementFromFirst(2);

        /*
         * linkedlist list;
         * list=linkedlist.createLoop();
         * System.out.println(list.containsLoop());
         */
        linkedlist list = new linkedlist();
        // list.addLast(10);
        // list.addLast(20);
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.removeAtRecursive(list.head,3);
        list.display();
        //linkedlist evenfirst;
        //evenfirst=list.evenFrist();
        //evenfirst.display();
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

    void reverse() {
        if (isEmpty())
            return;
        var current = head;
        node next = null;
        node previous = null;
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

    int nextNode(int value) {
        if (isEmpty())
            return -1;
        if (contains(value)) {
            var current = head;
            while (current.address != null) {
                if (current.data == value)
                    return current.address.data;
                current = current.address;
            }
            return -1;
        } else {
            throw new IllegalArgumentException();
        }
    }

    int prevNode(int value) {
        if (isEmpty())
            return -1;
        if (contains(value)) {
            var current = head;
            node prev = null;
            while (current != null) {
                if (current.data == value)
                    if (current.data == head.data)
                        return -1;
                    else
                        return prev.data;
                prev = current;
                current = current.address;
            }
            return -1;
        } else {
            throw new IllegalArgumentException();
        }
    }

    int getElement(int k) {
        int count = 0;
        var current = head;
        while (current != null) {
            if (count == k)
                return current.data;
            count++;
            current = current.address;
        }
        return -1;
    }

    int getElementReverse(int k) {
        int size = getSize();
        int count = 0;
        int kr = size - k;
        var current = head;
        while (current != null) {
            if (count == kr)
                return current.data;
            count++;
            current = current.address;
        }
        return -1;
    }

    int getMiddleElement() {
        int size = getSize();
        int k = size / 2;
        if (size % 2 == 1) {
            return valueOf(k);
        } else {
            return valueOf(k) + valueOf(k - 1);
        }
    }

    int nextNextNode(int value) {
        var current = head;
        while (current != null) {
            if (current.data == value) {
                return current.address.address.data;
            }
            current = current.address;
        }
        return -1;
    }

    int getPrevPrevNode(int value) {
        var current = head.address.address;
        node prev = head.address;
        node prevprev = head;
        while (current != null) {
            if (current.data == value)
                return prevprev.data;
            prevprev = prev;
            prev = current;
            current = current.address;
        }
        return -1;
    }

    void addManyLast(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.addLast(array[i]);
        }
    }

    void clearLinkedList() {
        head = tail = null;
    }

    void addManyFirst(int array[]) {
        for (int i = 0; i < array.length; i++) {
            this.addFirst(array[i]);
        }
    }

    void reversekthElementWithOutSize(int index) {
        node slow = head;
        node fast = head;
        for (int i = 0; i < index; i++) {
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

    void getMiddleElementWithoutSize() {
        if (isEmpty())
            throw new IllegalStateException();
        if (head == null) {
            System.out.println(head.data);
            return;
        } else if (head.address == tail) {
            System.out.println(head.data + " " + head.address.data);
        } else {
            node slow = head;
            node fast = head;
            while (fast != tail && fast.address != tail) {
                slow = slow.address;
                fast = fast.address.address;
            }
            if (fast == tail) {
                System.out.println(slow.data);
            } else {
                System.out.println(slow.data + " " + slow.address.data);
            }
        }
    }

    int lastIndex(int value) {
        int index = 0;
        int start = 0;
        var current = head;
        while (current != null) {
            if (current.data == value)
                index = start;
            start++;
            current = current.address;
        }
        return index;
    }

    void addAt(int index, int value) {
        var current = head;
        int start = 0;
        if (index < 0 || index > getSize())
            throw new IllegalArgumentException("index is not valid");
        node n = new node(value);
        while (current != null) {
            if (start == index - 1) {
                n.address = current.address;
                current.address = n;
            }
            current = current.address;
            start++;
        }
    }

    void removeAt(int index) {
        var current = head;
        int start = 0;
        while (current != null) {
            if (start == index - 1) {
                current.address = current.address.address;
            }
            current = current.address;
            start++;
        }
    }

    void BinToDec() {
        int result = 0;
        var current = head;
        while (current != null) {
            result = result * 2 + current.data;
            current = current.address;
        }
        System.out.println(result);
    }

    void BinToDecStart() {
        int size = getSize() - 1;
        int result = 0;
        var current = head;
        while (current != null) {
            result += current.data * Math.pow(2, size);
            size--;
            current = current.address;
        }
        System.out.println(result);
    }

    void kthElementFromFirst(int index) {
        int start = 0;
        var current = head;
        while (current != null) {
            if (start == index) {
                System.out.println(current.data);
            }
            start++;
            current = current.address;
        }
    }

    static linkedlist createLoop() {
        var l = new linkedlist();
        l.addLast(10);
        l.addLast(20);
        var temp = l.tail;
        l.addLast(30);
        // l.tail.address=temp;
        return l;
    }

    boolean containsLoop() {
        Set<node> h = new HashSet<>();
        var current = head;
        while (current != null) {
            if (h.contains(current))
                return true;
            h.add(current);
            current = current.address;
        }
        return false;
    }

    // recursion
    void traverse(node n) {
        if (n == null)
            return;
        System.out.println(n.data);
        traverse(n.address);
    }

    void insertLast(node n, int value) {
        if (n == null || n.address == null) {
            node nodenew = new node(value);
            if (n == null) {
                head = nodenew;
                return;
            }
            n.address = nodenew;
            tail = nodenew;
            return;
        }
        insertLast(n.address, value);
    }
    void removeAtRecursive(node n,int index)
    {
        if(isEmpty())
            throw new IllegalStateException();
        if(index==0)
        {
            removeFirst();
            return;
        }
        if(index==1)
        {
            if(head==tail)
            {
                head=null;
                return;
            }
            node temp=n.address;
            n.address=n.address.address;
            temp.address=null;
            return;
        }
        index--;
        removeAtRecursive(n.address, index);
    }
    linkedlist evenFrist()
    {
        linkedlist even=new linkedlist();
        linkedlist odd=new linkedlist();
        var current=head;
        while(current!=null)
        {
            if(current.data%2==0)
            {
                even.addLast(current.data);
            }
            else
            {
                odd.addLast(current.data);
            }
            current=current.address;
        }
        if(even.head!=null && odd.head!=null)
            even.tail.address=odd.head;
        if(even.head!=null)
            return even;
        return odd;
    }
}