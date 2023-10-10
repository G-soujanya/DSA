import java.util.Scanner;
class SwapCases 
{
    public static void main(String args[])
    {
        String str="    how    are    you    ";
        /*System.out.println(toUpperCase(str));
        System.out.println(lowerToUpperViceVersa(str));
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the character");
        char k=sc.next().charAt(0);
        System.out.println(lastIndexOf(str, k));*/
        System.out.println(trimExtraSpaces(str));
    }     
    static String toUpperCase(String s)
    {
        String t="";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch>='a' && ch<'z')
            {
                t=t+(char)(ch-32);
            }
            else
            {
                t=t+ch;
            }
        }
        return t;
    }
    static String lowerToUpperViceVersa(String s)
    {
        String t="";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch>='a' && ch<'z')
            {
                t=t+(char)(ch-32);
            }
            else if(ch>='A' && ch<='Z')
            {
                t=t+(char)(ch+32);
            }
            else 
                t=t+ch;
        }
        return t;
    }
    static int indexOf(String s,char k)
    {
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch==k)
                return i;
        }
        return -1;
    }
    static int lastIndexOf(String s,char k)
    {
        for(int i=s.length()-1;i>=0;i--)
        {
            char ch=s.charAt(i);
            if(ch==k)
                return i;
        }
        return -1;
    }
    static String trim(String s)
    {
        String t="";
        int start=0;
        int last=s.length()-1;
        for(start=0;start<s.length();start++)
        {
            if(s.charAt(start)!=' ')
                break;
        }
        for(;last>=0;last--)
        {
            if(s.charAt(last)!=' ')
                break;
        }
        for(int i=start;i<=last;i++)
        {
            t+=s.charAt(i);
        }
        return t;
    }
    static String trimExtraSpaces(String s)
    {
        String t="";
        for(int i=0;i<s.length()-1;i++)
        {
            char ch=s.charAt(i);
            if(ch!=' ')
            {
                t+=ch;
            }
            else 
            {
                if(s.charAt(i+1)!=' ')
                {
                    t=t+ch;
                }
            }
        }
        return t;
    }
}