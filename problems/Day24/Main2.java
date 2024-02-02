import java.util.*;
public class Main2 {
    public static void main(String args[])
    {
//        System.out.println(isValid("{)}"));
//        System.out.println(reverse("this sky is blue"));
        System.out.println(speacialSub("ACBGAG"));
    }
    public static int isValid(String str)
    {
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if(ch=='{' || ch=='(' || ch=='[')
                stack.push(ch);
            else if(ch=='}' || ch==')' || ch==']')
            {
                if(!stack.isEmpty())
                {
                    char ch1=stack.peek();
                    if((ch==')' && ch1!='(') || (ch=='}' && ch1!='{') || (ch==']' && ch1!='['))
                        return 0;
                }
                else
                    return 0;
                stack.pop();
            }
        }
        return 1;
    }
    public static int speacialSub(String str)
    {
        int count=0;
        for (int i = 0; i < str.length()-1; i++) {
            char ch=str.charAt(i);
            if(ch=='A') {
                for (int j = i + 1; j < str.length(); j++) {
                    if(str.charAt(j)=='G')
                        count++;
                }
            }
        }
        return count;
    }
    public static String reverse(String str)
    {
        String revStr="";
        String tempStr;
        for (int i = str.length()-1; i >=0; i--) {
            tempStr="";
            char ch=str.charAt(i);
            if(ch==' ')
                i++;
            else
            {
                int j;
                for (j = i; j >=0; j--) {
                    if(str.charAt(j)==' ' && j>=1 && str.charAt(j-1)!=' ')
                        break;
                }
                for (int k = j+1; k <=i ; k++) {
                    tempStr+=str.charAt(k);
                }
                if(revStr.isEmpty())
                    revStr+=tempStr;
                else
                    revStr+=" "+tempStr;
                i=j;
            }
        }
        return revStr;
    }

}
