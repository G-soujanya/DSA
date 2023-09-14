class TwoStacks 
{
    public static void main(String args[])
    {
        Stack stack=new Stack(10);
        stack.push1(10);
        stack.push1(15);
        stack.push1(16);
        stack.push1(17);
        stack.push1(18);
        System.out.println("Stack1");
        stack.display1();
        stack.push2(20);
        stack.push2(30);
        stack.push2(40);
        stack.push2(50);
        stack.push2(60);
        System.out.println("Stack2");
        stack.display2();
        System.out.println("Removed element from peek1");
        System.out.println(stack.pop1());
        System.out.println("stack1 peek");
        System.out.println(stack.peek1());
        System.out.println("Removed element from peek2");
        System.out.println(stack.pop2());
        System.out.println("stack2 peek");
        System.out.println(stack.peek2());
    }    
}
class Stack
{
    int[] stack;
    int top1;
    int top2;
    Stack(int size)
    {
        stack=new int[size];
        top1=-1;
        top2=size;
    }
    void push1(int data)
    {
        if(isFull1())
            throw new IllegalStateException();
        stack[++top1]=data;
    }
    void push2(int data)
    {
        if(isFull2())
            throw new IllegalStateException();
        stack[--top2]=data;
    }
    void display1()
    {
        if(isEmpty1())
            throw new IllegalStateException();
        for(int i=0;i<=top1;i++)
        {
            System.out.print(stack[i]+" ");
            System.out.println("");
        }
    }
    void display2()
    {
        if(isEmpty2())
            throw new IllegalStateException();
        for(int i=stack.length-1;i>=top2;i--)
        {
            System.out.print(stack[i]+" ");
            System.out.println("");
        }
    }
    int peek1()
    {
        if(isEmpty1())
            throw new IllegalStateException();
        return stack[top1];
    }
    int peek2()
    {
        if(isEmpty2())
            throw new IllegalStateException();
        return stack[top2];
    }
    int pop1()
    {
        if(isEmpty1())
            throw new IllegalStateException();
        int top=stack[top1];
        top1--;
        return top;
    }
    int pop2()
    {
        if(isEmpty2())
            throw new IllegalStateException();
        int top=stack[top2];
        top2++;
        return top;
    }
    boolean isEmpty1()
    {
        return top1==-1;
    }
    boolean isEmpty2()
    {
        return top2==stack.length;
    }
    boolean isFull1()
    {
        return top1==top2-1;
    }
    boolean isFull2()
    {
        return top2==top1+1;
    }
}
