public class ExpressionEvalution {
    StackImplementation stack=new StackImplementation();
    public boolean expressionEvalution(String str)
    {
        for (int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[' || ch=='<')
            {
                stack.push(ch);
            }
            else if(ch==')' || ch=='}' || ch==']' || ch=='>') {
                if(stack.isEmpty())
                    return false;
                if ((ch == ')' && stack.peek() != '(') || (ch == '}' && stack.peek() != '{') || (ch == ']' && stack.peek() != '[') || (ch == '>' && stack.peek() != '<'))
                    return false;
                stack.pop();
            }
        }
        return true;
    }
}
