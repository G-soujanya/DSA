class CircularLinkedList {
    public static void main(String args[]) {
        CLL list = new CLL();
        //list.addLast(20);
        //list.addLast(30);
        //list.addLast(40);
        list.addFirstOptimaized(10);
        list.addLastOptimaized(20);
        list.addLastOptimaized(40);
        list.display();
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
}
