import java.util.EmptyStackException;

class stackUsingLinkedList 
{
    public static void main(String args[])
    {
        Stack stack=new Stack();
        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop());
        stack.display();
    }    
}
class Stack 
{
    private class Node 
    {
        int data;
        Node address;
        Node(int data)
        {
            this.data=data;
        }
    }
    Node top;
    void push(int data)
    {
        Node node=new Node(data);
        if(top==null)
        {
            top=node;
        }
        else 
        {
            node.address=top;
            top=node;
        }
    }
    void display()
    {
        var current=top;
        while(current!=null)
        {
            System.out.println(current.data);
            current=current.address;
        }
    }
    boolean isEmpty()
    {
        if(top==null)
            return true;
        return false;
    }
    int peek()
    {
        if(isEmpty())
            throw new EmptyStackException();
        return top.data;
    }
    int pop()
    {
        if(isEmpty())
            throw new EmptyStackException();
        Node x=top;
        top=top.address;
        x.address=null;
        return x.data;
    }
}