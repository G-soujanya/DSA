import java.util.*;
public class Main {
    public static void main(String[] args) {
    System.out.println(infixToPostfix("k+l-m*n+(o^p)*w/u/v*t+q"));
    }
    static String infixToPostfix(String str)
    {
        Stack<Character> stack=new Stack<>();
        String result="";
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(Character.isLetter(ch))
                result+=ch;
            else if(ch=='(')
            {
                stack.push(ch);
            }
            else if(ch==')')
            {
                while(stack.peek()!='(')
                {
                    result+=stack.pop();
                }
                if(!stack.isEmpty())
                    stack.pop();
            }
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    result += stack.pop();
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty())
            result+=stack.pop();
        return result;
    }
    static int precedence(char ch)
    {
        if(ch=='^')
            return 3;
        else if(ch=='*' || ch=='/')
            return 2;
        else if(ch=='+' || ch=='-')
            return 1;
        return 0;
    }
}
