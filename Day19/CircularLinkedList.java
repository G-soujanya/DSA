class CircularLinkedList {
    public static void main(String args[]) {
        CLL list = new CLL();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.splitIntoTwo();
    }
}

class Node {
    int data;
    Node address;

    Node(int value) {
        data = value;
    }
}

class CLL {
    Node head;

    boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }

    void addFirst(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            node.address = node;
        } else {
            var current = head;
            while (current.address != head) {
                current = current.address;
            }
            node.address = head;
            head = node;
            current.address = head;
        }
    }

    void display() {
        if(isEmpty())
            throw new IllegalStateException("no elements in the list");
        var current = head;
        do {
            System.out.println(current.data);
            current = current.address;
        } while (current != head);
    }

    void addLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            node.address = node;
        } else {
            var current = head;
            while (current.address != head) {
                current = current.address;
            }
            current.address = node;
            node.address = head;
        }
    }
    void removeFirst()
    {
        if(isEmpty())
            throw new IllegalStateException("no elements in the list");
        if(head==head.address)
        {
            head=null;
            return;
        }
        else{
        var current = head;
            while (current.address != head) {
                current = current.address;
            }
            head=head.address;
            current.address = head;
        }
    }
    void removeLast()
    {
        if(isEmpty())
            throw new IllegalStateException("no elements in the list");
        if(head==head.address)
        {
            head=null;
            return;
        }
        var current = head;
        Node prev=null;
            while (current.address != head) {
                prev=current;
                current = current.address;
            }
        prev.address=head;
    }
    void addFirstOptimaized(int value)
    {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            node.address = node;
        } else 
        {
            int temp=node.data;
            node.data=head.data;
            head.data=temp;
            node.address=head.address;
            head.address=node;
        }
    }
    void addLastOptimaized(int value)
    {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            node.address = node;
        } else 
        {
            int temp=node.data;
            node.data=head.data;
            head.data=temp;
            node.address=head.address;
            head.address=node;
            head=node;
        }
    }
    void removeFirstOptimized()
    {
        if(isEmpty())
            throw new IllegalStateException("no elements in the list");
        if(head==head.address)
        {
            head=null;
            return;
        }
        else
        {
            var temp=head.address;
            head.data=head.address.data;
            head.address=head.address.address;
            temp.address=null;
        }
    }
    void inserAtRightPosition(int data)
    {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            node.address = node;
        } else if(head.data>data)
        {
            int temp=node.data;
            node.data=head.data;
            head.data=temp;
            node.address=head.address;
            head.address=node;
        }
        else
        {
            var current=head;
            Node prev=null;
            while(current!=null && current.data<data)
            {
                prev=current;
                current=current.address;
            }
            node.address=prev.address;
            prev.address=node;
        }
    }
    void removeLastRecursion(Node node)
    {
        if(node==null)
        {
            throw new IllegalStateException();
        }
        if(node.address==head)
        {
            head=null;
            return;
        }
        if(node.address.address==head)
        {
            node.address=head;
            return;
        }
        removeLastRecursion(node.address);
    }   
    void reverse()
    {
        if(isEmpty())
            throw new IllegalStateException();
        var current1 = head;
            while (current1.address != head) {
                current1 = current1.address;
            }
        Node prev=current1;
        Node next=null;
        Node current=head;
        do
        {
            next=current.address;
            current.address=prev;
            prev=current;
            current=next;
        }while(current!=head);
        head=prev;
    }
    void splitIntoTwo()
    {
        Node slow=head;
        Node fast=head;
        Node head2;
        while(fast.address!=head && fast.address.address!=head)
        {
            slow=slow.address;
            fast=fast.address.address;
        }   
        if(fast.address==head)
        {
            head2=slow.address;
            slow.address=head;
            fast.address=head2;
        }
        else 
        {
            head2=slow.address;
            slow.address=head;
            fast=fast.address;
            fast.address=head2;
        }
        var current2=head;
        do
        {
            System.out.print(current2.data);
            current2=current2.address;
        }while(current2!=head);
        System.out.println("");
        var current=head2;
        do
        {
            System.out.print(current.data);
            current=current.address;
        }while(current!=head2);
        System.out.println("");
    }
}
