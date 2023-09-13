class StackImplementation 
{
    public static void main(String args[])
    {
        System.out.println(expressionEvalution("{}([]6+)"));
    }    
    static boolean expressionEvalution(String str)
    {
        Stack stack=new Stack();
        char a[]=new char[str.length()];
        for(int i=0;i<str.length();i++)
        {
            a[i]=str.charAt(i);
        }
        for(var ch:a)
        {
            if(ch=='(' || ch=='{' || ch=='[' || ch=='<')
            {
                stack.push(ch);
            }
            char top=' ';
            if(ch==')' || ch=='}' || ch==']' || ch=='>')
            {
                if(stack.isEmpty()) 
                    return false;
                top=stack.pop();
                if((ch==')' && top!='(') || (ch=='}' && top!='{') || (ch==']' && top!='[') || (ch=='>' && top!='<'))
                {
                    return false;
                }
            }
        }
        return true;
    }
}

class Stack
{
    char[] stack=new char[5];
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
    void push(char data)
    {
        if(isFull())
            throw new IllegalStateException();
        top++;
        stack[top]=data;
    }
    char pop()
    {
        if(isEmpty())
            throw new IllegalStateException();
        char element=stack[top];
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
