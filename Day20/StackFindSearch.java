import java.util.EmptyStackException;

class StackFindSearch 
{
    public static void main(String args[])
    {
        Stack stack=new Stack();
        //System.out.println(stack.palindrome("1221"));
        //System.out.println(palindrome("12216"));
        int []a={5,1,2,12,9};
        nearestSmallestElement(a);
    }
    static boolean palindrome(String str)
    {
        Stack stack=new Stack();
        int count=0;
        while(count<str.length()/2)
        {
            stack.push((int)str.charAt(count));
            count++;
        }
        if(str.length()%2!=0)
            count=count+1;
        while(!stack.isEmpty())
        {
            if(stack.pop()!=(int)str.charAt(count))
                return false;
            count++;
        }
        return true;
    }    
    static void nearestSmallestElement(int[] a)
    {   
        Stack s=new Stack();
        for(int i=0;i<a.length;i++)
        {
            if(!s.isEmpty() && s.peek()>a[i])
                s.pop(); 
            if(s.isEmpty())
                System.out.print("-1 ");
            else 
                System.out.print(s.peek()+" ");
            s.push(a[i]);
        }
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
    boolean search(int element)
    {
        if(isEmpty())
            throw new EmptyStackException();
        Stack stack2=new Stack();
        int x;
        boolean exist=false;
        for(int i=top;i>=0;i--)
        {
            if(stack[i]==element)
            {
                exist=true;
                break;
            }
            else
            {
                x=pop();
                stack2.push(x);
            }
        }
        for(int j=stack2.top;j>=0;j--)
        {
            int y=stack2.pop();
            push(y);
        }
        if(exist==true)
        {
            return true;
        }
        else 
            return false;
    }
    int find(int index)
    {
        if(index<0 || index>top)
        {
            throw new IllegalArgumentException("invalid index");
        }
        Stack stack2=new Stack();
        int x;
        int start=0;
        for(int i=top;i>=0;i--)
        {
            if(start==index)
            {
                for(int j=stack2.top;j>=0;j--)
                {
                    int y=stack2.pop();
                    push(y);
                }
                return stack[i];
            }
            x=pop();
            stack2.push(x);
            start++;
        }
        return -1;
    }
}
