class StackImplementation 
{
    public static void main(String args[])
    {
        Stack stack=new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.pop());
        stack.display();
        //System.out.println(stack.peek());
    }    
}
class Stack
{
    int[] stack=new int[5];
    int top=-1;
    boolean isEmpty()
    {
        if(top==-1)
            return true;
        return false;
    }
    boolean isFull()
    {
        if(top==5)
            return true; 
        return false;
    }
    void push(int data)
    {
        if(isFull())
            throw new IllegalStateException();
        top++;
        stack[top]=data;
    }
    int pop()
    {
        if(isEmpty())
            throw new IllegalStateException();
        int element=stack[top];
        top--;
        return element;
    }
    int peek()
    {
        return stack[top];
    }
    void display()
    {
        for(int i=top;i>=0;i--)
        {
            System.out.println(stack[i]);
        }
    }
}
